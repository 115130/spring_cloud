package com.contorller;

import com.pojo.User;
import com.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@Slf4j
@RestController
public class UserController {
    @Resource
    private UserService userService;

    @RequestMapping("getUser")
    public User getUser() {
        return userService.getUser();
    }

    @RequestMapping("getUserById/{id}")
    public User getUserById(@PathVariable Long id) {
        return userService.getOneUser(id);
    }

    @RequestMapping("getUserByUsername/{name}")
    public User getUserById(@PathVariable String name) {
        return userService.getOneUser(name);
    }

    @RequestMapping("getAllUser")
    public List<User> getAllUser() {
        return userService.getAllUser();
    }

    @RequestMapping("deleteUserById/{id}")
    public Integer deleteUserById(@PathVariable Long id) {
        return userService.deleteUserById(id);
    }

    @PostMapping("updateUser")
    public Integer updateUser(@RequestBody User user) {
        log.error(user.toString());
        return userService.updateUserById(user);
    }
}
