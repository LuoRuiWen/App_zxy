package com.zxy.service.user;

import lombok.Data;

@Data
public class UserInfo {
    private String id;
    private String userpwd;
    private String username;
    private Integer flag;
}
