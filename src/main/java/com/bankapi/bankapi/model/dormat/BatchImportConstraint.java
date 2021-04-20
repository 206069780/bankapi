package com.bankapi.bankapi.model.dormat;

import java.io.Serializable;
import java.util.Date;

/**
 * @author Mr Fu
 * @version 1.0
 * @PackageName com.bankapi.bankapi.model.dormat
 * @ProjectName bankapi
 * @ClassName BatchImportConstraint
 * @Email fudaopin@gamil.com
 * @date 2021/4/20 下午2:24
 * @Description 批次导入约束
 */
public class BatchImportConstraint implements Serializable {

    /**
     * ID	NUMBER	No		1	自增主键
     * NAME	VARCHAR2(255 BYTE)	No		2	约束名称
     * PARAMETER_COUNT	NUMBER	No		3	参数个数（-1：任意个）
     * PARAMETER_TYPE	VARCHAR2(255 BYTE)	No		4	参数类型（JSON数组：text/number）
     * STATUS	CHAR(1 BYTE)	No		5	状态（0：正常，1：禁用）
     * CREATOR_ID	VARCHAR2(20 BYTE)	No		6	创建人
     * CREATE_TIME	DATE	No		7	创建时间
     * UPDATE_TIME	DATE	No		8	更新时间
     */
    public static final Long serialVersionUID = -1618899751945L;

    /*自增id*/
    private Long        id;

    /*约束名称*/
    private String      constraintName;

    /*参数个数*/
    private int         paramCount;

    /*参数类型*/
    private String      paramType;

    /*状态*/
    private String      status;

    /*创建人*/
    private String      createUserId;

    /*创建时间*/
    private Date        createTime;

    /*更新时间*/
    private Date        updateTime;

    public BatchImportConstraint() {
    }

    public BatchImportConstraint(Long id, String constraintName, int paramCount, String paramType, String status, String createUserId, Date createTime, Date updateTime) {
        this.id = id;
        this.constraintName = constraintName;
        this.paramCount = paramCount;
        this.paramType = paramType;
        this.status = status;
        this.createUserId = createUserId;
        this.createTime = createTime;
        this.updateTime = updateTime;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getConstraintName() {
        return constraintName;
    }

    public void setConstraintName(String constraintName) {
        this.constraintName = constraintName;
    }

    public int getParamCount() {
        return paramCount;
    }

    public void setParamCount(int paramCount) {
        this.paramCount = paramCount;
    }

    public String getParamType() {
        return paramType;
    }

    public void setParamType(String paramType) {
        this.paramType = paramType;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
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

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}
