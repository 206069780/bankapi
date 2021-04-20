package com.bankapi.bankapi.model.dormatsys;

import java.io.Serializable;
import java.util.Date;

/**
 * @author Mr Fu
 * @version 1.0
 * @PackageName com.bankapi.bankapi.model.dormatsys
 * @ProjectName bankapi
 * @ClassName DataDictionary
 * @Email fudaopin@gamil.com
 * @date 2021/4/20 上午9:47
 * @Description TODO
 */
public class DataDictionary implements Serializable {

    public static final Long serialVersionUID = 1618883350834L;

    /*自增id*/
    private Long id;

    /*父级code*/
    private String parentCode;

    /*数据值*/
    private String dataValue;

    /*数据key*/
    private String dataKey;

    /*是否可修改(0：可修改；1：不可修改)*/
    private String fixEdfix;

    /*类型*/
    private String type;

    /*备注*/
    private String remark;

    /*状态*/
    private String status;

    /*操作者*/
    private String operator;

    /*创建时间*/
    private Date createTime;


    public DataDictionary(){}

    public DataDictionary(Long id, String parentCode, String dataValue, String dataKey, String fixEdfix, String type, String remark, String status, String operator, Date createTime) {
        this.id = id;
        this.parentCode = parentCode;
        this.dataValue = dataValue;
        this.dataKey = dataKey;
        this.fixEdfix = fixEdfix;
        this.type = type;
        this.remark = remark;
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

    public String getParentCode() {
        return parentCode;
    }

    public void setParentCode(String parentCode) {
        this.parentCode = parentCode;
    }

    public String getDataValue() {
        return dataValue;
    }

    public void setDataValue(String dataValue) {
        this.dataValue = dataValue;
    }

    public String getDataKey() {
        return dataKey;
    }

    public void setDataKey(String dataKey) {
        this.dataKey = dataKey;
    }

    public String getFixEdfix() {
        return fixEdfix;
    }

    public void setFixEdfix(String fixEdfix) {
        this.fixEdfix = fixEdfix;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
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
        return "DataDictionary{" +
                "id=" + id +
                ", parentCode='" + parentCode + '\'' +
                ", dataValue='" + dataValue + '\'' +
                ", dataKey='" + dataKey + '\'' +
                ", fixEdfix='" + fixEdfix + '\'' +
                ", type='" + type + '\'' +
                ", remark='" + remark + '\'' +
                ", status='" + status + '\'' +
                ", operator='" + operator + '\'' +
                ", createTime=" + createTime +
                '}';
    }
}
