package com.bankapi.bankapi.dao.dormatdao;

import com.bankapi.bankapi.model.dormat.ApprovalProcessTaskBatch;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author Mr Fu
 * @version 1.0
 * @PackageName com.bankapi.bankapi.dao.dormatdao
 * @ProjectName bankapi
 * @ClassName ApprovalProcessTaskBatchDao
 * @Email fudaopin@gamil.com
 * @date 2021/4/20 上午11:25
 * @Description 审批流程任务批次 ApprovalProcessTaskBatch 数据持久化
 */

@Mapper
public interface ApprovalProcessTaskBatchDao {

    /**
     * 获取审批流程任务批次数据
     **/
    public List<ApprovalProcessTaskBatch> getApprovalProcessTaskBatchList();

    /**
     * 银行反馈数据更新
     *
     * @param id
     * @return
     */
    public int updateStatus(@Param("id") String id, @Param("status") String status);


}
