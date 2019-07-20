package com.wnxy.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer    //当前注解表示这个微服务是一个注册中心
public class ApplicationEureka_9000 {
    public static void main(String[] args) {
        SpringApplication.run(ApplicationEureka_9000.class, args);
    }
}
