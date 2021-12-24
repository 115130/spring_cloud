package com.coll;

import com.pojo.User;

import java.util.concurrent.Future;

public interface CollUserService {

    public Future<User> collGetUserById(Integer id);
}
