package com.cinema.dao;

import com.cinema.pojo.User;
import com.cinema.provider.UserProvider;
import org.apache.ibatis.annotations.*;

import java.util.List;

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

    @Update("update user set u_headimg=#{u_headimg} where u_id=#{u_id}")
    public void addHeadImg(@Param("u_headimg")String u_headimg,@Param("u_id") Integer u_id);

    @Update("update user set flag=1 where u_id=#{u_id} and flag<>1")
    public void makeBlack(Integer u_id);

    @Update("update user set flag=0 where u_id=#{u_id} and flag<>0")
    public void makeWhite(Integer u_id);

    @Select("select flag from user where u_id = #{u_id}")
    public Integer findFlagById(Integer u_id);

    @Select("select * from user")
    public List<User> findAllUser();

    @Select("select * from user where u_tel like #{tel} or u_role like #{tel}")
    public List<User> findUsersByTel(String tel);


    @Update("update user set u_nickname=#{u_nickname} where u_id=#{u_id}")
    public void modifyNickname(@Param("u_nickname") String nickname,@Param("u_id") Integer u_id);

    @Select("select * from user where u_id=#{u_id}")
    public User myInfo(@Param("u_id") Integer u_id);

    @Select("select u_id from user where u_tel=#{u_tel}")
    public Integer findIdByTel(String u_tel);
}
