package com.bankapi.bankapi.model.dormat;

import java.io.Serializable;
import java.util.Date;

/**
 * @packageName: com.bankapi.bankapi.model.dormat
 * @program: bankapi
 * @className: BRplyWarning
 * @author: Mr.FU
 * @Email: fudaopin@gmail.com
 * @createDate: 2021-04-28  20:34
 * @description: 资金发放失败
 **/
public class BRplyWarning  implements Serializable {

    public static final Long serialVersionUID = -1619613336767L;

    private int     ID;

    /*批次id*/
    private String  BATCH_ID;

    /*详情id*/
    private String  DETAIL_ID;

    /*reply id*/
    private int     RECORD_ID;

    /*预警类型*/
    private String  TYPE;

    /*备注*/
    private String  REMARK;

    /*经办人*/
    private String  CREATE_USER_ID;

    /*创建时间*/
    private Date    CREATE_TIME;

    public BRplyWarning(int ID, String BATCH_ID, String DETAIL_ID, int RECORD_ID, String TYPE, String REMARK, String CREATE_USER_ID, Date CREATE_TIME) {
        this.ID = ID;
        this.BATCH_ID = BATCH_ID;
        this.DETAIL_ID = DETAIL_ID;
        this.RECORD_ID = RECORD_ID;
        this.TYPE = TYPE;
        this.REMARK = REMARK;
        this.CREATE_USER_ID = CREATE_USER_ID;
        this.CREATE_TIME = CREATE_TIME;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getBATCH_ID() {
        return BATCH_ID;
    }

    public void setBATCH_ID(String BATCH_ID) {
        this.BATCH_ID = BATCH_ID;
    }

    public String getDETAIL_ID() {
        return DETAIL_ID;
    }

    public void setDETAIL_ID(String DETAIL_ID) {
        this.DETAIL_ID = DETAIL_ID;
    }

    public int getRECORD_ID() {
        return RECORD_ID;
    }

    public void setRECORD_ID(int RECORD_ID) {
        this.RECORD_ID = RECORD_ID;
    }

    public String getTYPE() {
        return TYPE;
    }

    public void setTYPE(String TYPE) {
        this.TYPE = TYPE;
    }

    public String getREMARK() {
        return REMARK;
    }

    public void setREMARK(String REMARK) {
        this.REMARK = REMARK;
    }

    public String getCREATE_USER_ID() {
        return CREATE_USER_ID;
    }

    public void setCREATE_USER_ID(String CREATE_USER_ID) {
        this.CREATE_USER_ID = CREATE_USER_ID;
    }

    public Date getCREATE_TIME() {
        return CREATE_TIME;
    }

    public void setCREATE_TIME(Date CREATE_TIME) {
        this.CREATE_TIME = CREATE_TIME;
    }
}
