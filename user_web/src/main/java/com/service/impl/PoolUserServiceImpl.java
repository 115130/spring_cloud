package com.service.impl;

import com.pojo.User;
import com.pool.PoolCommandA;
import com.pool.PoolCommandB;
import com.service.PoolUserService;
import com.service.UserServiceFeign;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

@Service
public class PoolUserServiceImpl implements PoolUserService {

    @Resource
    private UserServiceFeign userServiceFeign;

    @Override
    public User getUserById(Long id) {
        PoolCommandB poolCommandB  = new PoolCommandB(userServiceFeign);
        poolCommandB.setId(id);
        Future<User> queue = poolCommandB.queue();
        User user=null;
        try {
            user=queue.get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        return user;
    }

    @Override
    public List<User> getAll() {
        PoolCommandA poolCommandA  = new PoolCommandA(userServiceFeign);

        Future<List<User>> queue = poolCommandA.queue();

        List<User> list = null;

        try {
            list=queue.get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        return list;

    }
}
