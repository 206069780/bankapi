package com.bankapi.bankapi.bean;

import java.io.Serializable;

/**
 * @author Mr Fu
 * @version 1.0
 * @PackageName com.bankapi.bankapi.bean
 * @ProjectName bankapi
 * @ClassName BankIssuedData
 * @Email fudaopin@gamil.com
 * @date 2021/4/21 下午5:37
 * @Description 银行获取数据生成
 */
public class BankIssuedData implements Serializable {

    /*serialVersionUID*/
    public static final Long serialVersionUID = 1619072002460L;

    /*批次明细ID*/
    private String PCID;

    /*姓名*/
    private String name;

    /*银行卡号*/
    private String bankID;

    /*应发金额*/
    private String mory;

    /*持卡人身份证号*/
    private String SFZH;

    /*补贴项目名称*/
    private String BTMC;

    public BankIssuedData() {

    }

    public BankIssuedData(String PCID, String name, String bankID, String mory, String SFZH, String BTMC) {
        this.PCID = PCID;
        this.name = name;
        this.bankID = bankID;
        this.mory = mory;
        this.SFZH = SFZH;
        this.BTMC = BTMC;
    }

    public String getPCID() {
        return PCID;
    }

    public void setPCID(String PCID) {
        this.PCID = PCID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBankID() {
        return bankID;
    }

    public void setBankID(String bankID) {
        this.bankID = bankID;
    }

    public String getMory() {
        return mory;
    }

    public void setMory(String mory) {
        this.mory = mory;
    }

    public String getSFZH() {
        return SFZH;
    }

    public void setSFZH(String SFZH) {
        this.SFZH = SFZH;
    }

    public String getBTMC() {
        return BTMC;
    }

    public void setBTMC(String BTMC) {
        this.BTMC = BTMC;
    }

    @Override
    public String toString() {
        return "BankIssuedData{" +
                "PCID:'" + PCID + '\'' +
                ", name:'" + name + '\'' +
                ", bankID:'" + bankID + '\'' +
                ", mory:'" + mory + '\'' +
                ", SFZH:'" + SFZH + '\'' +
                ", BTMC:'" + BTMC + '\'' +
                '}';
    }
}
