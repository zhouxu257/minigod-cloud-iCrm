package com.minigod.notify.helper;

import com.github.qcloudsms.SmsSingleSender;
import com.github.qcloudsms.SmsSingleSenderResult;
import com.github.qcloudsms.httpclient.HTTPException;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.io.IOException;

/*
 * 腾讯云短信服务
 */
public class TencentSmsSender implements SmsSender {
    private final Log logger = LogFactory.getLog(TencentSmsSender.class);

    private SmsSingleSender sender;

    public SmsSingleSender getSender() {
        return sender;
    }

    public void setSender(SmsSingleSender sender) {
        this.sender = sender;
    }

    @Override
    public SmsResult send(String nationCode, String phone, String content) {
        try {
            SmsSingleSenderResult result = sender.send(0, nationCode, phone, content, "", "");
            logger.debug(result);

            SmsResult smsResult = new SmsResult();
            smsResult.setSuccessful(true);
            smsResult.setResult(result);
            return smsResult;
        } catch (HTTPException | IOException e) {
            logger.error(e.getMessage(), e);
        }

        return null;
    }

    @Override
    public SmsResult sendWithTemplate(String nationCode, String phone, int templateId, String[] params) {
        try {
            SmsSingleSenderResult result = sender.sendWithParam(nationCode, phone, templateId, params, "", "", "");
            logger.debug(result);

            SmsResult smsResult = new SmsResult();
            smsResult.setSuccessful(true);
            smsResult.setResult(result);
            return smsResult;
        } catch (HTTPException | IOException e) {
            logger.error(e.getMessage(), e);
        }

        return null;
    }
}
