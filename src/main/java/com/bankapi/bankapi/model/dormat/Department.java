package com.bankapi.bankapi.model.dormat;

import java.util.Date;

/**
 * @author Mr Fu
 * @version 1.0
 * @PackageName com.bankapi.bankapi.model.dormat
 * @ProjectName bankapi
 * @ClassName Department
 * @Email fudaopin@gamil.com
 * @date 2021/4/19 下午4:02
 * @Description 部门类
 */
public class Department {

    /* 自增 id */
    private long id;

    /* 部门编码 */
    private String departmentCode;

    /* 父级部门编码 */
    private String parentDepartmentCode;

    /* 部门名称 */
    private String departmentName;

    /* 社会信用代码 */
    private String sociateCreditCode;

    /* 区县  */
    private String country;

    /* 乡镇 */
    private String town;

    /* 村屯 */
    private String village;

    /* 部门地址 */
    private String address;

    /* 负责人 id */
    private String principalId;

    /* 负责人电话  */
    private String principalPhone;

    /* 部门类型 */
    private String departmentType;

    /* 备注 */
    private String remark;

    /* 状态 */
    private String status;

    /* 操作用户 */
    private String operationUser;

    /* 创建时间  */
    private Date createTime;

    /* 更新时间 */
    private Date updateTime;

   public Department(){}

    public Department(long id, String departmentCode, String parentDepartmentCode, String departmentName, String sociateCreditCode, String country, String town, String village, String address, String principalId, String principalPhone, String departmenType, String remark, String status, String operationUser, Date createTime, Date updateTime) {
        this.id = id;
        this.departmentCode = departmentCode;
        this.parentDepartmentCode = parentDepartmentCode;
        this.departmentName = departmentName;
        this.sociateCreditCode = sociateCreditCode;
        this.country = country;
        this.town = town;
        this.village = village;
        this.address = address;
        this.principalId = principalId;
        this.principalPhone = principalPhone;
        this.departmentType = departmenType;
        this.remark = remark;
        this.status = status;
        this.operationUser = operationUser;
        this.createTime = createTime;
        this.updateTime = updateTime;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDepartmentCode() {
        return departmentCode;
    }

    public void setDepartmentCode(String departmentCode) {
        this.departmentCode = departmentCode;
    }

    public String getParentDepartmentCode() {
        return parentDepartmentCode;
    }

    public void setParentDepartmentCode(String parentDepartmentCode) {
        this.parentDepartmentCode = parentDepartmentCode;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public String getSociateCreditCode() {
        return sociateCreditCode;
    }

    public void setSociateCreditCode(String sociateCreditCode) {
        this.sociateCreditCode = sociateCreditCode;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getTown() {
        return town;
    }

    public void setTown(String town) {
        this.town = town;
    }

    public String getVillage() {
        return village;
    }

    public void setVillage(String village) {
        this.village = village;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPrincipalId() {
        return principalId;
    }

    public void setPrincipalId(String principalId) {
        this.principalId = principalId;
    }

    public String getPrincipalPhone() {
        return principalPhone;
    }

    public void setPrincipalPhone(String principalPhone) {
        this.principalPhone = principalPhone;
    }

    public String getDepartmentType() {
        return departmentType;
    }

    public void setDepartmentType(String departmentType) {
        this.departmentType = departmentType;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getOperationUser() {
        return operationUser;
    }

    public void setOperationUser(String operationUser) {
        this.operationUser = operationUser;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    @Override
    public String toString() {
        return "Department{" +
                "id=" + id +
                ", departmentCode='" + departmentCode + '\'' +
                ", parentDepartmentCode='" + parentDepartmentCode + '\'' +
                ", departmentName='" + departmentName + '\'' +
                ", sociateCreditCode='" + sociateCreditCode + '\'' +
                ", country='" + country + '\'' +
                ", town='" + town + '\'' +
                ", village='" + village + '\'' +
                ", address='" + address + '\'' +
                ", principalId='" + principalId + '\'' +
                ", principalPhone='" + principalPhone + '\'' +
                ", departmenType='" + departmentType + '\'' +
                ", remark='" + remark + '\'' +
                ", status='" + status + '\'' +
                ", operationUser='" + operationUser + '\'' +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                '}';
    }
}
