package com.bankapi.bankapi.dao.dormatsysdao;

import com.bankapi.bankapi.model.dormatsys.RoleMenu;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author Mr Fu
 * @version 1.0
 * @PackageName com.bankapi.bankapi.dao.dormatsysdao
 * @ProjectName bankapi
 * @ClassName RoleMenuDao
 * @Email fudaopin@gamil.com
 * @date 2021/4/20 上午9:29
 * @Description TODO
 */

@Mapper
public interface RoleMenuDao {

    /**
     * 获取Rolemune
     *
     * @return
     */
    public List<RoleMenu> getRoleMenuList();
}
