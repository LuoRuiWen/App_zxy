package com.zxy.controller;

import org.apache.shiro.authz.annotation.RequiresGuest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiresGuest
@Controller
public class TestController {
    @GetMapping("/hello")
    public String hello(){
        return "hello world";
    }

    @GetMapping("/")
    public String loginPage(){
        return "login";
    }

}
