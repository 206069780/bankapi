package com.bankapi.bankapi.sevice.iml;

import com.bankapi.bankapi.dao.dormatdao.SubsidyItemDao;
import com.bankapi.bankapi.model.dormat.SubsidyItem;
import com.bankapi.bankapi.sevice.SubsidyItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Mr Fu
 * @version 1.0
 * @PackageName com.bankapi.bankapi.sevice.iml
 * @ProjectName bankapi
 * @ClassName SubsidyItemServiceIml
 * @Email fudaopin@gamil.com
 * @date 2021/4/20 下午3:56
 * @Description TODO
 */

@Service
public class SubsidyItemServiceIml implements SubsidyItemService {

    @Autowired
    SubsidyItemDao subsidyItemDao;

    @Override
    public List<SubsidyItem> getSubsidyItems() {
        return subsidyItemDao.getSubsidyItemList();
    }
}
