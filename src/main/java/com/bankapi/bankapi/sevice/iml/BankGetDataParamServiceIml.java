package com.bankapi.bankapi.sevice.iml;

import com.bankapi.bankapi.dao.dormatdao.BankGetDataParamDao;
import com.bankapi.bankapi.model.dormat.BankGetDataParam;
import com.bankapi.bankapi.sevice.BankGetDataParamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Mr Fu
 * @version 1.0
 * @PackageName com.bankapi.bankapi.sevice.iml
 * @ProjectName bankapi
 * @ClassName BankGetDataParamServiceIml
 * @Email fudaopin@gamil.com
 * @date 2021/4/22 下午4:06
 * @Description TODO
 */

@Service
public class BankGetDataParamServiceIml implements BankGetDataParamService {

    @Autowired
    BankGetDataParamDao bankGetDataParamDao;

    @Override
    public int DataParamSave(BankGetDataParam bank) {
        return bankGetDataParamDao.DataParamSave(bank);
    }
}
