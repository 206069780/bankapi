package com.bankapi.bankapi.model;

import java.io.Serializable;
import java.util.Date;

/**
 * @packageName: com.bankapi.bankapi.model
 * @program: bankapi
 * @className: User
 * @author: Mr.FU
 * @Email: fudaopin@gmail.com
 * @createDate: 2021-04-13  21:23
 * @description: 用户model
 **/
public class User implements Serializable {

    public static final Long serialVersionUID = -1618320294581L;

    /* 用户id 自增 */
    private Long id;

    /* 用户名 账号 */
    private String username;

    /* 昵称 */
    private String nickname;

    /* 用户密码 */
    private String password;

    /* 角色 ip */
    private String roleId;

    /* 创建 ip */
    private String createIp;

    /* 手机 */
    private String phone;

    /* 部门id */
    private String dept_id;

    /* 备注 */
    private String remark;

    /* 状态 */
    private String status;

    /* 操作人 */
    private String createUserId;

    /* 创建时间 */
    private Date createtime;

    /* 最后登录时间 */
    private Date lastLoginTime;

    public User(){}

    public User(Long id, String username, String nickname, String password, String roleId, String createIp, String phone, String dept_id, String remark, String status, String createUserId, Date createtime, Date lastLoginTime) {
        this.id = id;
        this.username = username;
        this.nickname = nickname;
        this.password = password;
        this.roleId = roleId;
        this.createIp = createIp;
        this.phone = phone;
        this.dept_id = dept_id;
        this.remark = remark;
        this.status = status;
        this.createUserId = createUserId;
        this.createtime = createtime;
        this.lastLoginTime = lastLoginTime;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

    public String getCreateIp() {
        return createIp;
    }

    public void setCreateIp(String createIp) {
        this.createIp = createIp;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getDept_id() {
        return dept_id;
    }

    public void setDept_id(String dept_id) {
        this.dept_id = dept_id;
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

    public String getCreateUserId() {
        return createUserId;
    }

    public void setCreateUserId(String createUserId) {
        this.createUserId = createUserId;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public Date getLastLoginTime() {
        return lastLoginTime;
    }

    public void setLastLoginTime(Date lastLoginTime) {
        this.lastLoginTime = lastLoginTime;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", nickname='" + nickname + '\'' +
                ", password='" + password + '\'' +
                ", roleId='" + roleId + '\'' +
                ", createIp='" + createIp + '\'' +
                ", phone='" + phone + '\'' +
                ", dept_id='" + dept_id + '\'' +
                ", remark='" + remark + '\'' +
                ", status='" + status + '\'' +
                ", createUserId='" + createUserId + '\'' +
                ", createtime=" + createtime +
                ", lastLoginTime=" + lastLoginTime +
                '}';
    }
}
