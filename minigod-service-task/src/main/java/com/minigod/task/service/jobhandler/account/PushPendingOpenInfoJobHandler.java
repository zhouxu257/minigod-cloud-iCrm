package com.minigod.task.service.jobhandler.account;

import com.alibaba.fastjson.JSONObject;
import com.google.common.collect.Lists;
import com.minigod.account.service.OpenAccountOnlineService;
import com.minigod.account.service.VerifyService;
import com.minigod.common.pojo.response.ResResult;
import com.minigod.common.utils.HttpClientUtils;
import com.minigod.persist.account.mapper.CustomOpenCnImgMapper;
import com.minigod.persist.account.mapper.CustomOpenHkImgMapper;
import com.minigod.persist.account.mapper.CustomOpenInfoMapper;
import com.minigod.persist.account.mapper.VerifyBankCardMapper;
import com.minigod.protocol.account.cubp.request.CubpOpenAccountAppointmentReqVo;
import com.minigod.protocol.account.cubp.request.CubpOpenAccountBankVerityInfoReqVo;
import com.minigod.protocol.account.cubp.request.CubpOpenAccountImageInfoReqVo;
import com.minigod.protocol.account.enums.CustomOpenAccountEnum;
import com.minigod.protocol.account.model.CustomOpenCnImg;
import com.minigod.protocol.account.model.CustomOpenHkImg;
import com.minigod.protocol.account.model.CustomOpenInfo;
import com.minigod.protocol.account.model.VerifyBankCard;
import com.xxl.job.core.biz.model.ReturnT;
import com.xxl.job.core.handler.IJobHandler;
import com.xxl.job.core.handler.annotation.JobHandler;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * 预批客户上传BPM
 */
@JobHandler(value = "pushPendingOpenInfoJobHandler")
@Component
@Slf4j
public class PushPendingOpenInfoJobHandler extends IJobHandler {
    @Autowired
    CustomOpenInfoMapper customOpenInfoMapper;
    @Autowired
    CustomOpenCnImgMapper customOpenCnImgMapper;
    @Autowired
    CustomOpenHkImgMapper customOpenHkImgMapper;
    @Autowired
    VerifyBankCardMapper verifyBankCardMapper;

    @Value("${minigod.cubp.url}")
    private String CUBP_API_URL;

    @Value("${minigod.openAccount.isVerifyOpenData}")
    private Boolean IS_VERIFY_OPEN_DATA;

    @Value("${minigod.openAccount.validConfidence}")
    private Double VALID_CONFIDENCE_VALUE;

    @Value("${minigod.openAccount.images.h5.type}")
    private String H5_OPEN_IMG_TYPE;

    @Value("${minigod.openAccount.images.h5.count}")
    private Integer H5_OPEN_IMG_COUNT;

    @Value("${minigod.openAccount.images.app.type}")
    private String APP_OPEN_IMG_TYPE;

    @Value("${minigod.openAccount.images.app.count}")
    private Integer APP_OPEN_IMG_COUNT;

    private static final String split = " | ";

    private void updageIdentityInfo(CubpOpenAccountAppointmentReqVo openInfo, String imgUrl) {

        // TODO: 调用公安系统，进行身份相识度识别
//        double confidence = IMAHttpClient.faceCompare(ST_IMG_UPLOAD , ST_IMG_FACECOMPARE , AUTHORIZATION , obj.getIdNo() , obj.getClientName() , imgUrl);
//        if (confidence < VALID_CONFIDENCE_VALUE) {
//            openInfo.setIsPassIdentityAuthentication(0);
//        } else {
//            openInfo.setIsPassIdentityAuthentication(1);
//        }

        openInfo.setIdentitySimilarityPercent(VALID_CONFIDENCE_VALUE);
        openInfo.setIsPassIdentityAuthentication(1);
    }

    private void saveErrorInfo(CustomOpenInfo customOpenInfo, String errorMsg, String body) {
        customOpenInfo.setUpdateTime(new Date());
        // 更新开户调度任务失败次数
        if (customOpenInfo.getPushErrCount() < 3) {
            customOpenInfo.setPushErrCount(customOpenInfo.getPushErrCount() + 1);
        } else {
            // 发送邮件
            if (!customOpenInfo.getIsSend()) {
                // 避免重复发送邮件，已发送邮件的不再发送
//                String title = "用户账号：" + customOpenInfo.getId() + " 开户任务异常";
//                errorMsg = errorMsg + "【" + body + "】";
                // TODO: 发送邮件通知
//                msgService.sendEmailCloud(sender, accept, title, errorMsg, null);
                customOpenInfo.setIsSend(true);
            }
        }
        customOpenInfoMapper.updateByPrimaryKeySelective(customOpenInfo);
    }

    private FileInputStream isRealImg(String imgUrl, Integer userId) throws IOException {
        FileInputStream fileInputStream = null;
        log.info("【预批客户上传BPM】传送的图片：userId=" + userId + ",imgUrl=" + imgUrl);

        try {
            fileInputStream = new FileInputStream(imgUrl);
            return fileInputStream;
        } catch (FileNotFoundException e) {
            log.error("【预批客户上传BPM】图片资源不存在：userId=" + userId + ",imgUrl=" + imgUrl);
            return null;
        } finally {
            if (fileInputStream != null) {
                fileInputStream.close();
            }
        }
    }


    @Override
    @Transactional(rollbackFor = Exception.class)
    public ReturnT<String> execute(String param) throws Exception {
        log.info("执行【预批客户上传BPM】调度任务");

        //查询开户信息
        List<CustomOpenInfo> openInfoList = customOpenInfoMapper.selectByIsNeedPush(true);
        if (null == openInfoList || openInfoList.size() <= 0) {
            log.info("*********************【预批客户上传BPM】为空**************************");
            return FAIL;
        }

        for (CustomOpenInfo customOpenInfo : openInfoList) {

            Integer userId = customOpenInfo.getId();
            Integer openStatus = customOpenInfo.getStatus();

            // 非开户中的跳出循环
            if (openStatus == null || !openStatus.equals(CustomOpenAccountEnum.OpenStatus.PENDING.getCode())) {
                continue;
            }

            // 同步错误次数过多
            if (customOpenInfo.getPushErrCount() >= 3 && customOpenInfo.getIsSend()) {
                log.error("*********************【预批客户上传BPM】开户同步异常超过3次**************************, userId = {}", userId);
                continue;
            }

            String idCard = customOpenInfo.getIdCard();
            String bankCard = customOpenInfo.getBankCard();
            Integer openType = customOpenInfo.getOpenType(); // 开户方式：1、线上预约开户，2、线下（开户宝）3、香港预约开户
            CubpOpenAccountAppointmentReqVo openInfo = JSONObject.parseObject(customOpenInfo.getFormdata(), CubpOpenAccountAppointmentReqVo.class);

            // 完善开户数据
            openInfo.setOpenAccountAccessWay(customOpenInfo.getAccessWay());
            openInfo.setApplicationTime(customOpenInfo.getUpdateTime());


            Integer accessWay = customOpenInfo.getAccessWay();

            // 开户图片数据
            List<CubpOpenAccountImageInfoReqVo> openAccountImageInfoProtocolList = Lists.newArrayList();
            String[] locationTypes = null;
            if (accessWay.equals(CustomOpenAccountEnum.OpenAccessWay.H5.getCode())) {
                locationTypes = H5_OPEN_IMG_TYPE.split(",");
            }
            if (accessWay.equals(CustomOpenAccountEnum.OpenAccessWay.APP.getCode())) {
                locationTypes = APP_OPEN_IMG_TYPE.split(",");
            }

            boolean isErrorImage = false;
            StringBuffer errorImages = new StringBuffer();

            // 处理图片数据-内地身份开户
            if (openType.equals(CustomOpenAccountEnum.OpenType.ONLINE_CN.getCode())) {
                List<CustomOpenCnImg> customOpenImgs = customOpenCnImgMapper.selectByUserIdAndLocationKeyInAndLocationTypeIn(userId, null, locationTypes);
                if (CollectionUtils.isNotEmpty(customOpenImgs)) {
                    for (CustomOpenCnImg customOpenImg : customOpenImgs) {
                        CubpOpenAccountImageInfoReqVo openAccountImageInfoProtocol = new CubpOpenAccountImageInfoReqVo();

                        Integer locationKey = Integer.parseInt(customOpenImg.getLocationKey());
                        Integer locationType = Integer.parseInt(customOpenImg.getLocationType());
                        String imgUrl = customOpenImg.getUrl();

                        // 内地用户人证比对
                        if (locationKey.equals(4) && (locationType.equals(401) || locationType.equals(402))) {
                            // 调用公安系统，进行身份相识度识别
                            updageIdentityInfo(openInfo, imgUrl);
                        }

                        // 图片校验
//                        if (isRealImg(imgUrl, userId) == null) {
//                            isErrorImage = true;
//                            // 记录错误图片
//                            errorImages.append(imgUrl).append(split);
//                        }

                        openAccountImageInfoProtocol.setImageLocation(locationKey);
                        openAccountImageInfoProtocol.setImageLocationType(locationType);
                        openAccountImageInfoProtocol.setImageUrl(imgUrl);
                        openAccountImageInfoProtocolList.add(openAccountImageInfoProtocol);

                    }
                } else {
                    log.error("*********************【预批客户上传BPM】CN开户图片数据不完整**************************, userId = {}", userId);
                    saveErrorInfo(customOpenInfo, "【预批客户上传BPM】开户图片数据不完整", "");
                    continue;
                }

            }
            // 处理图片数据-香港银行卡开户
            else if (openType.equals(CustomOpenAccountEnum.OpenType.ONLINE_HK.getCode())) {
                List<CustomOpenHkImg> customOpenImgs = customOpenHkImgMapper.selectByUserIdAndLocationKeyInAndLocationTypeIn(userId, null, locationTypes);
                if (CollectionUtils.isNotEmpty(customOpenImgs)) {
                    for (CustomOpenHkImg customOpenImg : customOpenImgs) {
                        CubpOpenAccountImageInfoReqVo openAccountImageInfoProtocol = new CubpOpenAccountImageInfoReqVo();

                        String imgUrl = customOpenImg.getUrl();

//                        // 图片校验
//                        if (isRealImg(imgUrl, userId) == null) {
//                            isErrorImage = true;
//                            // 记录错误图片
//                            errorImages.append(imgUrl).append(split);
//                        }

                        Integer locationKey = Integer.parseInt(customOpenImg.getLocationKey());
                        Integer locationType = Integer.parseInt(customOpenImg.getLocationType());

                        openAccountImageInfoProtocol.setImageLocation(locationKey);
                        openAccountImageInfoProtocol.setImageLocationType(locationType);
                        openAccountImageInfoProtocol.setImageUrl(imgUrl);
                        openAccountImageInfoProtocolList.add(openAccountImageInfoProtocol);

                    }
                } else {
                    log.error("*********************【预批客户上传BPM】HK开户图片数据不完整**************************, userId = {}", userId);
                    saveErrorInfo(customOpenInfo, "【预批客户上传BPM】开户图片数据不完整", "");
                    continue;
                }
            }
            if (isErrorImage) {
                log.error("*********************【预批客户上传BPM】图片错误**************************, userId = {}", userId);
                // 记录操作日志
                saveErrorInfo(customOpenInfo, "图片错误 : " + errorImages, "");
                continue;
            }
            openInfo.setOpenAccountImagesInfo(openAccountImageInfoProtocolList);

            // 处理四要素认证信息-内地身份开户仅有
            if (openType.equals(CustomOpenAccountEnum.OpenType.ONLINE_CN.getCode())) {
                // 四要素认证信息
                List<CubpOpenAccountBankVerityInfoReqVo> openAccountBankVerityInfoProtocols = Lists.newArrayList();

                List<VerifyBankCard> verifyBankCards = verifyBankCardMapper.selectByIdCard(idCard);
                if (CollectionUtils.isNotEmpty(verifyBankCards)) {
                    for (VerifyBankCard verifyBankCard : verifyBankCards) {
                        CubpOpenAccountBankVerityInfoReqVo openAccountBankVerityInfoProtocol = new CubpOpenAccountBankVerityInfoReqVo();
                        openAccountBankVerityInfoProtocol.setClientName(verifyBankCard.getUserName());
                        openAccountBankVerityInfoProtocol.setIdNo(verifyBankCard.getIdCard());
                        openAccountBankVerityInfoProtocol.setBankCard(verifyBankCard.getBankCard());
                        openAccountBankVerityInfoProtocol.setPhoneNumber(verifyBankCard.getPhone());
                        openAccountBankVerityInfoProtocol.setVerifyCount(verifyBankCard.getCheckCount());
                        openAccountBankVerityInfoProtocol.setVerifyStatus(verifyBankCard.getStatus());
                        openAccountBankVerityInfoProtocol.setVerityTime(new Date());
                        openAccountBankVerityInfoProtocols.add(openAccountBankVerityInfoProtocol);
                    }
                    openInfo.setBankVerityInfo(openAccountBankVerityInfoProtocols);
                }
            }


            try {
                log.info("*********************【预批客户上传BPM】回调开始**************************, userId = {}", userId);
                log.info(userId + "【预批客户上传BPM】回调传入数据：" + JSONObject.toJSONString(openInfo));
                // 调用cubp开户接口
                String server = CUBP_API_URL + "/proxy/customer/accountOpenApplication";
                Map<String, Object> map = new HashMap<String, Object>();
                map.put("params", openInfo);
                String result = HttpClientUtils.postJson(server, JSONObject.toJSONString(map), Charset.forName("UTF-8"), true);
                log.info(userId + "【预批客户上传BPM】返回结果：" + result);
                log.info("*********************【预批客户上传BPM】回调结束**************************, userId = {}", userId);

                if (StringUtils.isNotBlank(result)) {
                    ResResult responseVO = JSONObject.parseObject(result, ResResult.class);
                    if (responseVO.getCode() == 0) {
                        String applicationId = JSONObject.parseObject(responseVO.getResult().toString()).get("applicationId").toString();
                        customOpenInfo.setRemoteId(applicationId);
                        customOpenInfo.setIsNeedPush(false);
                        customOpenInfo.setPendingType(CustomOpenAccountEnum.PendingStatusType.APPROVE.getCode());
                        customOpenInfo.setUpdateTime(new Date());
                        customOpenInfoMapper.updateByPrimaryKeySelective(customOpenInfo);
                        log.info("【预批客户上传BPM】上传成功：" + userId);
                    } else {
                        log.info("【预批客户上传BPM】上传失败：" + userId + "," + responseVO.getMessage());
                        saveErrorInfo(customOpenInfo, responseVO.getMessage(), result);
                    }

                } else {
                    // 异常，记录操作日志
                    log.error("【预批客户上传BPM】连接服务器异常，CUBP返回结果为NULL！");
                    saveErrorInfo(customOpenInfo, "连接服务器异常，CUBP返回结果为NULL", result);
                }
            } catch (Exception e) {
                log.error("*********************【预批客户上传BPM】异常**************************,", e);
                // 异常，记录操作日志
                saveErrorInfo(customOpenInfo, "【预批客户上传BPM】异常", "服务器异常");
            }
            log.info("*********************结束用户【预批客户上传BPM】**************************, userId = {}", userId);
        }
        log.info("完成【预批客户上传BPM】调度任务");

        return SUCCESS;

    }
}
