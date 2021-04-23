package com.bankapi.bankapi.bean;

import java.io.Serializable;

/**
 * @author Mr Fu
 * @version 1.0
 * @PackageName com.bankapi.bankapi.bean
 * @ProjectName bankapi
 * @ClassName BankRecode
 * @Email fudaopin@gamil.com
 * @date 2021/4/23 上午9:39
 * @Description 银行反馈数据bean
 */
public class BankRecode implements Serializable {

    public static final Long serialVersionUID = -1619142027953L;

    /*批次id*/
    private String batchId;

    /*姓名*/
    private String name;

    /*银行卡号*/
    private String bnakNo;

    /*实发金额*/
    private String areadyMoney;

    /*发放状态*/
    private String status;

    /*提示信息*/
    private String message;

    /*银行流水号*/
    private String numberNo;

    /*发放时间*/
    private String datetime;

    public BankRecode() {

    }

    public BankRecode(String batchId, String name, String bnakNo, String areadyMoney, String status, String message, String numberNo, String datetime) {
        this.batchId = batchId;
        this.name = name;
        this.bnakNo = bnakNo;
        this.areadyMoney = areadyMoney;
        this.status = status;
        this.message = message;
        this.numberNo = numberNo;
        this.datetime = datetime;
    }

    public String getBatchId() {
        return batchId;
    }

    public void setBatchId(String batchId) {
        this.batchId = batchId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBnakNo() {
        return bnakNo;
    }

    public void setBnakNo(String bnakNo) {
        this.bnakNo = bnakNo;
    }

    public String getAreadyMoney() {
        return areadyMoney;
    }

    public void setAreadyMoney(String areadyMoney) {
        this.areadyMoney = areadyMoney;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getNumberNo() {
        return numberNo;
    }

    public void setNumberNo(String numberNo) {
        this.numberNo = numberNo;
    }

    public String getDatetime() {
        return datetime;
    }

    public void setDatetime(String datetime) {
        this.datetime = datetime;
    }
}
