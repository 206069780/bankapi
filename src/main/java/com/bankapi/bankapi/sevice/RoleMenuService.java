package com.bankapi.bankapi.sevice;

import com.bankapi.bankapi.model.dormatsys.RoleMenu;

import java.util.List;

/**
 * @author Mr Fu
 * @version 1.0
 * @PackageName com.bankapi.bankapi.sevice
 * @ProjectName bankapi
 * @ClassName RoleMenuService
 * @Email fudaopin@gamil.com
 * @date 2021/4/20 上午9:39
 * @Description RoleMenuService 操作rolemune的数据
 */
public interface RoleMenuService {

    /**
     * 获取rolemune的所有数据
     * @return
     */
    public List<RoleMenu> getRoles();
}
