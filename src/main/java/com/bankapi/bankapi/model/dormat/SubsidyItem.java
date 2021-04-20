package com.bankapi.bankapi.model.dormat;

import java.io.Serializable;
import java.util.Date;

/**
 * @author Mr Fu
 * @version 1.0
 * @PackageName com.bankapi.bankapi.model.dormat
 * @ProjectName bankapi
 * @ClassName SubsidyItem
 * @Email fudaopin@gamil.com
 * @date 2021/4/20 下午3:34
 * @Description TODO
 */
public class SubsidyItem implements Serializable {

    /**
     * ID	NUMBER	No		1	自增主键
     * CODE	VARCHAR2(255 BYTE)	No		2	补贴项目编码
     * PCODE	VARCHAR2(255 BYTE)	Yes		3	父级编码
     * NAME	VARCHAR2(255 BYTE)	Yes	0	4	补贴项目名称
     * DIGEST_CODE	VARCHAR2(255 BYTE)	Yes		5	摘要编码
     * DIGEST_DESC	VARCHAR2(255 BYTE)	Yes		6	摘要描述
     * REMARK	VARCHAR2(255 BYTE)	Yes		7	描述
     * STATUS	CHAR(1 BYTE)	Yes	0	8	状态(0：正常；1：禁用)
     * CREATE_USER_ID	VARCHAR2(20 BYTE)	Yes		9	操作者
     * CREATE_TIME	DATE	Yes	sysdate	10	创建时间
     * UPDATE_TIME	DATE	Yes		11	更新时间
     */
    public static final Long serialVersionUID = -1618904094195L;

    /*自增id*/
    private Long id;

    /*补贴项目编码*/
    private String subsidyCode;

    /*父级编码*/
    private String prantCode;

    /*补贴项目名称*/
    private String subsidyName;

    /*摘要编码*/
    private String digestCode;

    /*摘要描述*/
    private String digestDesc;

    /*描述*/
    private String remark;

    /*状态*/
    private String status;

    /*操作者*/
    private String operator;

    /*创建时间*/
    private Date createTime;

    /*更新时间*/
    private Date updateTime;

    public SubsidyItem() {

    }

    public SubsidyItem(Long id, String subsidyCode, String prantCode, String subsidyName, String digestCode, String digestDesc, String remark, String status, String operator, Date createTime, Date updateTime) {
        this.id = id;
        this.subsidyCode = subsidyCode;
        this.prantCode = prantCode;
        this.subsidyName = subsidyName;
        this.digestCode = digestCode;
        this.digestDesc = digestDesc;
        this.remark = remark;
        this.status = status;
        this.operator = operator;
        this.createTime = createTime;
        this.updateTime = updateTime;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSubsidyCode() {
        return subsidyCode;
    }

    public void setSubsidyCode(String subsidyCode) {
        this.subsidyCode = subsidyCode;
    }

    public String getPrantCode() {
        return prantCode;
    }

    public void setPrantCode(String prantCode) {
        this.prantCode = prantCode;
    }

    public String getSubsidyName() {
        return subsidyName;
    }

    public void setSubsidyName(String subsidyName) {
        this.subsidyName = subsidyName;
    }

    public String getDigestCode() {
        return digestCode;
    }

    public void setDigestCode(String digestCode) {
        this.digestCode = digestCode;
    }

    public String getDigestDesc() {
        return digestDesc;
    }

    public void setDigestDesc(String digestDesc) {
        this.digestDesc = digestDesc;
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

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    @Override
    public String toString() {
        return "SubsidyItem{" +
                "id=" + id +
                ", subsidyCode='" + subsidyCode + '\'' +
                ", prantCode='" + prantCode + '\'' +
                ", subsidyName='" + subsidyName + '\'' +
                ", digestCode='" + digestCode + '\'' +
                ", digestDesc='" + digestDesc + '\'' +
                ", remark='" + remark + '\'' +
                ", status='" + status + '\'' +
                ", operator='" + operator + '\'' +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                '}';
    }
}
