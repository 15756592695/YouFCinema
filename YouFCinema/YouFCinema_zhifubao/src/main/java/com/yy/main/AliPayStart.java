package com.yy.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

@EnableFeignClients("com.cinema.interfaces")
@ComponentScan({"com.yy.pay","com.yy.config","com.yy.util"})
@SpringBootApplication
public class AliPayStart {
    public static void main(String[] args) {
        SpringApplication.run(AliPayStart.class, args);
    }
}
