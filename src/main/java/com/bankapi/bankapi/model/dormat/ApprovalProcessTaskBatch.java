package com.bankapi.bankapi.model.dormat;

import java.io.Serializable;
import java.util.Date;

/**
 * @author Mr Fu
 * @version 1.0
 * @PackageName com.bankapi.bankapi.model.dormat
 * @ProjectName bankapi
 * @ClassName ApprovalProcessTaskBatch
 * @Email fudaopin@gamil.com
 * @date 2021/4/20 上午11:10
 * @Description 审批流程任务批次
 */
public class ApprovalProcessTaskBatch implements Serializable {

    /**
     * ID	                NUMBER	No		1	主键ID
     * DEPT_ID	            VARCHAR2(20 BYTE)	Yes		2	部门ID
     * SUBSIDY_CODE	            VARCHAR2(50 BYTE)	Yes		3	补贴项目编码
     * TIPS	                VARCHAR2(500 BYTE)	Yes		4	期次备注
     * TOTAL_COUNT	            NUMBER(38,0)	Yes	0	5	预算总人数
     * TOTAL_MONEY	        NUMBER(38,2)	Yes	0	6	预算总金额
     * REPLY_COUNT	        NUMBER(38,0)	Yes	0	7	已发总人数
     * REPLY_MONEY	        NUMBER(38,2)	Yes	0	8	已发总金额
     * TEMP1	        VARCHAR2(255 BYTE)	Yes		9	临时字段可用
     * TEMP2	            VARCHAR2(255 BYTE)	Yes		10	临时字段可用
     * TEMP3	            VARCHAR2(255 BYTE)	Yes		11	临时字段可用
     * TEMP4	            VARCHAR2(255 BYTE)	Yes		12	临时字段可用
     * TEMP5	            VARCHAR2(255 BYTE)	Yes		13	临时字段可用
     * TEMP6	            VARCHAR2(255 BYTE)	Yes		14	临时字段可用
     * TEMP7	            VARCHAR2(255 BYTE)	Yes		15	临时字段可用
     * TEMP8	            VARCHAR2(255 BYTE)	Yes		16	临时字段可用
     * ACTION	         NUMBER(2,0)	Yes		17	发放类型（0:个人，1：户主）
     * GS_ID	            VARCHAR2(255 BYTE)	Yes		18	股室ID
     * REMARK	         VARCHAR2(255 BYTE)	Yes		19	备注
     * STATUS	         CHAR(1 BYTE)	Yes	0	20	状态 (0：正常，1：已取消，2：已完成)
     * CREATE_USER_ID	    VARCHAR2(20 BYTE)	Yes		21	操作人
     * CREATE_TIME	            DATE	Yes	sysdate	22	创建时间
     */
    public static final Long serialVersionUID = 1618888265710L;

    /*主键id*/
    private Long id;

    /*部门ID*/
    private String departmentId;

    /*补贴项目编码*/
    private String SubsidyItemNumber;

    /*期次备注*/
    private String tips;

    /*预算总人数*/
    private long totalCount;

    /*预算总金额*/
    private long totalMoney;

    /*已发总人数*/
    private long areadyPayCount;

    /*已发总金额*/
    private long areadyPayTotalMoney;

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

    /*临时字段可用*/
    private String temp8;

    /*发放类型（0:个人，1：户主）*/
    private int action;

    /*股室ID*/
    private String stockRoomId;

    /*备注*/
    private String remark;

    /*状态 (0：正常，1：已取消，2：已完成)*/
    private String stats;

    /*操作人id*/
    private String operatorId;

    /*创建时间*/
    private Date createTime;

    public ApprovalProcessTaskBatch() {
    }

    public ApprovalProcessTaskBatch(Long id, String departmentId, String subsidyItemNumber, String tips, long totalCount, long totalMoney, long areadyPayCount, long areadyPayTotalMoney, String temp1, String temp2, String temp3, String temp4, String temp5, String temp6, String temp7, String temp8, int action, String stockRoomId, String remark, String stats, String operatorId, Date createTime) {
        this.id = id;
        this.departmentId = departmentId;
        SubsidyItemNumber = subsidyItemNumber;
        this.tips = tips;
        this.totalCount = totalCount;
        this.totalMoney = totalMoney;
        this.areadyPayCount = areadyPayCount;
        this.areadyPayTotalMoney = areadyPayTotalMoney;
        this.temp1 = temp1;
        this.temp2 = temp2;
        this.temp3 = temp3;
        this.temp4 = temp4;
        this.temp5 = temp5;
        this.temp6 = temp6;
        this.temp7 = temp7;
        this.temp8 = temp8;
        this.action = action;
        this.stockRoomId = stockRoomId;
        this.remark = remark;
        this.stats = stats;
        this.operatorId = operatorId;
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

    public String getSubsidyItemNumber() {
        return SubsidyItemNumber;
    }

    public void setSubsidyItemNumber(String subsidyItemNumber) {
        SubsidyItemNumber = subsidyItemNumber;
    }

    public String getTips() {
        return tips;
    }

    public void setTips(String tips) {
        this.tips = tips;
    }

    public long getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(long totalCount) {
        this.totalCount = totalCount;
    }

    public long getTotalMoney() {
        return totalMoney;
    }

    public void setTotalMoney(long totalMoney) {
        this.totalMoney = totalMoney;
    }

    public long getAreadyPayCount() {
        return areadyPayCount;
    }

    public void setAreadyPayCount(long areadyPayCount) {
        this.areadyPayCount = areadyPayCount;
    }

    public long getAreadyPayTotalMoney() {
        return areadyPayTotalMoney;
    }

    public void setAreadyPayTotalMoney(long areadyPayTotalMoney) {
        this.areadyPayTotalMoney = areadyPayTotalMoney;
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

    public String getTemp8() {
        return temp8;
    }

    public void setTemp8(String temp8) {
        this.temp8 = temp8;
    }

    public int getAction() {
        return action;
    }

    public void setAction(int action) {
        this.action = action;
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

    public String getStats() {
        return stats;
    }

    public void setStats(String stats) {
        this.stats = stats;
    }

    public String getOperatorId() {
        return operatorId;
    }

    public void setOperatorId(String operatorId) {
        this.operatorId = operatorId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}
