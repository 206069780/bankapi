package com.bankapi.bankapi.sevice.iml;

import com.bankapi.bankapi.dao.dormatdao.ApprovalBatchReplyDao;
import com.bankapi.bankapi.model.dormat.ApprovalBatchReply;
import com.bankapi.bankapi.sevice.ApprovalBatchReplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Map;

/**
 * @author Mr Fu
 * @version 1.0
 * @PackageName com.bankapi.bankapi.sevice.iml
 * @ProjectName bankapi
 * @ClassName ApprovalBatchReplyServiceIml
 * @Email fudaopin@gamil.com
 * @date 2021/4/23 下午3:02
 * @Description TODO
 */

@Service
public class ApprovalBatchReplyServiceIml implements ApprovalBatchReplyService {

    @Autowired
    ApprovalBatchReplyDao approvalBatchReplyDao;

    @Override
    public int approvaDateSave(ApprovalBatchReply approvaDateSave) {

        if (approvaDateSave != null && approvalBatchReplyDao.approvaDateSave(approvaDateSave) > 0) {
            return 1;
        } else {
            return 0;
        }
    }

    @Override
    public Map<BigDecimal, BigDecimal> getapprovalId(String BATCH_ID, String BANK_NO) {
        if (BANK_NO != null && BATCH_ID != null) {
            if (approvalBatchReplyDao.getapprovalId(BATCH_ID, BANK_NO) != null) {
                return approvalBatchReplyDao.getapprovalId(BATCH_ID, BANK_NO);
            }
            return null;
        }
        return null;
    }

    public boolean findByDtilId(Integer id) {
        if (id != null)
        {
            return approvalBatchReplyDao.hasDtilId(id) > 0;
        }
        return false;
    }
}
