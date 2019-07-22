package com.cinema.provider;

import com.cinema.pojo.User;
import org.apache.ibatis.jdbc.SQL;
import org.apache.shiro.SecurityUtils;

public class UserProvider {

    public String mdifyUser(User user){
        User user_session = (User)SecurityUtils.getSubject().getSession().getAttribute("user");

        SQL sql=new SQL().UPDATE("user").SET("u_id="+user_session.getU_id());
        if(user.getU_tel()!=null && user.getU_tel().length()!=0){
            sql.SET("u_tel= '"+user.getU_tel()+"'");
        }
        if(user.getU_password()!=null && user.getU_password().length()!=0){
            sql.SET("u_password= '"+user.getU_password()+"'");
        }
        if(user.getU_role()!=null && user.getU_role().length()!=0){
            sql.SET("u_role= '"+user.getU_role()+"'");
        }
        if(user.getU_headimg()!=null && user.getU_headimg().length()!=0){
            sql.SET("u_headimg= '"+user.getU_headimg()+"'");
        }
        if(user.getU_nickname()!=null && user.getU_nickname().length()!=0){
            sql.SET("u_nickname= '"+user.getU_nickname()+"'");
        }
        sql.WHERE("u_id="+user.getU_id());
        return sql.toString();
    }

}
