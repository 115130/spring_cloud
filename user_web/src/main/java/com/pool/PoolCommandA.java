package com.pool;

import com.netflix.hystrix.*;
import com.pojo.User;
import com.service.UserServiceFeign;

import java.util.List;

public class PoolCommandA extends HystrixCommand<List<User>> {
    private UserServiceFeign userServiceFeign;
    private Long id;
    public PoolCommandA(UserServiceFeign userServiceFeign) {
        super(Setter.withGroupKey(
                HystrixCommandGroupKey.Factory.asKey("PoolCommandAGroup"))
                .andThreadPoolKey(HystrixThreadPoolKey.Factory.asKey("PoolCommandAPool"))
                .andThreadPoolPropertiesDefaults(HystrixThreadPoolProperties.Setter()
                        .withCoreSize(10)
                        .withKeepAliveTimeMinutes(10)
                        .withQueueSizeRejectionThreshold(10000))
                .andCommandPropertiesDefaults(HystrixCommandProperties.Setter()
                        .withExecutionIsolationStrategy(HystrixCommandProperties.ExecutionIsolationStrategy.THREAD)));
        this.userServiceFeign=userServiceFeign;
    }

    public void setId(Long id){
        this.id=id;
    }

    @Override
    protected List<User> run() throws Exception {
       return userServiceFeign.getAllUser();
    }
}
