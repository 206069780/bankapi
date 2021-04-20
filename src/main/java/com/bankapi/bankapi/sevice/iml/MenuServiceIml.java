package com.bankapi.bankapi.sevice.iml;

import com.bankapi.bankapi.dao.dormatsysdao.MenuDao;
import com.bankapi.bankapi.model.dormatsys.Menu;
import com.bankapi.bankapi.sevice.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Mr Fu
 * @version 1.0
 * @PackageName com.bankapi.bankapi.sevice.iml
 * @ProjectName bankapi
 * @ClassName MenuServiceIml
 * @Email fudaopin@gamil.com
 * @date 2021/4/20 上午10:38
 * @Description MenuService 实现
 */

@Service
public class MenuServiceIml implements MenuService {

    @Autowired
    MenuDao menuDao;

    @Override
    public List<Menu> getMenuList() {
        return menuDao.getMenus();
    }
}
