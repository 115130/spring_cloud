package com.cache.service.impl;

import com.cache.CacheCommand;
import com.cache.service.CacheUserService;
import com.netflix.hystrix.strategy.concurrency.HystrixRequestContext;
import com.pojo.User;
import com.service.UserServiceFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CacheUserServiceImpl implements CacheUserService {

    @Autowired
    private UserServiceFeign userServiceFeign;

    public User getUserById(int id)
    {
        HystrixRequestContext context = HystrixRequestContext.initializeContext();

        User user = null;

        CacheCommand cacheCommand = new CacheCommand();

        cacheCommand.setId(id);
        cacheCommand.setUserServiceFeign(userServiceFeign);

        System.out.println("------------第一次执行------------");
        user = cacheCommand.execute();

        System.out.println("------------第二次执行------------");
        user = cacheCommand.execute();

        System.out.println("------------第三次执行------------");
        user = cacheCommand.execute();

        context.close();

        return user;
    }
}
