package com.bankapi.bankapi.sevice;

import org.apache.ibatis.annotations.Param;

/**
 * @author Mr Fu
 * @version 1.0
 * @PackageName com.bankapi.bankapi.sevice
 * @ProjectName bankapi
 * @ClassName ApprovalProcessEventDetailsService
 * @Email fudaopin@gamil.com
 * @date 2021/4/22 下午3:58
 * @Description ApprovalProcessEventDetailsService interface
 */
public interface ApprovalProcessEventDetailsService {
    /**
     * 银行返状态更新
     *
     * @param batchId
     * @return
     */
    public int statusUpdate(String batchId ,String status);
}
