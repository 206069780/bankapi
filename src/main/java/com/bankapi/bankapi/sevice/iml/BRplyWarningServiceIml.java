package com.bankapi.bankapi.sevice.iml;

import com.bankapi.bankapi.dao.dormatdao.BRplyWarningDao;
import com.bankapi.bankapi.model.dormat.BRplyWarning;
import com.bankapi.bankapi.sevice.BRplyWarningService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @packageName: com.bankapi.bankapi.sevice.iml
 * @program: bankapi
 * @className: BRplyWarningServiceIml
 * @author: Mr.FU
 * @Email: fudaopin@gmail.com
 * @createDate: 2021-04-28  20:43
 * @description: BRplyWarningService 实现
 **/

@Service
public class BRplyWarningServiceIml implements BRplyWarningService {

    @Autowired
    BRplyWarningDao bRplyWarningDao;

    public boolean save(BRplyWarning bRplyWarning){
        return bRplyWarningDao.save(bRplyWarning)>0;
    }

    @Override
    public String getlastest() {
        return bRplyWarningDao.getLastestId();
    }

    @Override
    public String getUserId(String batch_id) {
        return bRplyWarningDao.getUserId(batch_id);
    }
}
