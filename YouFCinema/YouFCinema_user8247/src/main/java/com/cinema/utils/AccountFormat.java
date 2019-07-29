package com.cinema.utils;

import com.cinema.dao.UserDao;
import com.cinema.pojo.User;
import com.cinema.service.UserService;
import com.cinema.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.Resource;

//写一个账号密码的格式验证
public class AccountFormat {


    //验证手机号
    public String verifyPhone(String tel){

        if(tel.length()!=11){
            return "手机号码格式不正确";
        }
        return "账号合法";
    }

    //密码认证
    public String verifyPassword(String pwd){
        String nopwd = "密码必须由6-12位，必须含有数字、字母，且第一位必须是字母";
        if(pwd.length()<6 || pwd.length()>12){
            return nopwd;
        }
        if((int)pwd.charAt(0)<65 || (int)pwd.charAt(0)>122){
            return nopwd;
        }
        if((int)pwd.charAt(0)>90 && (int)pwd.charAt(0)<97){
            return nopwd;
        }

        int letter = 0;  //字母的个数（不能为0）
        int number = 0;  //数字的个数（不能为0）
        for (int i = 0; i < pwd.length(); i++) {
            if(pwd.charAt(i)>=48 || pwd.charAt(i)<=57){
                number++;
            }
            if(pwd.charAt(i)>=65 && pwd.charAt(i)<=90){
                letter++;
            }
            if(pwd.charAt(i)>=97 && pwd.charAt(i)<=122){
                letter++;
            }
        }
        if(letter==0 || number==0){
            return nopwd;
        }

        return "密码合法";
    }

    public String verify(String tel,String pwd){
        String s1 = verifyPhone(tel);
        if(!s1.equals("账号合法")){
            return s1;
        }
        String s2 = verifyPassword(pwd);
        if(!s2.equals("密码合法")){
            return s2;
        }
        return "账号密码合法";
    }
}
