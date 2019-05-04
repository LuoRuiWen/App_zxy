package com.zxy.entity.user;

import lombok.Data;

import java.util.Date;

@Data
public class User {
    private String id;

    private String userName;

    private String userPwd;

    private Integer flag;

    private String mobile;

    private Boolean isDeleted;

    private Date createTime;
}