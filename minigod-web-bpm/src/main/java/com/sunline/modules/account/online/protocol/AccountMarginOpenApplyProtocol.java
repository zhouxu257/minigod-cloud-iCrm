package com.sunline.modules.account.online.protocol;

import com.alibaba.fastjson.annotation.JSONField;
import com.sunline.modules.common.pojo.rest.BaseParameter;

import java.util.List;


/**
 * 增开申请
 * @author Tim
 * @createDate 2020/8/5
 */

public class AccountMarginOpenApplyProtocol extends BaseParameter {

    //预约流水号
    @JSONField(name = "idCardNo")
    private String idCardNo;

    //信用额度
    @JSONField(name = "creditQuota")
    private String creditQuota;

    //信用比例
    @JSONField(name = "creditRatio")
    private String creditRatio;

    //其他信息披露
    @JSONField(name = "disclosure")
    private List<OpenAccountOtherDisclosureProtocol> disclosure;

    public String getIdCardNo() {
        return idCardNo;
    }

    public void setIdCardNo(String idCardNo) {
        this.idCardNo = idCardNo;
    }

    public String getCreditQuota() {
        return creditQuota;
    }

    public void setCreditQuota(String creditQuota) {
        this.creditQuota = creditQuota;
    }

    public String getCreditRatio() {
        return creditRatio;
    }

    public void setCreditRatio(String creditRatio) {
        this.creditRatio = creditRatio;
    }

    public List<OpenAccountOtherDisclosureProtocol> getDisclosure() {
        return disclosure;
    }

    public void setDisclosure(List<OpenAccountOtherDisclosureProtocol> disclosure) {
        this.disclosure = disclosure;
    }
}
