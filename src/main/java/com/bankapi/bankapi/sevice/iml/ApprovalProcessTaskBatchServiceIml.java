package com.bankapi.bankapi.sevice.iml;

import com.bankapi.bankapi.dao.dormatdao.ApprovalProcessTaskBatchDao;
import com.bankapi.bankapi.model.dormat.ApprovalProcessTaskBatch;
import com.bankapi.bankapi.sevice.ApprovalProcessTaskBatchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Mr Fu
 * @version 1.0
 * @PackageName com.bankapi.bankapi.sevice.iml
 * @ProjectName bankapi
 * @ClassName ApprovalProcessTaskBatchServiceIml
 * @Email fudaopin@gamil.com
 * @date 2021/4/20 上午11:37
 * @Description implements ApprovalProcessTaskBatchService
 */
@Service
public class ApprovalProcessTaskBatchServiceIml implements ApprovalProcessTaskBatchService {

    @Autowired
    ApprovalProcessTaskBatchDao approvalProcessTaskBatchDao;

    @Override
    public List<ApprovalProcessTaskBatch> getApprovalProcessTasks() {
        return approvalProcessTaskBatchDao.getApprovalProcessTaskBatchList();
    }

    @Override
    public boolean updateStatus(String id,String status) {

        if (id != null && !id.isEmpty()) {
            return approvalProcessTaskBatchDao.updateStatus(id,status) > 0;
        } else {
            return false;
        }
    }
}
