package com.bankapi.bankapi.sevice.iml;

import com.bankapi.bankapi.dao.dormatdao.ApprovalProcessEventDetailsDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Mr Fu
 * @version 1.0
 * @PackageName com.bankapi.bankapi.sevice.iml
 * @ProjectName bankapi
 * @ClassName ApprovalProcessEventDetailsService
 * @Email fudaopin@gamil.com
 * @date 2021/4/22 下午3:59
 * @Description TODO
 */
@Service
public class ApprovalProcessEventDetailsService implements com.bankapi.bankapi.sevice.ApprovalProcessEventDetailsService {

    @Autowired
    ApprovalProcessEventDetailsDao approvalProcessEventDetailsDao;
    @Override
    public int statusUpdate(String batchId) {
        return approvalProcessEventDetailsDao.statusUpdate(batchId);
    }
}
