package com.cinema.service.impl;

import com.cinema.dao.UserDao;
import com.cinema.pojo.User;
import com.cinema.service.UserService;
import com.cinema.utils.Time;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public void addUser(User user) {
        user.setU_nickname("TY_"+((int) (Math.random()*900000)+100000));  //创建一个默认的名字，TY_123456
        user.setU_registertime(new Time().getCurrentTime());            //创建时间
        user.setU_role("普通用户");
        //注册加密（不加盐，加密2次）
        user.setU_password(new SimpleHash("MD5",user.getU_password(),null,2).toString());
        userDao.addUser(user);
    }

    @Override
    public void deleteUser() {
        User user = (User) SecurityUtils.getSubject().getSession().getAttribute("user");
        userDao.deleteUser(user.getU_id());
    }

    @Override
    public void modifyUser(User user) {
        User user_session = (User) SecurityUtils.getSubject().getSession().getAttribute("user");
        user.setU_id(user_session.getU_id());
        userDao.modifyUser(user);
    }

    @Override
    public User findUserByTel(String tel) {
        return userDao.getUserByTel(tel);
    }
}
