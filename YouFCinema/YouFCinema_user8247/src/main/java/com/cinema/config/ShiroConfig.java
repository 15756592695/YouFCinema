package com.cinema.config;

import com.cinema.shiro.MyRealm;
import org.apache.shiro.authc.credential.CredentialsMatcher;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.LinkedHashMap;
import java.util.Map;

@Configuration
public class ShiroConfig {
    //配置加密
    @Bean
    public CredentialsMatcher matcher(){
        HashedCredentialsMatcher matcher = new HashedCredentialsMatcher();
        matcher.setHashAlgorithmName("MD5");
        matcher.setHashIterations(2);
        return matcher;
    }

    @Bean
    public MyRealm getMyRealm(){
        MyRealm myRealm = new MyRealm();
        myRealm.setCredentialsMatcher(matcher());
        return myRealm;
    }

    @Bean
    public DefaultWebSecurityManager getDefaultWebSecurityManager(MyRealm realm){
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        securityManager.setRealm(realm);
        return securityManager;
    }

    @Bean
    public ShiroFilterFactoryBean getShiroFilterFactoryBean(DefaultWebSecurityManager securityManager){
        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
        //注入安全管理器
        shiroFilterFactoryBean.setSecurityManager(securityManager);
        //认证失败需要跳转的地址，也是项目空url默认路径
//        shiroFilterFactoryBean.setLoginUrl("/html/login.html");
        //授权失败需要跳转的地址
        shiroFilterFactoryBean.setUnauthorizedUrl("/html/fail.html");
        //设置访问路径的权限,hashmap是无序的，不能在权限判断这儿用，只能LinkedHashMap
        Map<String,String> fmap = new LinkedHashMap<String,String>();
//        fmap.put("/html/login.html","anon");
//        fmap.put("/html/register.html","anon");
//        fmap.put("/register","anon");
//        fmap.put("/allUser","anon");
//        fmap.put("/login","anon");
//        fmap.put("html/main.html","authc");
//        fmap.put("/loginout","logout");
        fmap.put("/**","anon");
        shiroFilterFactoryBean.setFilterChainDefinitionMap(fmap);
        return shiroFilterFactoryBean;
    }
}