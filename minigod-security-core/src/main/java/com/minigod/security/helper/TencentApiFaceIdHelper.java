package com.minigod.security.helper;

import com.alibaba.fastjson.JSON;
import com.tencentcloudapi.common.Credential;
import com.tencentcloudapi.common.exception.TencentCloudSDKException;
import com.tencentcloudapi.common.profile.ClientProfile;
import com.tencentcloudapi.common.profile.HttpProfile;
import com.tencentcloudapi.faceid.v20180301.FaceidClient;
import com.tencentcloudapi.faceid.v20180301.models.BankCard4EVerificationRequest;
import com.tencentcloudapi.faceid.v20180301.models.BankCard4EVerificationResponse;
import com.tencentcloudapi.faceid.v20180301.models.IdCardVerificationRequest;
import com.tencentcloudapi.faceid.v20180301.models.IdCardVerificationResponse;
import com.tencentcloudapi.ocr.v20181119.OcrClient;
import com.tencentcloudapi.ocr.v20181119.models.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;

@Slf4j
@Service
public class TencentApiFaceIdHelper {
    private FaceidClient FACEID_CLIENT = null;

    @Value("${minigod.tencentApi.secretId}")
    private String SECRET_ID;
    @Value("${minigod.tencentApi.secretKey}")
    private String SECRET_KEY;
    @Value("${minigod.tencentApi.region}")
    private String REGION;

    @PostConstruct
    private void init() {
        Credential cred = new Credential(SECRET_ID, SECRET_KEY);

        HttpProfile httpProfile = new HttpProfile();
        httpProfile.setEndpoint("faceid.tencentcloudapi.com");

        ClientProfile clientProfile = new ClientProfile();
        clientProfile.setHttpProfile(httpProfile);

        FACEID_CLIENT = new FaceidClient(cred, REGION, clientProfile);
    }

    public IdCardVerificationResponse verifyIdCard(String idCard, String userName) {
        try {
            Map<String, Object> data = new HashMap<>();

            data.put("Name", userName);
            data.put("IdCard", idCard);

            String params = JSON.toJSONString(data);
            IdCardVerificationRequest req = IdCardVerificationRequest.fromJsonString(params, IdCardVerificationRequest.class);

            IdCardVerificationResponse resp = FACEID_CLIENT.IdCardVerification(req);
            return resp;

        } catch (TencentCloudSDKException e) {
            System.out.println(e.toString());
            return null;
        }
    }


    public BankCard4EVerificationResponse verifyBankCard4E(String idCard, String userName, String phone, String bankCard) {
        try {
            Map<String, Object> data = new HashMap<>();

            data.put("Name", userName);
            data.put("BankCard", bankCard);
            data.put("Phone", phone);
            data.put("IdCard", idCard);

            String params = JSON.toJSONString(data);
            BankCard4EVerificationRequest req = BankCard4EVerificationRequest.fromJsonString(params, BankCard4EVerificationRequest.class);

            BankCard4EVerificationResponse resp = FACEID_CLIENT.BankCard4EVerification(req);
            return resp;

        } catch (TencentCloudSDKException e) {
            System.out.println(e.toString());
            return null;
        }
    }


}
