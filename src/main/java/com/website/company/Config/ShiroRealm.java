package com.website.company.Config;

import com.website.company.entity.User;
import com.website.company.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


/**
 * 自定义实现 ShiroRealm，包含认证和授权两大模块
 *
 * @author MrBird
 */

public class ShiroRealm extends AuthorizingRealm {

    @Autowired
    private UserService userService;


    /**
     * 授权模块，获取用户角色和权限
     *
     * @param principal principal
     * @return AuthorizationInfo 权限信息
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principal) {

        SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();

        return simpleAuthorizationInfo;
    }

    /**
     * 用户认证
     *
     * @param token AuthenticationToken 身份认证 token
     * @return AuthenticationInfo 身份认证信息
     * @throws AuthenticationException 认证相关异常
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {

        // 获取用户输入的用户名和密码
        String loginAccount = (String) token.getPrincipal();
        String loginPassword = new String((char[]) token.getCredentials());

        // 通过用户名到数据库查询用户信息
        User user = this.userService.findUserByAccount(loginAccount);

        if (user == null)
            throw new UnknownAccountException("用户名或密码错误！");
        if (!loginPassword.equals(user.getLoginPassword()))
            throw new IncorrectCredentialsException("用户名或密码错误！");
        return new SimpleAuthenticationInfo(user, loginPassword, getName());
    }

    /**
     * 清除权限缓存
     * 使用方法：在需要清除用户权限的地方注入 ShiroRealm,
     * 然后调用其clearCache方法。
     */
    public void clearCache() {
        PrincipalCollection principals = SecurityUtils.getSubject().getPrincipals();
        super.clearCache(principals);
    }

}
