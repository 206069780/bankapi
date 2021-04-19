package com.bankapi.bankapi.dao.dormatsysdao;

import com.bankapi.bankapi.model.dormatsys.Role;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @packageName: com.bankapi.bankapi.dao.dormatsysdao
 * @program: bankapi
 * @className: RoleDao
 * @author: Mr.FU
 * @Email: fudaopin@gmail.com
 * @createDate: 2021-04-19  23:57
 * @description: RoleDao
 **/

@Mapper
public interface RoleDao {
    public List<Role> getAllRoles();
}
