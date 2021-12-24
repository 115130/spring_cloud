package com.service.impl;

import com.mapper.UserMapper;
import com.pojo.User;
import com.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class UserServiceIMPL implements UserService {

    @Resource
    private UserMapper userMapper;
    @Override
    public User getUser() {
        User user = userMapper.getOneUser("张三");
        return user;
    }

    @Override
    public List<User> getAllUser() {
        return userMapper.getAllUser();
    }

    @Override
    public User getOneUser(Long id) {
        return userMapper.getOneUser(id);
    }

    @Override
    public User getOneUser(String name) {
        return userMapper.getOneUser(name);
    }

    @Override
    public Integer deleteUserById(Long id) {
        return userMapper.deleteUserById(id);
    }

    @Override
    public Integer updateUserById(User user) {
        return userMapper.updateUserById(user);
    }
}
