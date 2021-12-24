package com.controller;

import com.pojo.User;
import com.service.UserService;
import com.service.UserServiceFeign;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@Slf4j
@RestController
public class UserController {
    private @Resource
    UserService userService;

    @Autowired(required = false)
    private UserServiceFeign userServiceFeign;

    @GetMapping("getWebUser")
    public User getWebUser(){
        return userService.getUser();
    }

    @GetMapping("getUserById/{id}")
    public User getUserById(@PathVariable Long id){
        return userService.getOneUser(id);
    }

    @GetMapping("getUserByUsername/{name}")
    public User getUserByUsername(@PathVariable String name){
        return userService.getOneUser(name);
    }

    @GetMapping("getAllUser")
    public List<User> getAllUser(){
        return userService.getAllUser();
    }

    @GetMapping("deleteById/{id}")
    public boolean deleteById(@PathVariable Long id){
        return userService.deleteUserById(id)>0;
    }

    @GetMapping("updateById")
    public boolean deleteById(User user){
        return userService.updateUserById(user)>0;
    }

    @GetMapping("getall")
    public List<User> getall(){
        return userServiceFeign.getAllUser();
    }
}
