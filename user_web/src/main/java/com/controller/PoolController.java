package com.controller;

import com.pojo.User;
import com.pool.PoolCommandA;
import com.pool.PoolCommandB;
import com.service.PoolUserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
public class PoolController {
    @Resource
    private PoolUserService userService ;

    @GetMapping("/pool/getAllUser")
    public List<User> getAll(){
        return userService.getAll();
    }

    @GetMapping("/pool/getUserById/{id}")
    public User getUserById(@PathVariable Long id){
        return userService.getUserById(id);
    }

}
