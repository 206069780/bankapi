package com.bankapi.bankapi.bean;

import java.io.Serializable;
import java.util.List;

/**
 * @packageName: com.bankapi.bankapi.bean
 * @program: bankapi
 * @className: RequestMessagebean
 * @author: Mr.FU
 * @Email: fudaopin@gmail.com
 * @createDate: 2021-04-18  22:46
 * @description: RequestMessagebean 封装返回的的消息
 **/
public class RequestMessageBean implements Serializable {

    public static final Long serialVersionUID = 1618844236006L;

    private String message;

    private boolean status;

    private List<ApiData> data;

    public RequestMessageBean(){}

    public RequestMessageBean(String message, boolean status, List<ApiData> apiData) {
        this.message = message;
        this.status = status;
        this.data = apiData;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public List<ApiData> getData() {
        return data;
    }

    public void setData(List<ApiData> data) {
        this.data = data;
    }

}
