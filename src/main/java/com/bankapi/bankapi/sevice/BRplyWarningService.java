package com.bankapi.bankapi.sevice;

/**
 * @packageName: com.bankapi.bankapi.sevice
 * @program: bankapi
 * @className: BRplyWarningService
 * @author: Mr.FU
 * @Email: fudaopin@gmail.com
 * @createDate: 2021-04-28  20:43
 * @description: BRplyWarning服务层
 **/
public interface BRplyWarningService {
    public int getlastest();

    public String getUserId(String batch_id);
}
