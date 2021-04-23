package com.bankapi.bankapi.sevice;

import com.bankapi.bankapi.model.dormat.ApprovalProcessEvent;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author Mr Fu
 * @version 1.0
 * @PackageName com.bankapi.bankapi.sevice
 * @ProjectName bankapi
 * @ClassName ApprovalProcessEventDao
 * @Email fudaopin@gamil.com
 * @date 2021/4/20 下午2:15
 * @Description TODO
 */
public interface ApprovalProcessEventService {

    public List<ApprovalProcessEvent> getApprovalProcessEvents();

    /**
     * 银行受理状态更新
     *
     * @param id 需要修改的批次id
     * @return 返回更新的批次数量
     */
    public int statusUpdat(String id, String type, String status);
}
