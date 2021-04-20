package com.bankapi.bankapi.sevice;

import com.bankapi.bankapi.model.dormatsys.Menu;

import java.util.List;

/**
 * @author Mr Fu
 * @version 1.0
 * @PackageName com.bankapi.bankapi.sevice
 * @ProjectName bankapi
 * @ClassName MenuService
 * @Email fudaopin@gamil.com
 * @date 2021/4/20 上午10:38
 * @Description Menu  服务层
 */
public interface MenuService {

    public List<Menu> getMenuList();
}
