package com.yy.main;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan({"com.yy.controller","com.yy.service"})
@MapperScan("com.yy.dao")
@SpringBootApplication
public class ApplicationStart_8888 {
    public static void main(String[] args) {
        SpringApplication.run(ApplicationStart_8888.class, args);
    }
}
