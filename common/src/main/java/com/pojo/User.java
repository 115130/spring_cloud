package com.pojo;

import lombok.Data;

import java.io.Serializable;

@Data
public class User implements Serializable {
    private  Long id;
    private String username;
    private Integer age;
    private Integer port;
}
