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
     *        "platformId": "1281258346801557504", //编号
     *
     *        "subsidyCode": "1223", //补贴项目编号
     *
     *        "deptId": "283",    //部门编号
     *
     *        "batchId": "20200709551" // 批次编号
     **/
    public static final Long serialVersionUID = -1618967980035L;

    /*银行流水号*/
    private String platFormId;

    /*补贴项目编号*/
    private String subsidyCode;

    /*部门编号*/
    private String departmentId;

    /*批次编号*/
    private String barchId;

    public ApiData() {

    }

    public ApiData(String platFormId, String subsidyCode, String departmentId, String barchId) {
        this.platFormId = platFormId;
        this.subsidyCode = subsidyCode;
        this.departmentId = departmentId;
        this.barchId = barchId;
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

    @Override
    public String toString() {
        return "ApiData{" +
                "platFormId:'" + platFormId + '\'' +
                ", subsidyCod:'" + subsidyCode + '\'' +
                ", departmentId:'" + departmentId + '\'' +
                ", barchId:'" + barchId + '\'' +
                '}';
    }
}
