package com.service.impl;

import com.pojo.User;
import com.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.util.List;

@Service
public class UserServiceIMPL implements UserService {
    @Resource
    private RestTemplate restTemplate;

    @Override
    public User getUser() {
        String url = "http://user-service/getUser";
        User user = restTemplate.getForObject(url, User.class);
        return user;
    }

    @Override
    public List<User> getAllUser() {
        String url = "http://user-service/getAllUser";
        ResponseEntity<List> forEntity = restTemplate.getForEntity(url, List.class);
        return forEntity.getBody();
    }

    @Override
    public User getOneUser(Long id) {
        String url = "http://user-service/getUserById/{id}";
        ResponseEntity<User> response = restTemplate.getForEntity(url, User.class,id);
        return response.getBody();
    }

    @Override
    public User getOneUser(String name) {
        String url = "http://user-service/getUserByUsername/{name}";
        ResponseEntity<User> response = restTemplate.getForEntity(url, User.class,name);
        return response.getBody();
    }

    @Override
    public Integer deleteUserById(Long id) {
        String url = "http://user-service/deleteUserById/{id}";
        ResponseEntity<Integer> response = restTemplate.getForEntity(url, Integer.class, id);
        return response.getBody();
    }

    @Override
    public Integer updateUserById(User user) {
        String url = "http://user-service/updateUser";
        ResponseEntity<Integer> response = restTemplate.postForEntity(url,user,Integer.class);
        return response.getBody();
    }


}
