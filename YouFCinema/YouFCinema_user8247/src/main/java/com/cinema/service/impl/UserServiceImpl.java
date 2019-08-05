package com.cinema.service.impl;

import com.cinema.dao.UserDao;
import com.cinema.pojo.User;
import com.cinema.service.UserService;
import com.cinema.utils.Time;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;


@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserDao userDao;

    @Override
    public String addUser(User user) {
        //账户已经存在，则不能再注册
        User user1=findUserByTel(user.getU_tel());
        if(user1!=null){
            return "账号已存在";
        }
        //给一个默认的头像，未完待加
        user.setU_nickname("TY_" + ((int) (Math.random() * 900000) + 100000));  //创建一个默认的名字，TY_123456
        user.setU_registertime(new Time().getCurrentTime());            //创建时间
        user.setU_role("普通用户");
        //注册加密（不加盐，加密2次）
        user.setU_password(new SimpleHash("MD5", user.getU_password(), null, 2).toString());
        userDao.addUser(user);
        return "注册成功";
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
        if(user.getU_password()!=null && user.getU_password().length()!=0){
            user.setU_password(new SimpleHash("MD5", user.getU_password(), null, 2).toString());
        }
        userDao.modifyUser(user);
    }

    @Override
    public User findUserByTel(String tel) {
        return userDao.getUserByTel(tel);
    }

    @Override
    public void addHeadImg(String img) {
        User user_session = (User) SecurityUtils.getSubject().getSession().getAttribute("user");
        Integer u_id = user_session.getU_id();
        userDao.addHeadImg(img, u_id);
    }

    @Override
    public void deleteMore(List<Integer> u_ids) {
        for (int i = 0; i < u_ids.size(); i++) {
            userDao.deleteUser(u_ids.get(i));
        }
    }

    @Override
    public void getBlacks(List<Integer> u_ids) {
        for (int i = 0; i < u_ids.size(); i++) {
            Integer flag = userDao.findFlagById(u_ids.get(i));
            if(flag==0){
                userDao.makeBlack(u_ids.get(i));
            }else
            userDao.makeWhite(u_ids.get(i));
        }
    }

    @Override
    public List<User> findAllUser() {
        return userDao.findAllUser();
    }

    @Override
    public List<User> findUsersByTel(String likeTel) {
        //做一个模糊查询的字符串
        String tel = likeTel+"%";
        return userDao.findUsersByTel(tel);
    }

    @Override
    public void modifyNickname(String nickname) {
        User user_session = (User) SecurityUtils.getSubject().getSession().getAttribute("user");
        userDao.modifyNickname(nickname,user_session.getU_id());
    }

    @Override
    public User myInfo() {
        User user_session = (User) SecurityUtils.getSubject().getSession().getAttribute("user");
        return userDao.myInfo(91);
    }

    @Override
    public Integer findIdByTel(String u_tel) {
        return userDao.findIdByTel(u_tel);
    }
}
