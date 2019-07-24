package com.yy.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan("com.yy.pay")
@SpringBootApplication
public class AliPayStart {
    public static void main(String[] args) {
        SpringApplication.run(AliPayStart.class, args);
    }
}
