package com.zxy.controller.user;

import com.zxy.model.user.form.UserLoginForm;
import com.zxy.model.user.form.UserRegisterForm;
import com.zxy.service.user.UserService;
import com.zxy.utils.ResultData;
import org.apache.shiro.authz.annotation.RequiresGuest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user")
@RequiresGuest
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/login")
    public ResultData login(@RequestBody UserLoginForm form){
        return userService.userLogin(form);
    }

    @PostMapping("/register")
    public ResultData register(@RequestBody UserRegisterForm form){
        return userService.userRegister(form);
    }
}
