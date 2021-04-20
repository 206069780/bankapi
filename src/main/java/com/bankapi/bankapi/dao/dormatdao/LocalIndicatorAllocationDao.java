package com.bankapi.bankapi.dao.dormatdao;

import com.bankapi.bankapi.model.dormat.LocalIndicatorAllocation;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author Mr Fu
 * @version 1.0
 * @PackageName com.bankapi.bankapi.dao.dormatdao
 * @ProjectName bankapi
 * @ClassName LocalIndicatorAllocationDao
 * @Email fudaopin@gamil.com
 * @date 2021/4/20 下午4:52
 * @Description LocalIndicatorAllocation 本地指标分配 数据持久化
 */

@Mapper
public interface LocalIndicatorAllocationDao {

    public List<LocalIndicatorAllocation> getLocalIndicatorAllocationList();
}
