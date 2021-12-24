package com.service;

import com.pojo.User;

import java.util.List;

public interface PoolUserService {
    public User getUserById(Long id);
    public List<User> getAll();
}
