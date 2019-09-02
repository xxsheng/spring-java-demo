package com.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication
@ComponentScan(basePackages="com.springboot.demo")
@EnableAspectJAutoProxy(exposeProxy = true)
public class SpringJavaDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringJavaDemoApplication.class, args);
	}

}
