package com.bankapi.bankapi.config;

import com.bankapi.bankapi.model.dormatsys.User;
import com.bankapi.bankapi.sevice.iml.UserServiceIml;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashSet;
import java.util.Set;

/**
 * @packageName: com.bankapi.bankapi.config
 * @program: bankapi
 * @className: RealmConfig
 * @author: Mr.FU
 * @Email: fudaopin@gmail.com
 * @createDate: 2021-04-17  20:49
 * @description: 用户登录的验证与授权
 **/
public class RealmConfig extends AuthorizingRealm {

    @Autowired
    UserServiceIml userServiceIml;

    /**
     * 用户授权
     * @param principalCollection
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {

        Subject subject = SecurityUtils.getSubject();
        User user = (User) subject.getPrincipal();

        Set<String> roles = new HashSet<>();

        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo(roles);

//        info.addStringPermission(user.ge);
        return info;
    }

    /**
     * 用户登录验证
     * @param authenticationToken  验证所需的 token
     * @return  返回一个验证结果
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;
        User user = userServiceIml.findUserByUsername(token.getUsername());
        if (user != null) {
            return new SimpleAuthenticationInfo(user, user.getPassword(),this.getName());
        }else {
            throw new UnknownAccountException("未查询到该用户");
        }
    }
}
