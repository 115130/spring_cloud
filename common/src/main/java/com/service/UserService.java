package com.service;

import com.pojo.User;

import java.util.List;


public interface UserService {

    public User getUser();
    public List<User> getAllUser();

    public User getOneUser(Long id);
    public User getOneUser(String name);

    public Integer deleteUserById(Long id);

    public Integer updateUserById(User user);
}
