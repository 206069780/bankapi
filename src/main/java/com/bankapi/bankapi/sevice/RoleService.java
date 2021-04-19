package com.bankapi.bankapi.sevice;

import com.bankapi.bankapi.model.dormatsys.Role;

import java.util.List;

/**
 * @packageName: com.bankapi.bankapi.sevice
 * @program: bankapi
 * @className: RoleService
 * @author: Mr.FU
 * @Email: fudaopin@gmail.com
 * @createDate: 2021-04-20  00:04
 * @description: RoleService interface
 **/
public interface RoleService {

    /**
     * 获取所用的角色信息
     * @return
     */
    public List<Role> getALlRoles();
}
