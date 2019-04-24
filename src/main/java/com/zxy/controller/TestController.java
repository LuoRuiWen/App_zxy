package com.zxy.controller;

import org.apache.shiro.authz.annotation.RequiresGuest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiresGuest
@RestController
public class TestController {
    @GetMapping("/hello")
    public String hello(){
        return "hello world";
    }
}
