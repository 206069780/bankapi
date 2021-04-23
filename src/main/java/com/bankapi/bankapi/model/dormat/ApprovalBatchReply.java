package com.bankapi.bankapi.model.dormat;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @author Mr Fu
 * @version 1.0
 * @PackageName com.bankapi.bankapi.model.dormat
 * @ProjectName bankapi
 * @ClassName ApprovalBatchReply
 * @Email fudaopin@gamil.com
 * @date 2021/4/23 上午9:47
 * @Description TODO
 */
public class ApprovalBatchReply implements Serializable {

    public static final Long serialVersionUID = -1619143124231L;

    /*
     *  ID	NUMBER	No		1	自增ID
     *  APPROVAL_ID	VARCHAR2(20 BYTE)	Yes		2	批次编号
     *  BATCH_ID	VARCHAR2(20 BYTE)	Yes		3	明细编号  ----
     *  DETAIL_ID	VARCHAR2(20 BYTE)	Yes		4	流水号(DETAIL_ID )
     *  BANK_REPLY_ID	VARCHAR2(255 BYTE)	Yes		5	银行资金发放流水号  --
     *  NAME	VARCHAR2(255 BYTE)	Yes		6	姓名
     *  BANK_HOLDER	VARCHAR2(255 BYTE)	Yes		7	持卡人姓名  ---
     *  TOTAL_MONEY	VARCHAR2(255 BYTE)	Yes		8	应发金额
     *  REPLY_MONEY	VARCHAR2(255 BYTE)	Yes		9	反馈实发金额  ---
     *  HANDED_OUT_DATE	VARCHAR2(255 BYTE)	Yes		10	银行资金发放日期（yyyyMMdd）---
     *  REPLY_STATUS	VARCHAR2(2 BYTE)	Yes		11	发放状态  01 成功，02 失败  --
     *  REMARK	VARCHAR2(255 BYTE)	Yes		12	备注   --
     *  CREATE_USER_ID	VARCHAR2(20 BYTE)	Yes		13	操作者
     *  CREATE_TIME	DATE	Yes	sysdate	14	创建时间
     **/

    private int id;

    /*批次编号*/
    private String approvalId;

    /*明细编号*/
    private String batchId;

    /*DETAIL_ID*/
    private String detailId;

    /*银行流水号*/
    private String bankReolyId;

    /*姓名*/
    private String name;

    /*持卡人姓名*/
    private String bankholder;

    /*应发金额*/
    private String totalMoney;

    /*实发金额*/
    private String replyMoney;

    /*银行发放日期*/
    private String date;

    /*发放状态*/
    private String replyStatus;

    /*备注*/
    private String remark;

    /*操作者*/
    private String opertor;

    /*创建时间*/
    private Date createTime;

    public ApprovalBatchReply(int id, String approvalId, String batchId,  String detailId, String bankReolyId, String name, String bankholder, String totalMoney, String replyMoney, String date, String replyStatus, String remark, String opertor, Date createTime) {
        this.id = id;
        this.approvalId = approvalId;
        this.batchId = batchId;
        this.detailId = detailId;
        this.bankReolyId = bankReolyId;
        this.name = name;
        this.bankholder = bankholder;
        this.totalMoney = totalMoney;
        this.replyMoney = replyMoney;
        this.date = date;
        this.replyStatus = replyStatus;
        this.remark = remark;
        this.opertor = opertor;
        this.createTime = createTime;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getApprovalId() {
        return approvalId;
    }

    public void setApprovalId(String approvalId) {
        this.approvalId = approvalId;
    }

    public String getBatchId() {
        return batchId;
    }

    public void setBatchId(String batchId) {
        this.batchId = batchId;
    }

    public String getDetailId() {
        return detailId;
    }

    public void setDetailId(String detailId) {
        this.detailId = detailId;
    }

    public String getBankReolyId() {
        return bankReolyId;
    }

    public void setBankReolyId(String bankReolyId) {
        this.bankReolyId = bankReolyId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBankholder() {
        return bankholder;
    }

    public void setBankholder(String bankholder) {
        this.bankholder = bankholder;
    }

    public String getTotalMoney() {
        return totalMoney;
    }

    public void setTotalMoney(String totalMoney) {
        this.totalMoney = totalMoney;
    }

    public String getReplyMoney() {
        return replyMoney;
    }

    public void setReplyMoney(String replyMoney) {
        this.replyMoney = replyMoney;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getReplyStatus() {
        return replyStatus;
    }

    public void setReplyStatus(String replyStatus) {
        this.replyStatus = replyStatus;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getOpertor() {
        return opertor;
    }

    public void setOpertor(String opertor) {
        this.opertor = opertor;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}
