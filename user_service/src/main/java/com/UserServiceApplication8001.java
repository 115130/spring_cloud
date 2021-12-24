package com;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
@MapperScan("com.mapper")
public class UserServiceApplication8001 {
    public static void main(String[] args) {
        SpringApplication.run(UserServiceApplication8001.class);
    }
}
