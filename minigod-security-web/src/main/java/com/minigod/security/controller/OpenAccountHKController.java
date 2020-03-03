package com.minigod.security.controller;


import com.minigod.common.exception.InternalApiException;
import com.minigod.common.exception.WebApiException;
import com.minigod.common.pojo.StaticType;
import com.minigod.common.pojo.request.BaseRequest;
import com.minigod.common.pojo.response.ResResult;
import com.minigod.security.annotation.LoginUser;
import com.minigod.security.protocol.enums.CubpMessageResource;
import com.minigod.security.protocol.vo.request.params.*;
import com.minigod.security.protocol.vo.response.OpenCacheDataResVo;
import com.minigod.security.protocol.vo.response.OpenImgResVo;
import com.minigod.security.service.OpenAccountOnlineHkService;
import com.minigod.security.service.OpenAccountService;
import com.minigod.security.service.VerifyService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/open_api_hk")
@Validated
@Slf4j
public class OpenAccountHKController {
    @Autowired
    private VerifyService verifyService;
    @Autowired
    private OpenAccountService openAccountService;
    @Autowired
    private OpenAccountOnlineHkService openAccountOnlineHkService;

    /**
     * 保存用户开户缓存数据
     */
    @PostMapping("/save_cache_info")
    public ResResult saveCacheHkInfo(@LoginUser Integer userId, @RequestBody BaseRequest<OpenCacheInfoReqParams> requestVo) {
        try {
            OpenCacheInfoReqParams params = requestVo.getParams();
            openAccountOnlineHkService.saveOrUpdateCacheInfoStep(userId, params);
            return ResResult.success();
        } catch (InternalApiException e) {
            throw new WebApiException(e.getCode(), e.getMessage(), e.getMessageResource());
        } catch (Exception e) {
            throw new WebApiException(StaticType.CodeType.DISPLAY_ERROR, CubpMessageResource.FAIL_SAVE_CACHE_INFO);
        }
    }

    /**
     * 保存用户开户图片数据
     */
    @PostMapping("/save_cache_img")
    public ResResult saveCacheHkImg(@LoginUser Integer userId, @RequestBody BaseRequest<OpenImgReqParams> requestVo) {
        try {
            OpenImgReqParams params = requestVo.getParams();
            OpenImgResVo res = openAccountOnlineHkService.saveOrUpdateImg(userId, params);
            return ResResult.success(res);
        } catch (InternalApiException e) {
            throw new WebApiException(e.getCode(), e.getMessage(), e.getMessageResource());
        } catch (Exception e) {
            throw new WebApiException(StaticType.CodeType.DISPLAY_ERROR, CubpMessageResource.FAIL_SAVE_CACHE_IMG);
        }
    }

    /**
     * 获取用户开户缓存数据
     */
    @PostMapping("/get_cache_data")
    public ResResult getCacheHkInfo(@LoginUser Integer userId, @RequestBody BaseRequest<OpenCacheDataReqParams> requestVo) {
        try {
            OpenCacheDataReqParams params = requestVo.getParams();
            OpenCacheDataResVo resVo = openAccountOnlineHkService.getCacheData(userId, params);
            return ResResult.success(resVo);
        } catch (InternalApiException e) {
            throw new WebApiException(e.getCode(), e.getMessage(), e.getMessageResource());
        } catch (Exception e) {
            throw new WebApiException(StaticType.CodeType.DISPLAY_ERROR, CubpMessageResource.FAIL_GET_CACHE_DATA);
        }
    }

    /**
     * 提交开户
     */
    @PostMapping("/submit_open_info")
    public ResResult submitOpenInfo(@LoginUser Integer userId, @RequestBody BaseRequest<OpenInfoReqParams> requestVo) {
        try {
            OpenInfoReqParams params = requestVo.getParams();
            openAccountService.saveOrUpdateOpenInfo(userId, params);
            return ResResult.success();
        } catch (InternalApiException e) {
            throw new WebApiException(e.getCode(), e.getMessage(), e.getMessageResource());
        } catch (Exception e) {
            throw new WebApiException(StaticType.CodeType.DISPLAY_ERROR, CubpMessageResource.FAIL_SUBMIT_OPEN_INFO);
        }
    }
}
