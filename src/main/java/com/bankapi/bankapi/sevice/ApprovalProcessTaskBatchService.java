package com.bankapi.bankapi.sevice;

import com.bankapi.bankapi.model.dormat.ApprovalProcessTaskBatch;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author Mr Fu
 * @version 1.0
 * @PackageName com.bankapi.bankapi.sevice
 * @ProjectName bankapi
 * @ClassName ApprovalProcessTaskBatchService
 * @Email fudaopin@gamil.com
 * @date 2021/4/20 上午11:36
 * @Description ApprovalProcessTaskBatchService interface
 */
public interface ApprovalProcessTaskBatchService {


    public List<ApprovalProcessTaskBatch> getApprovalProcessTasks();

    /**
     * 银行反馈数据更新
     *
     * @param status
     * @return
     */
    public boolean updateStatus(String status, String id);
}
