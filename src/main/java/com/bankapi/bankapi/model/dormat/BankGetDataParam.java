package com.bankapi.bankapi.model.dormat;

import java.io.Serializable;
import java.util.Date;

/**
 * @author Mr Fu
 * @version 1.0
 * @PackageName com.bankapi.bankapi.model.dormat
 * @ProjectName bankapi
 * @ClassName BankGetDataParam
 * @Email fudaopin@gamil.com
 * @date 2021/4/22 下午3:34
 * @Description 银行获取数据  传递的参数
 */
public class BankGetDataParam implements Serializable {

    public static final Long serialVersionUID = 1619077015818L;

    private Long id;

    /*银行流水号*/
    private String serialNumber;

    /*补贴项目编号*/
    private String subsidyNumber;

    /*部门编号*/
    private String deptId;

    /*业务批次号*/
    private String bacthId;

    /*创建时间*/
    private Date createdDate;

    /*STATE*/
    private char statusta;

    public BankGetDataParam(){}

    public BankGetDataParam(Long id, String serialNumber, String subsidyNumber, String deptId, String bacthId, Date createdDate, char statusta) {
        this.id = id;
        this.serialNumber = serialNumber;
        this.subsidyNumber = subsidyNumber;
        this.deptId = deptId;
        this.bacthId = bacthId;
        this.createdDate = createdDate;
        this.statusta = statusta;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public String getSubsidyNumber() {
        return subsidyNumber;
    }

    public void setSubsidyNumber(String subsidyNumber) {
        this.subsidyNumber = subsidyNumber;
    }

    public String getDeptId() {
        return deptId;
    }

    public void setDeptId(String deptId) {
        this.deptId = deptId;
    }

    public String getBacthId() {
        return bacthId;
    }

    public void setBacthId(String bacthId) {
        this.bacthId = bacthId;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public char getStatusta() {
        return statusta;
    }

    public void setStatusta(char statusta) {
        this.statusta = statusta;
    }


}
