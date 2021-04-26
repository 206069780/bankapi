package com.bankapi.bankapi.sevice.iml;

import com.bankapi.bankapi.dao.dormatdao.BankGetDataParamDao;
import com.bankapi.bankapi.model.dormat.BankGetDataParam;
import com.bankapi.bankapi.sevice.BankGetDataParamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Mr Fu
 * @version 1.0
 * @PackageName com.bankapi.bankapi.sevice.iml
 * @ProjectName bankapi
 * @ClassName BankGetDataParamServiceIml
 * @Email fudaopin@gamil.com
 * @date 2021/4/22 下午4:06
 * @Description 银行受理状态数据
 */

@Service
public class BankGetDataParamServiceIml implements BankGetDataParamService {

    @Autowired
    BankGetDataParamDao bankGetDataParamDao;

    /**
     * 银行受理参数保存
     *
     * @param bank 批次相关信息
     * @return
     */
    @Override
    public boolean DataParamSave(BankGetDataParam bank) {
        if (bank != null) {
            if (bankGetDataParamDao.DataParamSave(bank) > 0) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean DataParamUpDataParam(String status, String id) {
        if (status != null && id != null && !status.isEmpty() && !id.isEmpty()) {
            return bankGetDataParamDao.DataParamUpDataParam(status, id);
        }
        return false;
    }

    @Override
    public List<BankGetDataParam> getParam() {
        return bankGetDataParamDao.getParam();
    }

    @Override
    public List<BankGetDataParam> getfinish() {
        return bankGetDataParamDao.getFinish();
    }

}
