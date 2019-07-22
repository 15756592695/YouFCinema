package com.woniu.main;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan({"com.woniu.controller",
	"com.woniu.service"})
@MapperScan("com.woniu.dao")
@EnableEurekaClient
public class Film8000Application {
	public static void main(String[] args) {
		SpringApplication.run(Film8000Application.class, args);
	}
}
