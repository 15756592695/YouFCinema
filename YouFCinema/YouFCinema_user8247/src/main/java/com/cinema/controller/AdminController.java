package com.cinema.controller;

import com.cinema.pojo.User;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("/admin")
public class AdminController {

    @GetMapping("/login")
    public String login(@RequestBody User user,String code,HttpSession session){
        Object code_session = session.getAttribute("loginCode");
        session.removeAttribute("loginCode");
        if(code_session == null) return "登陆失败";
        String realCode = (String)code_session;
        if(!code.equalsIgnoreCase(realCode)) return "验证码有误";

        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(user.getU_tel(),user.getU_password());
        try{
            subject.login(token);
            return "登陆成功";
        }catch (Exception e){
            return "登录异常";
        }
    }

}
