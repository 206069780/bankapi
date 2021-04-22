package com.bankapi.bankapi.dao.dormatdao;

import com.bankapi.bankapi.model.dormat.ApprovalProcessEvent;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author Mr Fu
 * @version 1.0
 * @PackageName com.bankapi.bankapi.dao.dormatdao
 * @ProjectName bankapi
 * @ClassName ApprovalProcessEventDao
 * @Email fudaopin@gamil.com
 * @date 2021/4/20 下午2:04
 * @Description ApprovalProcessEvent 审批流程事件数据持久化
 */

@Mapper
public interface ApprovalProcessEventDao {

    public List<ApprovalProcessEvent> getApprovalProcessEvents();

    /**
     * 银行受理状态更新
     * @param id 需要修改的批次id
     * @return 返回更新的批次数量
     */
    public int statusUpdat(@Param("id") String id);

}
