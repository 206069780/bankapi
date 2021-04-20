package com.bankapi.bankapi.model.dormat;

import java.io.Serializable;
import java.util.Date;

/**
 * @author Mr Fu
 * @version 1.0
 * @PackageName com.bankapi.bankapi.model.dormat
 * @ProjectName bankapi
 * @ClassName LocalIndicatorAllocation
 * @Email fudaopin@gamil.com
 * @date 2021/4/20 下午4:29
 * @Description 本地指标分配数据
 */
public class LocalIndicatorAllocation implements Serializable {

    /**
     * ID	NUMBER	No		1	自增ID
     * BATCH_ID	VARCHAR2(20 BYTE)	Yes		2	明细编号
     * ZBID	VARCHAR2(20 BYTE)	Yes		3	指标ID
     * ZBWH	VARCHAR2(255 BYTE)	Yes		4	指标文号
     * FWRQ	VARCHAR2(255 BYTE)	Yes		5	发文日期
     * DEPT	VARCHAR2(255 BYTE)	Yes		6	股室
     * DIVID	VARCHAR2(20 BYTE)	Yes		7	单位编码
     * DIVNAME	VARCHAR2(255 BYTE)	Yes		8	单位名称
     * PROJNAME	VARCHAR2(255 BYTE)	Yes		9	补贴项目名称
     * GNFL	VARCHAR2(255 BYTE)	Yes		10	功能分类
     * BMJJFL	VARCHAR2(255 BYTE)	Yes		11	部门经济分类
     * ZFJJFL	VARCHAR2(255 BYTE)	Yes		12	政府经济分类
     * ZJXZ	VARCHAR2(255 BYTE)	Yes		13	资金性质
     * ZBLY	VARCHAR2(255 BYTE)	Yes		14	指标来源
     * XMFL	VARCHAR2(255 BYTE)	Yes		15	项目分类
     * YSXM	VARCHAR2(255 BYTE)	Yes		16	预算项目
     * HSLX	VARCHAR2(255 BYTE)	Yes		17	核算类型
     * JZLX	VARCHAR2(255 BYTE)	Yes		18	结转类型
     * AMT	NUMBER(28,2)	Yes		19	金额
     * CREATE_USER_ID	VARCHAR2(20 BYTE)	Yes		20	操作者
     * CREATE_TIME	DATE	Yes	sysdate	21	创建时间
     **/
    public static final Long serialVersionUID = -1618907378603L;

    /*自增id*/
    private Long   id;

    /*明细编号*/
    private String detailNumber;

    /*指标id*/
    private String indicatorId;

    /*指标文号*/
    private String indicatorTxtNumber;

    /*发文日期*/
    private String indicatorTxtSeanDate;

    /*股室*/
    private String tockerRoom;

    /*单位编号*/
    private String unitCode;

    /*单位名称*/
    private String unitName;

    /*补贴项目名称*/
    private String subsidyName;

    /*功能分类*/
    private String functionType;

    /*部门经济分类*/
    private String departmetEconomicType;

    /*政府经济分类*/
    private String governmentEconomicType;

    /*资金性质*/
    private String natureFunds;

    /*指标来源*/
    private String indicatorSource;

    /*项目分类*/
    private String projectType;

    /*预算项目*/
    private String preProject;

    /*核算类型*/
    private String checkType;

    /*结转类型*/
    private String JZLX;

    /*金额*/
    private Long   money;

    /*操作人*/
    private String operator;

    /*创建时间*/
    private Date   createTime;

    public LocalIndicatorAllocation(){}

    public LocalIndicatorAllocation(Long id, String detailNumber, String indicatorId, String indicatorTxtNumber, String indicatorTxtSeanDate, String tockerRoom, String unitCode, String unitName, String subsidyName, String functionType, String departmetEconomicType, String governmentEconomicType, String natureFunds, String indicatorSource, String projectType, String preProject, String checkType, String JZLX, Long money, String operator, Date createTime) {
        this.id = id;
        this.detailNumber = detailNumber;
        this.indicatorId = indicatorId;
        this.indicatorTxtNumber = indicatorTxtNumber;
        this.indicatorTxtSeanDate = indicatorTxtSeanDate;
        this.tockerRoom = tockerRoom;
        this.unitCode = unitCode;
        this.unitName = unitName;
        this.subsidyName = subsidyName;
        this.functionType = functionType;
        this.departmetEconomicType = departmetEconomicType;
        this.governmentEconomicType = governmentEconomicType;
        this.natureFunds = natureFunds;
        this.indicatorSource = indicatorSource;
        this.projectType = projectType;
        this.preProject = preProject;
        this.checkType = checkType;
        this.JZLX = JZLX;
        this.money = money;
        this.operator = operator;
        this.createTime = createTime;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDetailNumber() {
        return detailNumber;
    }

    public void setDetailNumber(String detailNumber) {
        this.detailNumber = detailNumber;
    }

    public String getIndicatorId() {
        return indicatorId;
    }

    public void setIndicatorId(String indicatorId) {
        this.indicatorId = indicatorId;
    }

    public String getIndicatorTxtNumber() {
        return indicatorTxtNumber;
    }

    public void setIndicatorTxtNumber(String indicatorTxtNumber) {
        this.indicatorTxtNumber = indicatorTxtNumber;
    }

    public String getIndicatorTxtSeanDate() {
        return indicatorTxtSeanDate;
    }

    public void setIndicatorTxtSeanDate(String indicatorTxtSeanDate) {
        this.indicatorTxtSeanDate = indicatorTxtSeanDate;
    }

    public String getTockerRoom() {
        return tockerRoom;
    }

    public void setTockerRoom(String tockerRoom) {
        this.tockerRoom = tockerRoom;
    }

    public String getUnitCode() {
        return unitCode;
    }

    public void setUnitCode(String unitCode) {
        this.unitCode = unitCode;
    }

    public String getUnitName() {
        return unitName;
    }

    public void setUnitName(String unitName) {
        this.unitName = unitName;
    }

    public String getSubsidyName() {
        return subsidyName;
    }

    public void setSubsidyName(String subsidyName) {
        this.subsidyName = subsidyName;
    }

    public String getFunctionType() {
        return functionType;
    }

    public void setFunctionType(String functionType) {
        this.functionType = functionType;
    }

    public String getDepartmetEconomicType() {
        return departmetEconomicType;
    }

    public void setDepartmetEconomicType(String departmetEconomicType) {
        this.departmetEconomicType = departmetEconomicType;
    }

    public String getGovernmentEconomicType() {
        return governmentEconomicType;
    }

    public void setGovernmentEconomicType(String governmentEconomicType) {
        this.governmentEconomicType = governmentEconomicType;
    }

    public String getNatureFunds() {
        return natureFunds;
    }

    public void setNatureFunds(String natureFunds) {
        this.natureFunds = natureFunds;
    }

    public String getIndicatorSource() {
        return indicatorSource;
    }

    public void setIndicatorSource(String indicatorSource) {
        this.indicatorSource = indicatorSource;
    }

    public String getProjectType() {
        return projectType;
    }

    public void setProjectType(String projectType) {
        this.projectType = projectType;
    }

    public String getPreProject() {
        return preProject;
    }

    public void setPreProject(String preProject) {
        this.preProject = preProject;
    }

    public String getCheckType() {
        return checkType;
    }

    public void setCheckType(String checkType) {
        this.checkType = checkType;
    }

    public String getJZLX() {
        return JZLX;
    }

    public void setJZLX(String JZLX) {
        this.JZLX = JZLX;
    }

    public Long getMoney() {
        return money;
    }

    public void setMoney(Long money) {
        this.money = money;
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
        return "LocalIndicatorAllocation{" +
                "detailNumber='" + detailNumber + '\'' +
                ", indicatorId='" + indicatorId + '\'' +
                ", indicatorTxtNumber='" + indicatorTxtNumber + '\'' +
                ", indicatorTxtSeanDate='" + indicatorTxtSeanDate + '\'' +
                ", unitName='" + unitName + '\'' +
                ", subsidyName='" + subsidyName + '\'' +
                ", departmetEconomicType='" + departmetEconomicType + '\'' +
                ", natureFunds='" + natureFunds + '\'' +
                ", indicatorSource='" + indicatorSource + '\'' +
                ", operator='" + operator + '\'' +
                ", createTime=" + createTime +
                '}';
    }
}
