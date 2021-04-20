package com.bankapi.bankapi.sevice;

import com.bankapi.bankapi.model.dormatsys.UserRole;

import java.util.List;

/**
 * @author Mr Fu
 * @version 1.0
 * @PackageName com.bankapi.bankapi.sevice
 * @ProjectName bankapi
 * @ClassName UserRoleService
 * @Email fudaopin@gamil.com
 * @date 2021/4/20 上午11:00
 * @Description UserRoleService interface
 */
public interface UserRoleService {

    public List<UserRole> getUserRoleList();
}
