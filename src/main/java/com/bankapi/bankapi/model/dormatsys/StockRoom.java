package com.bankapi.bankapi.model.dormatsys;

import java.io.Serializable;
import java.util.Date;

/**
 * @packageName: com.bankapi.bankapi.model.dormatsys
 * @program: bankapi
 * @className: StockRoom
 * @author: Mr.FU
 * @Email: fudaopin@gmail.com
 * @createDate: 2021-04-19  20:22
 * @description: 股室
 **/
public class StockRoom implements Serializable {

    public static final Long serialVersionUID = 1618835181764L;

    /* 自增 id */
    private Long id;

    /* 股室名称 */
    private String stockRoomName;

    /* 状态 */
    private String stutus;

    /* 业务部门名称 */
    private String businesDepartmentName;

    /* 创建用户id */
    private String createUserId;

    /* 创建时间 */
    private Date createTime;

    public StockRoom(){}

    public StockRoom(Long id, String stockRoomName, String stutus, String businesDepartmentName, String createUserId, Date createTime) {
        this.id = id;
        this.stockRoomName = stockRoomName;
        this.stutus = stutus;
        this.businesDepartmentName = businesDepartmentName;
        this.createUserId = createUserId;
        this.createTime = createTime;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStockRoomName() {
        return stockRoomName;
    }

    public void setStockRoomName(String stockRoomName) {
        this.stockRoomName = stockRoomName;
    }

    public String getStutus() {
        return stutus;
    }

    public void setStutus(String stutus) {
        this.stutus = stutus;
    }

    public String getBusinesDepartmentName() {
        return businesDepartmentName;
    }

    public void setBusinesDepartmentName(String businesDepartmentName) {
        this.businesDepartmentName = businesDepartmentName;
    }

    public String getCreateUserId() {
        return createUserId;
    }

    public void setCreateUserId(String createUserId) {
        this.createUserId = createUserId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "StockRoom{" +
                "id=" + id +
                ", stockRoomName='" + stockRoomName + '\'' +
                ", stutus='" + stutus + '\'' +
                ", businesDepartmentName='" + businesDepartmentName + '\'' +
                ", createUserId='" + createUserId + '\'' +
                ", createTime=" + createTime +
                '}';
    }
}
