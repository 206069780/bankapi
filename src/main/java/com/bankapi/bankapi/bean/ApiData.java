package com.bankapi.bankapi.bean;

import java.io.Serializable;

/**
 * @author Mr Fu
 * @version 1.0
 * @PackageName com.bankapi.bankapi.bean
 * @ProjectName bankapi
 * @ClassName ApiData
 * @Email fudaopin@gamil.com
 * @date 2021/4/21 上午9:17
 * @Description 银行获取当前需要发放资金的相关批次信息
 */
public class ApiData implements Serializable {

    /**
     * "platformId": "1281258346801557504", //编号
     * <p>
     * "subsidyCode": "1223", //补贴项目编号
     * <p>
     * "deptId": "283",    //部门编号
     * <p>
     * "batchId": "20200709551" // 批次编号
     **/
    public static final Long serialVersionUID = -1618967980035L;

    /*银行流水号*/
    private String platFormId;

    /*补贴项目编号*/
    private String subsidyCode;

    /*部门编号*/
    private String departmentId;

    /*文件地址*/
    private String fileName;

    /*加密*/
    private String md5;

    /*发放人数*/
    private int count;

    /*发放金额*/
    private int amt;

    /*银行摘要编码*/
    private String digestCOde;

    /*摘要描述*/
    private String digestDesc;

    /*重发人数*/
    private int retryCount;

    /*批次编号*/
    private String barchId;

    private String isFirst;

    public ApiData() {

    }
    public String getIsFirst() {
        return isFirst;
    }

    public void setIsFirst(String isFirst) {
        this.isFirst = isFirst;
    }

    public ApiData(String platFormId, String subsidyCode, String departmentId, String fileName, String md5, int count, int amt, String digestCOde, String digestDesc, int retryCount, String barchId, String isFirst) {
        this.platFormId = platFormId;
        this.subsidyCode = subsidyCode;
        this.departmentId = departmentId;
        this.fileName = fileName;
        this.md5 = md5;
        this.count = count;
        this.amt = amt;
        this.digestCOde = digestCOde;
        this.digestDesc = digestDesc;
        this.retryCount = retryCount;
        this.barchId = barchId;
        this.isFirst = isFirst;
    }

    public String getPlatFormId() {
        return platFormId;
    }

    public void setPlatFormId(String platFormId) {
        this.platFormId = platFormId;
    }

    public String getSubsidyCode() {
        return subsidyCode;
    }

    public void setSubsidyCode(String subsidyCode) {
        this.subsidyCode = subsidyCode;
    }

    public String getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(String departmentId) {
        this.departmentId = departmentId;
    }

    public String getBarchId() {
        return barchId;
    }

    public void setBarchId(String barchId) {
        this.barchId = barchId;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getMd5() {
        return md5;
    }

    public void setMd5(String md5) {
        this.md5 = md5;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getAmt() {
        return amt;
    }

    public void setAmt(int amt) {
        this.amt = amt;
    }

    public String getDigestCOde() {
        return digestCOde;
    }

    public void setDigestCOde(String digestCOde) {
        this.digestCOde = digestCOde;
    }

    public String getDigestDesc() {
        return digestDesc;
    }

    public void setDigestDesc(String digestDesc) {
        this.digestDesc = digestDesc;
    }

    public int getRetryCount() {
        return retryCount;
    }

    public void setRetryCount(int retryCount) {
        this.retryCount = retryCount;
    }

}
