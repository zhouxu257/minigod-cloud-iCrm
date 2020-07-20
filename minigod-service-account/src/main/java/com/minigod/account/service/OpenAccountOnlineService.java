package com.minigod.account.service;

import com.minigod.protocol.account.cubp.callback.CubpOpenInfoCallbackVo;
import com.minigod.protocol.account.model.CustomOpenInfo;
import com.minigod.protocol.account.pojo.VerifySzcaPojo;
import com.minigod.protocol.account.request.params.*;
import com.minigod.protocol.account.response.OpenUserInfoResVo;
import org.springframework.cloud.openfeign.FeignClient;

import java.util.List;

@FeignClient(value = "minigod-account-service")
public interface OpenAccountOnlineService {
    public List<Object> getDictionaryData(DictionaryDataReqParams params);

    public Boolean isCanUpdateOpenInfo(Integer userId);

    public void saveOrUpdateOpenInfo(Integer userId, OpenInfoReqParams params);

    public void updateOpenInfo(CubpOpenInfoCallbackVo callbackVo);

    public OpenUserInfoResVo getOpenProgress(Integer userId, OpenProgressReqParams params);

    public Object ocrByCardType(Integer userId, OcrReqParams ocrReqParams);

    public Object ocrByImage(Integer userId, OpenImgReqParams ocrReqParams);

    public void getCertDnBySzca(VerifySzcaPojo szcaPojo, CustomOpenInfo openInfo);

    public void getCertApplyP10BySzca(VerifySzcaPojo szcaPojo, CustomOpenInfo openInfo);

    public void getSignP7ForPdfBySzca(VerifySzcaPojo szcaPojo, CustomOpenInfo openInfo);

    public void getPdfInfoForSignBySzca(VerifySzcaPojo szcaPojo, CustomOpenInfo openInfo);

//    public SzcaSealPdfResVo getSealPdfBySzca(Integer userId);
}
