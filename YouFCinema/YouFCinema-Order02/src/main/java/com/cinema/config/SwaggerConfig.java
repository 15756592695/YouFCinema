package com.cinema.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@ComponentScan(basePackages = "com.cinema.controller")       //扫描要编写的接口
@EnableSwagger2
@Configuration
public class SwaggerConfig {
 	 @Bean
	 public Docket customDocket(){
    	return new Docket(DocumentationType.SWAGGER_2).apiInfo(apiInfo());
	 }

	  private ApiInfo apiInfo(){
   		 return new ApiInfoBuilder()
            .title("标题")
            .description("关于这个接口文档的描述")
            .contact(new Contact("编写人","网址","邮箱"))
            .version("1.0.0（版本）")
            .build();
	 }
}