package com.bankapi.bankapi.dao.dormatdao;

import com.bankapi.bankapi.model.dormat.ApprovalBatchReply;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.math.BigDecimal;
import java.util.Map;

/**
 * @author Mr Fu
 * @version 1.0
 * @PackageName com.bankapi.bankapi.dao.dormatdao
 * @ProjectName bankapi
 * @ClassName ApprovalBatchReplyDao
 * @Email fudaopin@gamil.com
 * @date 2021/4/23 上午10:08
 * @Description ApprovalBatchReply 银行反馈数据持久化
 */

@Mapper
public interface ApprovalBatchReplyDao {

    public int approvaDateSave(ApprovalBatchReply approvaDateSave);


    public Map<BigDecimal, BigDecimal> getapprovalId(@Param("BATCH_ID") String BATCH_ID, @Param("BANK_NO") String BANK_NO);

    public int hasDtilId(@Param("id") Integer id);
}
