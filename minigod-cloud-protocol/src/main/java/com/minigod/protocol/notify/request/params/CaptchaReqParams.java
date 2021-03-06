package com.minigod.protocol.notify.request.params;

import com.minigod.common.pojo.request.BaseRequestParams;
import lombok.*;

import java.io.Serializable;

@Data
public class CaptchaReqParams extends BaseRequestParams implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer certType; // 1 手机号 2 邮箱
    private String certCode; // 账号
    private String type; // 验证码类型
    private Integer captchaId;// 验证码事件Id
    private String captcha;// 验证码
}
