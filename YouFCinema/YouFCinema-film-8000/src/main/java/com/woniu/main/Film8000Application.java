package com.woniu.main;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan({"com.woniu.controller",
	"com.woniu.service",
	"com.cinema.util",
	"com.woniu.rabbit",
	"com.woniu.config"})
@MapperScan("com.woniu.dao")
@EnableEurekaClient
@EnableFeignClients("com.cinema.interfaces")
public class Film8000Application {
	public static void main(String[] args) {
		SpringApplication.run(Film8000Application.class, args);
	}
}
