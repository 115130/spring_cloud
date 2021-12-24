package com.cache;

import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;
import com.netflix.hystrix.HystrixCommandKey;
import com.pojo.User;
import com.service.UserServiceFeign;

public class CacheCommand extends HystrixCommand<User> {

    private int id;
    private UserServiceFeign userServiceFeign;

    public void setId(int id)
    {
        this.id = id;
    }

    public void setUserServiceFeign(UserServiceFeign userServiceFeign)
    {
        this.userServiceFeign = userServiceFeign;
    }

    public CacheCommand()
    {
        super(Setter.withGroupKey(HystrixCommandGroupKey.Factory.asKey("cache-group")).andCommandKey(HystrixCommandKey.Factory.asKey("cache-test")));
    }

    protected String getCacheKey()
    {
        return String.valueOf(id);
    }

    @Override
    protected User run() throws Exception {

        return userServiceFeign.getUserById(id);
    }
}
