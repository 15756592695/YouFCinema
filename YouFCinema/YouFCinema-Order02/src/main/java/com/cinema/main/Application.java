package com.cinema.main;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@MapperScan("com.cinema.dao")
@EnableSwagger2
@ComponentScan({"com.cinema.controller","com.cinema.service","com.cinema.config"})
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);

	}

}
