package com.zxy;

import org.apache.ibatis.annotations.Mapper;
import org.mybatis.spring.annotation.MapperScan;
import org.mybatis.spring.annotation.MapperScans;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@SpringBootApplication
@MapperScan("com.zxy.dao.*")
@ServletComponentScan(basePackages = {"com.zxy.filter","com.zxy.interceptor"})
public class MyApplication {
    public static void main(String[] args){
        SpringApplication.run(MyApplication.class);
    }
}
