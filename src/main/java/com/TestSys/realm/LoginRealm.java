package com.TestSys.realm;


import com.TestSys.Service.RoleService;
import com.TestSys.entity.Role;
import com.TestSys.entity.User;

import com.TestSys.Service.UserService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.test.context.ContextConfiguration;

import javax.annotation.Resource;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Jacey on 2017/6/30.
 */

@Repository
public class LoginRealm extends AuthorizingRealm{

    @Autowired
    UserService userService;

    @Autowired
    RoleService roleService;

    /**
     * 获取身份信息，我们可以在这个方法中，从数据库获取该用户的权限和角色信息
     *     当调用权限验证时，就会调用此方法
     */

    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {

        String username = (String) getAvailablePrincipal(principalCollection);

        Role role = null;

        try {
            User userlogin = userService.SelectUser(Integer.parseInt(username));
            //获取角色对象
            role = roleService.findByid(userlogin.getRole());
        } catch (Exception e) {
            e.printStackTrace();
        }
        //通过用户名从数据库获取权限/角色信息
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        Set<String> r = new HashSet<String>();
        if (role != null) {
            r.add(role.getRolename());
            info.setRoles(r);
        }

        return info;
    }

    /**
     * 在这个方法中，进行身份验证
     *         login时调用
     */

    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        //用户名
        String username = (String) token.getPrincipal();
        //密码
        String password = new String((char[])token.getCredentials());

        User userlogin = null;

        try {
            int UserID = Integer.parseInt(username);
            userlogin = userService.Login(UserID,password);
        } catch (Exception e) {
            e.printStackTrace();
            throw new UnknownAccountException();
        }

        if (userlogin == null) {
            //没有该用户名或密码错误
            throw new UnknownAccountException();
        }

        //身份验证通过,返回一个身份信息
        AuthenticationInfo aInfo = new SimpleAuthenticationInfo(username,password,getName());

        return aInfo;
    }
}
