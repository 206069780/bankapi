package com.bankapi.bankapi.bean;

import java.io.Serializable;

/**
 * @author Mr Fu
 * @version 1.0
 * @PackageName com.bankapi.bankapi.bean
 * @ProjectName bankapi
 * @ClassName SuccMessage
 * @Email fudaopin@gamil.com
 * @date 2021/4/23 下午2:48
 * @Description TODO
 */
public class SuccMessage extends AbstractResponseMessage implements Serializable {

    public static final Long serialVersionUID = -1619160539847L;

    /*交易编码*/
    private String paltformId;

    /*交易编码*/
    private String platfromSeqId;

    /*交易日期*/
    private String paltformDate;

    /*交易时间*/
    private String paltformTime;

    /*交易码*/
    private String transCode;

    /*签名*/
    private String signature;

    /*受理状态*/
    private SuccMessageBean paramResponseMessage;

    SuccMessage() {
    }

    public SuccMessage(String paltformId, String platfromSeqId, String paltformDate, String paltformTime, String transCode, String signature, SuccMessageBean paramResponseMessage) {
        this.paltformId = paltformId;
        this.platfromSeqId = platfromSeqId;
        this.paltformDate = paltformDate;
        this.paltformTime = paltformTime;
        this.transCode = transCode;
        this.signature = signature;
        this.paramResponseMessage = paramResponseMessage;
    }

    public String getPaltformId() {
        return paltformId;
    }

    public void setPaltformId(String paltformId) {
        this.paltformId = paltformId;
    }

    public String getPlatfromSeqId() {
        return platfromSeqId;
    }

    public void setPlatfromSeqId(String platfromSeqId) {
        this.platfromSeqId = platfromSeqId;
    }

    public String getPaltformDate() {
        return paltformDate;
    }

    public void setPaltformDate(String paltformDate) {
        this.paltformDate = paltformDate;
    }

    public String getPaltformTime() {
        return paltformTime;
    }

    public void setPaltformTime(String paltformTime) {
        this.paltformTime = paltformTime;
    }

    public String getTransCode() {
        return transCode;
    }

    public void setTransCode(String transCode) {
        this.transCode = transCode;
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }

    public SuccMessageBean getParamResponseMessage() {
        return paramResponseMessage;
    }

    public void setParamResponseMessage(SuccMessageBean paramResponseMessage) {
        this.paramResponseMessage = paramResponseMessage;
    }
}
