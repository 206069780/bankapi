package com.bankapi.bankapi.sevice.iml;

import com.bankapi.bankapi.dao.dormatsysdao.RoleMenuDao;
import com.bankapi.bankapi.model.dormatsys.RoleMenu;
import com.bankapi.bankapi.sevice.RoleMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Mr Fu
 * @version 1.0
 * @PackageName com.bankapi.bankapi.sevice.iml
 * @ProjectName bankapi
 * @ClassName RoleMenuServiceIml
 * @Email fudaopin@gamil.com
 * @date 2021/4/20 上午9:41
 * @Description TODO
 */

@Service
public class RoleMenuServiceIml implements RoleMenuService {

    @Autowired
    RoleMenuDao roleMenuDao;

    @Override
    public List<RoleMenu> getRoles() {
        return roleMenuDao.getRoleMenuList();
    }
}
