package com.wnxy.main;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.wnxy.controller")
@ComponentScan("com.wnxy.service")
@MapperScan("com.wnxy.dao")
@EnableEurekaClient     //代表客户端
public class ApplicationDemo {
	public static void main(String[] args) {
		SpringApplication.run(ApplicationDemo.class, args);
	}
}
