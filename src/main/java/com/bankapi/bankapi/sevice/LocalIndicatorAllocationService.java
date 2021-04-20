package com.bankapi.bankapi.sevice;

import com.bankapi.bankapi.model.dormat.LocalIndicatorAllocation;

import java.util.List;

/**
 * @author Mr Fu
 * @version 1.0
 * @PackageName com.bankapi.bankapi.sevice
 * @ProjectName bankapi
 * @ClassName LocalIndicatorAllocationService
 * @Email fudaopin@gamil.com
 * @date 2021/4/20 下午4:58
 * @Description LocalIndicatorAllocation 本地数据分配服务层
 */
public interface LocalIndicatorAllocationService {

    public List<LocalIndicatorAllocation> getAllocation();
}
