package com.bankapi.bankapi.sevice;

import com.bankapi.bankapi.model.dormat.ApprovalProcessEvent;

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
public  interface ApprovalProcessEventDaoService {

    public List<ApprovalProcessEvent> getApprovalProcessEvents();
}
