package com.zxy.entity.user;


import lombok.Data;

@Data
public class User {
    private String id;

    private String userName;

    private String userPwd;

    private Integer flag;
}