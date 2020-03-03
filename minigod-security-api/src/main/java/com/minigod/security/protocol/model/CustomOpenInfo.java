package com.minigod.security.protocol.model;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CustomOpenInfo implements Serializable {
    /**
     * 自增主键
     */
    private Integer id;

    private String phone;

    /**
     * 邮箱
     */
    private String email;

    private String password;

    /**
     * 银行卡号
     */
    private String bankCard;

    /**
     * 身份证号码
     */
    private String idCard;

    /**
     * 0:未提交（默认），1:开户中，2:已取消,3:开户成功，4:开户失败，5:销户
     */
    private Integer status;

    /**
     * 开户接入方式: 1:H5开户 2:APP开户
     */
    private Integer accessWay;

    /**
     * 账户类型 1：现金账户 2：融资账户
     */
    private Integer accountType;

    /**
     * 开户方式：0:未知，1:线上内地开户，2:线下（开户宝），3:线上香港开户
     */
    private Integer openType;

    /**
     * 账户类型：1：港股 2：美股 3：中华通
     */
    private String accountMarkets;

    /**
     * 0:预批中，1:审批中，2:CA认证中,3:柜台开户中
     */
    private Integer pendingType;

    /**
     * 0:其他错误，1:基本数据错误，2:影像数据错误,3:基本或影像数据错误，4:CA数据错误
     */
    private Integer failType;

    /**
     * 开户结果
     */
    private String openResult;

    /**
     * 是否需要推送
     */
    private Boolean isNeedPush;

    /**
     * 推送失败次数
     */
    private Integer pushErrCount;

    /**
     * 远程开户系统ID
     */
    private String remoteId;

    /**
     * 开户日期
     */
    private Date openDate;

    /**
     * 客户号（交易帐号）
     */
    private String tradeAccount;

    /**
     * 是否发送消息
     */
    private Boolean isSend;

    /**
     * 开户数据
     */
    private String info;

    /**
     * 开户PDF文件地址
     */
    private String openAccountPdfUrl;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 更新时间
     */
    private Date updateTime;

    private static final long serialVersionUID = 1L;
}