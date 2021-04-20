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

}
