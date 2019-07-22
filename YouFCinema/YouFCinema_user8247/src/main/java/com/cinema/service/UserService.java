package com.cinema.service;

import com.cinema.pojo.User;

public interface UserService {
    public void addUser(User user);

    public void deleteUser();

    public void modifyUser(User user);

    public User findUserByTel(String tel_client);
}
