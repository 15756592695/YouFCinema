package com.cinema.shiro;

import com.cinema.pojo.User;
import com.cinema.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;

public class MyRealm extends AuthorizingRealm {

    @Autowired
    private UserService userService;

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        return null;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        String tel_client = token.getPrincipal().toString();
        User user = userService.findUserByTel(tel_client);
        AuthenticationInfo info =null;
        if(user != null){
            info = new SimpleAuthenticationInfo(user.getU_tel(),user.getU_password(),getName());
        }

        //将user存入session
        Subject subject = SecurityUtils.getSubject();
        subject.getSession().setAttribute("user",user);

        return info;
    }
}
