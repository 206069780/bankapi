package com.bankapi.bankapi.dao.dormatdao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author Mr Fu
 * @version 1.0
 * @PackageName com.bankapi.bankapi.dao.dormatdao
 * @ProjectName bankapi
 * @ClassName ApprovalProcessEventDetails
 * @Email fudaopin@gamil.com
 * @date 2021/4/22 下午3:27
 * @Description 审批流程事件详情 持久化接口
 */
@Mapper
public interface ApprovalProcessEventDetailsDao {

    /**
     * 银行返回数据受理状态更新
     * @param batchId
     * @return
     */
    public int statusUpdate(@Param("batchId") String batchId);
}
