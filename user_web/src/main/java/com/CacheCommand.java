package com;

import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;
import com.netflix.hystrix.HystrixCommandKey;
import com.pojo.User;
import com.service.UserServiceFeign;

public class CacheCommand extends HystrixCommand<User> {

    private UserServiceFeign userServiceFeign;

    private Long id;

    public CacheCommand(UserServiceFeign userServiceFeign,
                        long id) {
        super(Setter.withGroupKey(
                HystrixCommandGroupKey.Factory.asKey("cache-group")
        ).andCommandKey(HystrixCommandKey.Factory.asKey("cache-test")));
        this.userServiceFeign = userServiceFeign;
        this.id = id;
    }

    @Override
    protected String getCacheKey() {
        return id.toString();
    }

    @Override
    protected User run() throws Exception {
        return userServiceFeign.getUserById(id);
    }
}
