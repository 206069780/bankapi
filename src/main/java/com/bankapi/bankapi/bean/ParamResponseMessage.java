package com.bankapi.bankapi.bean;

import java.io.Serializable;

/**
 * @author Mr Fu
 * @version 1.0
 * @PackageName com.bankapi.bankapi.bean
 * @ProjectName bankapi
 * @ClassName ParamResponseMessage
 * @Email fudaopin@gamil.com
 * @date 2021/4/22 下午2:10
 * @Description messageBean
 */
public class ParamResponseMessage implements Serializable {

    public static final Long serialVersionUID = 1619071826004L;

    private String batchID;

    private int status;

    public String getBatchID() {
        return batchID;
    }

    public void setBatchID(String batchID) {
        this.batchID = batchID;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(char status) {
        this.status = status;
    }

    public ParamResponseMessage(String batchID, int status) {
        this.batchID = batchID;
        this.status = status;
    }
}
