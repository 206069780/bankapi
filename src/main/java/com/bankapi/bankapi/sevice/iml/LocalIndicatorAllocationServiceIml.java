package com.bankapi.bankapi.sevice.iml;

import com.bankapi.bankapi.dao.dormatdao.LocalIndicatorAllocationDao;
import com.bankapi.bankapi.model.dormat.LocalIndicatorAllocation;
import com.bankapi.bankapi.sevice.LocalIndicatorAllocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Mr Fu
 * @version 1.0
 * @PackageName com.bankapi.bankapi.sevice.iml
 * @ProjectName bankapi
 * @ClassName LocalIndicatorAllocationServiceIml
 * @Email fudaopin@gamil.com
 * @date 2021/4/20 下午4:59
 * @Description TODO
 */

@Service
public class LocalIndicatorAllocationServiceIml implements LocalIndicatorAllocationService {

    @Autowired
    LocalIndicatorAllocationDao localIndicatorAllocationDao;

    @Override
    public List<LocalIndicatorAllocation> getAllocation() {

        return localIndicatorAllocationDao.getLocalIndicatorAllocationList();
    }
}
