package com.bankapi.bankapi.dao.dormatsysdao;

import com.bankapi.bankapi.model.dormatsys.Menu;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author Mr Fu
 * @version 1.0
 * @PackageName com.bankapi.bankapi.dao.dormatsysdao
 * @ProjectName bankapi
 * @ClassName MenuDao
 * @Email fudaopin@gamil.com
 * @date 2021/4/20 上午10:36
 * @Description Menu 持久化操作
 */

@Mapper
public interface MenuDao {

    public List<Menu> getMenus();
}
