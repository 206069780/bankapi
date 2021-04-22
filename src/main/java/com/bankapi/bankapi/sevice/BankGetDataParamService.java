package com.bankapi.bankapi.sevice;

import com.bankapi.bankapi.model.dormat.BankGetDataParam;

/**
 * @author Mr Fu
 * @version 1.0
 * @PackageName com.bankapi.bankapi.sevice
 * @ProjectName bankapi
 * @ClassName BankGetDataParamService
 * @Email fudaopin@gamil.com
 * @date 2021/4/22 下午4:03
 * @Description TODO
 */
public interface BankGetDataParamService {


    /**
     * 保存银行受理的批次信息
     *
     * @param bank 批次相关信息
     * @return 增加的数据行数
     */
    public int DataParamSave(BankGetDataParam bank);
}
