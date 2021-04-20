package com.bankapi.bankapi.model.dormatsys;

import java.io.Serializable;
import java.util.Date;

/**
 * @author Mr Fu
 * @version 1.0
 * @PackageName com.bankapi.bankapi.model.dormatsys
 * @ProjectName bankapi
 * @ClassName Menu
 * @Email fudaopin@gamil.com
 * @date 2021/4/20 上午10:27
 * @Description 菜单
 */
public class Menu implements Serializable {

    /**
     * 1	ID
     * 2	PID
     * 3	NAME
     * 4	COMPONENT
     * 5	ICON
     * 6	SORT
     * 7	REMARK
     * 8	STATUS
     * 9	CREATE_TIME
     */
    public static final Long serialVersionUID = 1618885683578L;

    /*自增id*/
    private Long   id;

    /*父级id*/
    private Long   parentId;

    /*菜单名称*/
    private String menuName;

    /*组件名称*/
    private String compomentName;

    /*图标*/
    private String icon;

    /*菜单排序*/
    private String menuSort;

    /*备注*/
    private String remark;

    /*状态*/
    private String status;

    /*创建时间*/
    private Date   createTime;

    public Menu(){}

    public Menu(Long id, Long parentId, String menuName, String compomentName, String icon, String menuSort, String remark, String status, Date createTime) {
        this.id = id;
        this.parentId = parentId;
        this.menuName = menuName;
        this.compomentName = compomentName;
        this.icon = icon;
        this.menuSort = menuSort;
        this.remark = remark;
        this.status = status;
        this.createTime = createTime;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    public String getCompomentName() {
        return compomentName;
    }

    public void setCompomentName(String compomentName) {
        this.compomentName = compomentName;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getMenuSort() {
        return menuSort;
    }

    public void setMenuSort(String menuSort) {
        this.menuSort = menuSort;
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

    @Override
    public String toString() {
        return "Menu{" +
                "id=" + id +
                ", parentId=" + parentId +
                ", menuName='" + menuName + '\'' +
                ", compomentName='" + compomentName + '\'' +
                ", icon='" + icon + '\'' +
                ", menuSort='" + menuSort + '\'' +
                ", remark='" + remark + '\'' +
                ", status='" + status + '\'' +
                ", createTime=" + createTime +
                '}';
    }
}
