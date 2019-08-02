package com.cinema.service;

import com.cinema.pojo.User;

import java.util.List;

public interface UserService {
    public String addUser(User user);

    public void deleteUser();

    public void modifyUser(User user);

    public User findUserByTel(String tel_client);

    public void addHeadImg(String img);

    public void deleteMore(List<Integer> u_ids);

    public void getBlacks(List<Integer> u_ids);

    public List<User> findAllUser();

    public List<User> findUsersByTel(String likeTel);

    public void modifyNickname(String nickname);

    public User myInfo();

    public Integer findIdByTel(String u_tel);
}
