package com.baidu.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @Value("${name}")
    private String name;

    @Value("${age}")
    private Integer age;

    @Value("${email}")
    private String email;

    @RequestMapping("/getProperties")
    public String getProperties()
    {
        System.out.println("-------------getProperties-------------");
        System.out.println("name: " + name + " age: " + age + " email: " + email);
        return "name:" + name + "age:" + age + "email:" + email;
    }
}
