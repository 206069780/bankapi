package com.bankapi.bankapi.sevice.iml;

import com.bankapi.bankapi.dao.dormatsysdao.UserRoleDao;
import com.bankapi.bankapi.model.dormatsys.UserRole;
import com.bankapi.bankapi.sevice.UserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Mr Fu
 * @version 1.0
 * @PackageName com.bankapi.bankapi.sevice.iml
 * @ProjectName bankapi
 * @ClassName UserRoleServiceIml
 * @Email fudaopin@gamil.com
 * @date 2021/4/20 上午11:02
 * @Description implements UserRoleService
 */
@Service
public class UserRoleServiceIml implements UserRoleService {

    @Autowired
    UserRoleDao userRoleDao;

    @Override
    public List<UserRole> getUserRoleList() {
        return userRoleDao.getRoles();
    }

}
