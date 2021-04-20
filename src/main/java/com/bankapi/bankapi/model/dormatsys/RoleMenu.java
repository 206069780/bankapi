package com.bankapi.bankapi.model.dormatsys;

import java.io.Serializable;
import java.util.Date;

/**
 * @author Mr Fu
 * @version 1.0
 * @PackageName com.bankapi.bankapi.model.dormatsys
 * @ProjectName bankapi
 * @ClassName RoleMenu
 * @Email fudaopin@gamil.com
 * @date 2021/4/20 上午9:24
 * @Description 角色菜单
 */
public class RoleMenu implements Serializable {
    /*Serializable ID*/
    public static final Long serialVersionUID = 1618881971746L;

    /*自增id*/
    private Long id;

    /*角色id*/
    private Long roleId;

    /*菜单id*/
    private Long menuId;

    /*创建时间*/
    private Date createTime;

    public RoleMenu() {
    }

    public RoleMenu(Long id, Long roleId, Long menuId, Date createTime) {
        this.id = id;
        this.roleId = roleId;
        this.menuId = menuId;
        this.createTime = createTime;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    public Long getMenuId() {
        return menuId;
    }

    public void setMenuId(Long menuId) {
        this.menuId = menuId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "RoleMenu{" +
                "id=" + id +
                ", roleId=" + roleId +
                ", menuId=" + menuId +
                ", createTime=" + createTime +
                '}';
    }
}
