package com.zxy.controller.user;

import com.zxy.model.user.form.UserRegisterForm;
import com.zxy.service.user.UserService;
import com.zxy.utils.ResultData;
import org.apache.shiro.authz.annotation.RequiresGuest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/api/user")
@RequiresGuest
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/register")
    public String turnRegister(){
        return "RegisterPage";
    }

    @PostMapping("/user")
    public String register(@RequestBody UserRegisterForm form, Model model){
        ResultData rd = userService.userRegister(form);
        model.addAttribute("resultData",rd);
        return "RegisterResultPage";
    }
}
