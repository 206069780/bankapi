package com.bankapi.bankapi.model.dormatsys;

import java.io.Serializable;
import java.util.Date;

/**
 * @author Mr Fu
 * @version 1.0
 * @PackageName com.bankapi.bankapi.model.dormatsys
 * @ProjectName bankapi
 * @ClassName UserRole
 * @Email fudaopin@gamil.com
 * @date 2021/4/20 上午10:49
 * @Description UserRole model
 */
public class UserRole implements Serializable {

    /**
     * ID	                    NUMBER	No		1
     * DEPT_ID	                VARCHAR2(20 BYTE)	Yes		2
     * USER_ID	                VARCHAR2(20 BYTE)	Yes		3
     * ROLE_ID	                NUMBER	Yes		4
     * STATUS	                CHAR(1 BYTE)	Yes	0	5
     * CREATE_USER_ID	        VARCHAR2(20 BYTE)	Yes		6
     * CREATE_TIME	            DATE	        Yes		7
     */

    public static final Long serialVersionUID = -1618886961537L;

    /*自增id*/
    private Long id;

    /*部门id*/
    private String departmentId;

    /*用户id*/
    private String userId;

    /*角色id*/
    private Long roleId;

    /*状态*/
    private String status;

    /*操作者*/
    private String operator;

    /*创建时间*/
    private Date createTime;

    public UserRole() {
    }

    public UserRole(Long id, String departmentId, String userId, Long roleId, String status, String operator, Date createTime) {
        this.id = id;
        this.departmentId = departmentId;
        this.userId = userId;
        this.roleId = roleId;
        this.status = status;
        this.operator = operator;
        this.createTime = createTime;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(String departmentId) {
        this.departmentId = departmentId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "UserRole{" +
                "id=" + id +
                ", departmentId='" + departmentId + '\'' +
                ", userId='" + userId + '\'' +
                ", roleId=" + roleId +
                ", status='" + status + '\'' +
                ", operator='" + operator + '\'' +
                ", createTime=" + createTime +
                '}';
    }
}
