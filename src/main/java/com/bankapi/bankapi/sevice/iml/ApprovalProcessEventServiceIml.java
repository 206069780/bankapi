package com.bankapi.bankapi.sevice.iml;

import com.bankapi.bankapi.dao.dormatdao.ApprovalProcessEventDao;
import com.bankapi.bankapi.model.dormat.ApprovalProcessEvent;
import com.bankapi.bankapi.sevice.ApprovalProcessEventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

/**
 * @author Mr Fu
 * @version 1.0
 * @PackageName com.bankapi.bankapi.sevice.iml
 * @ProjectName bankapi
 * @ClassName ApprovalProcessEventDaoServiceIml
 * @Email fudaopin@gamil.com
 * @date 2021/4/20 下午2:17
 * @Description TODO
 */

@Service
public class ApprovalProcessEventServiceIml implements ApprovalProcessEventService {

    @Autowired
    ApprovalProcessEventDao approvalProcessEventDao;

    @Override
    public List<ApprovalProcessEvent> getApprovalProcessEvents() {
        return approvalProcessEventDao.getApprovalProcessEvents();
    }

    /**
     * @param id 需要修改的批次id
     * @return
     */
    @Override
    public int statusUpdat(String id, String type, String status) {
        int res = approvalProcessEventDao.statusUpdat(id, type, status);
        if (res > 0) {
            return 1;
        } else {
            return 0;
        }
    }

    @Override
    public boolean updateFileName(String id, String fileName, String md5) {
        if (id == null || id.length() == 0 || fileName == null || fileName.length() == 0 || md5 == null || md5.length() == 0)
            return false;
        return approvalProcessEventDao.updateFileName(id, fileName, md5) > 0;
    }


}
