package com.bankapi.bankapi.sevice;

import com.bankapi.bankapi.model.dormat.ApprovalBatchReply;
import org.apache.ibatis.annotations.Param;

import java.math.BigDecimal;
import java.util.Map;

/**
 * @author Mr Fu
 * @version 1.0
 * @PackageName com.bankapi.bankapi.sevice
 * @ProjectName bankapi
 * @ClassName ApprovalBatchReplyService
 * @Email fudaopin@gamil.com
 * @date 2021/4/23 下午3:01
 * @Description ApprovalBatchReplyDao 服务层
 */
public interface ApprovalBatchReplyService {


    public int approvaDateSave(ApprovalBatchReply approvaDateSave);


    public Map<BigDecimal, BigDecimal> getapprovalId(String BATCH_ID, String BANK_NO);

    public boolean findByDtilId(Integer id);

    public boolean findByBatchId(String BATCH_ID);
}
