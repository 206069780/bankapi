package com.bankapi.bankapi.model.dormatsys;

import java.io.Serializable;
import java.util.Date;

/**
 * @packageName: com.bankapi.bankapi.dao.dormatsysdao
 * @program: bankapi
 * @className: UserStockRoom
 * @author: Mr.FU
 * @Email: fudaopin@gmail.com
 * @createDate: 2021-04-19  20:55
 * @description: 用户-股室 model
 **/
public class UserStockRoom implements Serializable {

    public static final Long serialVersionUID = 1618836965693L;

    /* 自增id */
    private Long id;

    /*用户id*/
    private Long userId;

    /*股室id*/
    private Long stockRoomId;

    /*状态*/
    private String status;

    /*创建时间*/
    private Date createTime;

    public UserStockRoom(){}

    public UserStockRoom(Long id, Long userId, Long stockRoomId, String status, Date createTime) {
        this.id = id;
        this.userId = userId;
        this.stockRoomId = stockRoomId;
        this.status = status;
        this.createTime = createTime;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getStockRoomId() {
        return stockRoomId;
    }

    public void setStockRoomId(Long stockRoomId) {
        this.stockRoomId = stockRoomId;
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
        return "UserStockRoom{" +
                "id=" + id +
                ", userId=" + userId +
                ", stockRoomId=" + stockRoomId +
                ", status='" + status + '\'' +
                ", createTime=" + createTime +
                '}';
    }
}
