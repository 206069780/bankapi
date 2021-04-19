package com.bankapi.bankapi.sevice.iml;

import com.bankapi.bankapi.dao.dormatsysdao.RoleDao;
import com.bankapi.bankapi.model.dormatsys.Role;
import com.bankapi.bankapi.sevice.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @packageName: com.bankapi.bankapi.sevice.iml
 * @program: bankapi
 * @className: RoleServiceIml
 * @author: Mr.FU
 * @Email: fudaopin@gmail.com
 * @createDate: 2021-04-20  00:05
 * @description: TODO
 **/

@Service
public class RoleServiceIml implements RoleService {

    @Autowired
    RoleDao roleDao;

    /**
     * 获取所有的角色信息
     * @return
     */
    @Override
    public List<Role> getALlRoles() {
        return roleDao.getAllRoles();
    }
}
