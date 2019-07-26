package com.cinema.dao;

import com.cinema.pojo.User;
import com.cinema.provider.UserProvider;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.UpdateProvider;

public interface UserDao {

    @Insert("insert into user(u_tel,u_password,u_role,u_registertime,u_nickname) values" +
            "(#{u_tel},#{u_password},#{u_role},#{u_registertime},#{u_nickname})")
    public void addUser(User user);

    @Delete("delete from user where u_id=#{u_id}")
    public void deleteUser(Integer u_id);

    //@Update("update user set u_tel=#{u_tel},u_password=#{u_password} where u_id=#{u_id}")
    @UpdateProvider(type= UserProvider.class,method="mdifyUser")
    public void modifyUser(User user);

    @Select("select * from user where u_tel=#{u_tel}")
    public User getUserByTel(String tel);
}
