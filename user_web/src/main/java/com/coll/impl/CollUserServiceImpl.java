package com.coll.impl;

import com.coll.CollUserService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCollapser;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.pojo.User;
import com.service.UserServiceFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.Future;

@Service
public class CollUserServiceImpl implements CollUserService {

    @Autowired
    private UserServiceFeign userServiceFeign;

    @HystrixCollapser(batchMethod = "getUserByIds", collapserProperties = {@HystrixProperty(name = "timerDelayInMilliseconds", value = "500")})
    public Future<User> collGetUserById(Integer id) {
        return null;
    }

    @HystrixCommand
    public List<User> getUserByIds(List<Integer> ids)
    {
        System.out.println("-----------getUserByIds-----------");

        Integer myIds[] = new Integer[ids.size()];
        ids.toArray(myIds);

        List<User> list = userServiceFeign.getUserByIds(myIds);

        return list;
    }
}
