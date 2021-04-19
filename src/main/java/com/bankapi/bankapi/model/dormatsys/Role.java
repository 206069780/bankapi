package com.bankapi.bankapi.model.dormatsys;

import java.io.Serializable;
import java.util.Date;

/**
 * @packageName: com.bankapi.bankapi.model.dormatsys
 * @program: bankapi
 * @className: Role
 * @author: Mr.FU
 * @Email: fudaopin@gmail.com
 * @createDate: 2021-04-19  23:46
 * @description: TODO
 **/
public class Role implements Serializable {
    public static final Long serialVersionUID = 1618847228046L;

    /*自增主键*/
    private Long id;

    /*角色名称*/
    private String roleName;

    /*部门类型*/
    private String departmentType;

    /*描述(0：可手动分配；1：系统分配，不可手动干预) */
    private String roleType;

    /*备注*/
    private String remark;

    /*状态*/
    private String status;

    /*创建时间*/
    private Date createTime;

    /*更新时间*/
    private Date updaDateTime;

    public Role(){}

    public Role(Long id, String roleName, String departmentType, String roleType, String remark, String status, Date createTime, Date updaDateTime) {
        this.id = id;
        this.roleName = roleName;
        this.departmentType = departmentType;
        this.roleType = roleType;
        this.remark = remark;
        this.status = status;
        this.createTime = createTime;
        this.updaDateTime = updaDateTime;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getDepartmentType() {
        return departmentType;
    }

    public void setDepartmentType(String departmentType) {
        this.departmentType = departmentType;
    }

    public String getRoleType() {
        return roleType;
    }

    public void setRoleType(String roleType) {
        this.roleType = roleType;
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

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdaDateTime() {
        return updaDateTime;
    }

    public void setUpdaDateTime(Date updaDateTime) {
        this.updaDateTime = updaDateTime;
    }

    @Override
    public String toString() {
        return "Role{" +
                "id=" + id +
                ", roleName='" + roleName + '\'' +
                ", departmentType='" + departmentType + '\'' +
                ", roleType='" + roleType + '\'' +
                ", remark='" + remark + '\'' +
                ", status='" + status + '\'' +
                ", createTime=" + createTime +
                ", updaDateTime=" + updaDateTime +
                '}';
    }
}
