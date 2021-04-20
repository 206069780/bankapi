package com.bankapi.bankapi.model.dormat;

import java.io.Serializable;
import java.util.Date;

/**
 * @author Mr Fu
 * @version 1.0
 * @PackageName com.bankapi.bankapi.model.dormat
 * @ProjectName bankapi
 * @ClassName ApprovalProcessEvent
 * @Email fudaopin@gamil.com
 * @date 2021/4/20 上午11:45
 * @Description 审批流程事件
 */
public class ApprovalProcessEvent implements Serializable {
    /**
     * ID	NUMBER	No		1
     * APPROVAL_ID	VARCHAR2(20 BYTE)	Yes		2	任务ID
     * APPLY_COUNT	NUMBER(38,0)	Yes	0	3	提交总人数-弃用
     * APPLY_MONEY	NUMBER(38,2)	Yes	0	4	提交总金额-弃用
     * TOTAL_COUNT	NUMBER(38,0)	Yes	0	5	应发总人数
     * TOTAL_MONEY	NUMBER(38,2)	Yes	0	6	应发总金额
     * REPLY_COUNT	NUMBER(38,0)	Yes	0	7	实发总人数
     * REPLY_MONEY	NUMBER(38,2)	Yes	0	8	实发总金额
     * CURRENT_NODE	VARCHAR2(20 BYTE)	Yes		9	当前节点
     * TEMPLATE_ID	VARCHAR2(20 BYTE)	Yes		10	审批模板
     * SF	CHAR(1 BYTE)	Yes	0	11	是否首发(0：首发；1：补发)
     * DY	CHAR(1 BYTE)	Yes	0	12	是否可打印(0：不可；1：待打印；2：已打印)
     * BANK_NOTICE_TYPE	CHAR(1 BYTE)	Yes	0	13	银行受理状态(0：未受理；1：人工受理；2：系统受理)
     * RELEASE_NAME	VARCHAR2(255 BYTE)	Yes		14	发放清单文件明
     * RELEASE_MD5	VARCHAR2(255 BYTE)	Yes		15	发放清单文件MD5
     * TEMP1	VARCHAR2(255 BYTE)	Yes		16	临时字段可用
     * TEMP2	VARCHAR2(255 BYTE)	Yes		17	临时字段可用
     * TEMP3	VARCHAR2(255 BYTE)	Yes		18	临时字段可用
     * TEMP4	VARCHAR2(255 BYTE)	Yes		19	临时字段可用
     * TEMP5	VARCHAR2(255 BYTE)	Yes		20	临时字段可用
     * TEMP6	VARCHAR2(255 BYTE)	Yes		21	临时字段可用
     * TEMP7	VARCHAR2(255 BYTE)	Yes		22	临时字段可用
     * RETRY_COUNT	NUMBER	Yes		23	银行重发次数
     * LAST_RETRY_TIME	DATE	Yes		24	最后重发时间
     * GS_ID	VARCHAR2(255 BYTE)	Yes		25	股室ID
     * REMARK	VARCHAR2(255 BYTE)	Yes		26	备注
     * STATUS	CHAR(1 BYTE)	Yes		27	状态(0：编辑中；1：审批中；2：完成；3：驳回；4：取消)
     * CREATE_USER_ID	VARCHAR2(20 BYTE)	Yes		28	操作人
     * CREATE_TIME	DATE	Yes	sysdate	29	创建时间
     * UPDATE_TIME	DATE	Yes		30	更新时间
     */

    public static final Long serialVersionUID = -1618890342309L;

    /*自增id*/
    private Long id;

    /*任务id*/
    private String taskId;

    /*提交总人数-弃用*/
    private Long subTotalCount;

    /*提交总金额-弃用*/
    private Long subTotalMoney;

    /*应发人数*/
    private Long preTotalCount;

    /*应发总金额*/
    private Long preTotalMoney;

    /*实发总人数*/
    private Long readyTotalCount;

    /*实发总金额*/
    private Long readyTotalMoney;

    /*当前节点*/
    private String currentNode;

    /*审批模板*/
    private String templateId;

    /*是否首发(0：首发；1：补发)*/
    private String isFirst;

    /*是否可打印(0：不可；1：待打印；2：已打印)*/
    private String isPrint;

    /*银行受理状态(0：未受理；1：人工受理；2：系统受理)*/
    private String bankNoticeStatus;

    /*发放清单文件名*/
    private String issuanceName;

    /*发放清单md5*/
    private String issuanceMD5;

    /*临时字段可用*/
    private String temp1;

    /*临时字段可用*/
    private String temp2;

    /*临时字段可用*/
    private String temp3;

    /*临时字段可用*/
    private String temp4;

    /*临时字段可用*/
    private String temp5;

    /*临时字段可用*/
    private String temp6;

    /*临时字段可用*/
    private String temp7;

    /*银行重发次数*/
    private int bankRetPayCount;

    /*最后重发时间*/
    private Date lastRetPayTime;

    /*股室ID*/
    private String stockRoomId;

    /*备注*/
    private String remark;

    /*状态(0：编辑中；1：审批中；2：完成；3：驳回；4：取消)*/
    private String status;

    /*操作人*/
    private String operator;

    /*创建人*/
    private Date creaDate;

    /*更新时间*/
    private Date updaDate;

    public ApprovalProcessEvent() {
    }

    public ApprovalProcessEvent(Long id, String APPROVAL_ID, Long subTotalCount, Long subTotalMoney, Long preTotalCount, Long preTotalMoney, Long readyTotalCount, Long readyTotalMoney, String currentNode, String templateId, String isFirst, String isPrint, String bankNoticeStatus, String issuanceName, String issuanceMD5, String temp1, String temp2, String temp3, String temp4, String temp5, String temp6, String temp7, int bankRetPayCount, Date lastRetPayTime, String stockRoomId, String remark, String status, String operator, Date creaDate, Date updaDate) {
        this.id = id;
        this.taskId = APPROVAL_ID;
        this.subTotalCount = subTotalCount;
        this.subTotalMoney = subTotalMoney;
        this.preTotalCount = preTotalCount;
        this.preTotalMoney = preTotalMoney;
        this.readyTotalCount = readyTotalCount;
        this.readyTotalMoney = readyTotalMoney;
        this.currentNode = currentNode;
        this.templateId = templateId;
        this.isFirst = isFirst;
        this.isPrint = isPrint;
        this.bankNoticeStatus = bankNoticeStatus;
        this.issuanceName = issuanceName;
        this.issuanceMD5 = issuanceMD5;
        this.temp1 = temp1;
        this.temp2 = temp2;
        this.temp3 = temp3;
        this.temp4 = temp4;
        this.temp5 = temp5;
        this.temp6 = temp6;
        this.temp7 = temp7;
        this.bankRetPayCount = bankRetPayCount;
        this.lastRetPayTime = lastRetPayTime;
        this.stockRoomId = stockRoomId;
        this.remark = remark;
        this.status = status;
        this.operator = operator;
        this.creaDate = creaDate;
        this.updaDate = updaDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTaskId() {
        return taskId;
    }

    public void setTaskId(String taskId) {
        this.taskId = taskId;
    }

    public Long getSubTotalCount() {
        return subTotalCount;
    }

    public void setSubTotalCount(Long subTotalCount) {
        this.subTotalCount = subTotalCount;
    }

    public Long getSubTotalMoney() {
        return subTotalMoney;
    }

    public void setSubTotalMoney(Long subTotalMoney) {
        this.subTotalMoney = subTotalMoney;
    }

    public Long getPreTotalCount() {
        return preTotalCount;
    }

    public void setPreTotalCount(Long preTotalCount) {
        this.preTotalCount = preTotalCount;
    }

    public Long getPreTotalMoney() {
        return preTotalMoney;
    }

    public void setPreTotalMoney(Long preTotalMoney) {
        this.preTotalMoney = preTotalMoney;
    }

    public Long getReadyTotalCount() {
        return readyTotalCount;
    }

    public void setReadyTotalCount(Long readyTotalCount) {
        this.readyTotalCount = readyTotalCount;
    }

    public Long getReadyTotalMoney() {
        return readyTotalMoney;
    }

    public void setReadyTotalMoney(Long readyTotalMoney) {
        this.readyTotalMoney = readyTotalMoney;
    }

    public String getCurrentNode() {
        return currentNode;
    }

    public void setCurrentNode(String currentNode) {
        this.currentNode = currentNode;
    }

    public String getTemplateId() {
        return templateId;
    }

    public void setTemplateId(String templateId) {
        this.templateId = templateId;
    }

    public String getIsFirst() {
        return isFirst;
    }

    public void setIsFirst(String isFirst) {
        this.isFirst = isFirst;
    }

    public String getIsPrint() {
        return isPrint;
    }

    public void setIsPrint(String isPrint) {
        this.isPrint = isPrint;
    }

    public String getBankNoticeStatus() {
        return bankNoticeStatus;
    }

    public void setBankNoticeStatus(String bankNoticeStatus) {
        this.bankNoticeStatus = bankNoticeStatus;
    }

    public String getIssuanceName() {
        return issuanceName;
    }

    public void setIssuanceName(String issuanceName) {
        this.issuanceName = issuanceName;
    }

    public String getIssuanceMD5() {
        return issuanceMD5;
    }

    public void setIssuanceMD5(String issuanceMD5) {
        this.issuanceMD5 = issuanceMD5;
    }

    public String getTemp1() {
        return temp1;
    }

    public void setTemp1(String temp1) {
        this.temp1 = temp1;
    }

    public String getTemp2() {
        return temp2;
    }

    public void setTemp2(String temp2) {
        this.temp2 = temp2;
    }

    public String getTemp3() {
        return temp3;
    }

    public void setTemp3(String temp3) {
        this.temp3 = temp3;
    }

    public String getTemp4() {
        return temp4;
    }

    public void setTemp4(String temp4) {
        this.temp4 = temp4;
    }

    public String getTemp5() {
        return temp5;
    }

    public void setTemp5(String temp5) {
        this.temp5 = temp5;
    }

    public String getTemp6() {
        return temp6;
    }

    public void setTemp6(String temp6) {
        this.temp6 = temp6;
    }

    public String getTemp7() {
        return temp7;
    }

    public void setTemp7(String temp7) {
        this.temp7 = temp7;
    }

    public int getBankRetPayCount() {
        return bankRetPayCount;
    }

    public void setBankRetPayCount(int bankRetPayCount) {
        this.bankRetPayCount = bankRetPayCount;
    }

    public Date getLastRetPayTime() {
        return lastRetPayTime;
    }

    public void setLastRetPayTime(Date lastRetPayTime) {
        this.lastRetPayTime = lastRetPayTime;
    }

    public String getStockRoomId() {
        return stockRoomId;
    }

    public void setStockRoomId(String stockRoomId) {
        this.stockRoomId = stockRoomId;
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

    public Date getCreaDate() {
        return creaDate;
    }

    public void setCreaDate(Date creaDate) {
        this.creaDate = creaDate;
    }

    public Date getUpdaDate() {
        return updaDate;
    }

    public void setUpdaDate(Date updaDate) {
        this.updaDate = updaDate;
    }

    @Override
    public String toString() {
        return "ApprovalProcessEvent{" +
                "id=" + id +
                ", APPROVAL_ID='" + taskId + '\'' +
                ", subTotalCount=" + subTotalCount +
                ", subTotalMoney=" + subTotalMoney +
                ", preTotalCount=" + preTotalCount +
                ", preTotalMoney=" + preTotalMoney +
                ", readyTotalCount=" + readyTotalCount +
                ", readyTotalMoney=" + readyTotalMoney +
                ", currentNode='" + currentNode + '\'' +
                ", templateId='" + templateId + '\'' +
                ", isFirst='" + isFirst + '\'' +
                ", isPrint='" + isPrint + '\'' +
                ", bankNoticeStatus='" + bankNoticeStatus + '\'' +
                ", issuanceName='" + issuanceName + '\'' +
                ", issuanceMD5='" + issuanceMD5 + '\'' +
                ", temp1='" + temp1 + '\'' +
                ", temp2='" + temp2 + '\'' +
                ", temp3='" + temp3 + '\'' +
                ", temp4='" + temp4 + '\'' +
                ", temp5='" + temp5 + '\'' +
                ", temp6='" + temp6 + '\'' +
                ", temp7='" + temp7 + '\'' +
                ", bankRetPayCount=" + bankRetPayCount +
                ", lastRetPayTime=" + lastRetPayTime +
                ", stockRoomId='" + stockRoomId + '\'' +
                ", remark='" + remark + '\'' +
                ", status='" + status + '\'' +
                ", operator='" + operator + '\'' +
                ", creaDate=" + creaDate +
                ", updaDate=" + updaDate +
                '}';
    }
}
