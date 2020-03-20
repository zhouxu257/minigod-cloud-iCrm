package com.minigod.account.service;

import com.minigod.protocol.account.cubp.vo.callback.CubpOpenInfoCallbackVo;
import com.minigod.protocol.account.vo.request.params.*;
import com.minigod.protocol.account.vo.response.OpenUserInfoResVo;
import org.springframework.cloud.netflix.feign.FeignClient;

import java.util.List;

@FeignClient(value = "minigod-account-service")
public interface OpenAccountService {
    public List<Object> getDictionaryData(DictionaryDataReqParams params);

    public Boolean isCanUpdateOpenInfo(Integer userId);

    public void saveOrUpdateOpenInfo(Integer userId, OpenInfoReqParams params);

    public void updateOpenInfo(CubpOpenInfoCallbackVo callbackVo);

    public OpenUserInfoResVo getOpenProgress(Integer userId, OpenProgressReqParams params);

    public Object ocrByCardType(Integer userId, OcrReqParams ocrReqParams);

    public Object ocrByImage(Integer userId, OpenImgReqParams ocrReqParams);

}
