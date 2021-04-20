package com.bankapi.bankapi.dao.dormatsysdao;

import com.bankapi.bankapi.model.dormatsys.UserRole;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author Mr Fu
 * @version 1.0
 * @PackageName com.bankapi.bankapi.dao.dormatsysdao
 * @ProjectName bankapi
 * @ClassName UserRoleDao
 * @Email fudaopin@gamil.com
 * @date 2021/4/20 上午10:54
 * @Description TODO
 */
@Mapper
public interface UserRoleDao {

    public List<UserRole> getRoles();
}
