package com.zxy.model.user.form;

import lombok.Data;

@Data
public class UserRegisterForm {
    private String userName;
    private String userPwd;
    private String mobile;
}
