package com.service;

import com.CacheCommand;
import com.netflix.hystrix.strategy.concurrency.HystrixRequestContext;
import com.pojo.User;

import javax.annotation.Resource;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

public class CacheUserServiceImpl implements CacheUserService{
    @Resource
    UserServiceFeign userServiceFeign;
    @Override
    public User getCacheUserById(Long id) {
        HystrixRequestContext hystrixRequestContext = HystrixRequestContext.initializeContext();

        CacheCommand cacheCommand = new CacheCommand(userServiceFeign,id);
        Future<User> queue = cacheCommand.queue();
        User user=null;
        try {
            user=queue.get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        hystrixRequestContext.close();
        return user;
    }
}
