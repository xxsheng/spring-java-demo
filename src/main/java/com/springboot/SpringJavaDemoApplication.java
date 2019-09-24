package com.springboot;

import com.springboot.demo.api.config.XxqProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication
@ComponentScan(basePackages="com.springboot.demo")
//@EnableAspectJAutoProxy
public class SpringJavaDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringJavaDemoApplication.class, args);
	}

}
