package com.service;

import com.pojo.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Service
@FeignClient(value="user-service")
public interface UserServiceFeign {
    @PostMapping("updateUser")
    public Integer updateUser(@RequestBody User user);

    @RequestMapping("getAllUser")
    public List<User> getAllUser();

    @RequestMapping("getUserById/{id}")
    public User getUserById(@PathVariable Long id);
}
