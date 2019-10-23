package com.springboot;

import com.springboot.demo.api.config.XxqProperties;
import com.fasterxml.jackson.databind.util.JSONPObject;
import com.google.gson.Gson;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@ServletComponentScan("com.springboot.demo.api.config.filter")
@SpringBootApplication
@ComponentScan(basePackages="com.springboot.demo")
//@EnableAspectJAutoProxy(exposeProxy = true)
public class SpringJavaDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringJavaDemoApplication.class, args);
	}

    public static void main1(String[] args) {
        String json = "[{\"businesstype\":\"DSC90\",\"cmTime\":\"2019-09-10 11:09:51\",\"cmUser\":\"000017\",\"companyCode\":\"KH03\",\"data\":\"{\\\"args\\\":{\\\"dimension1\\\":\\\"KH03\\\"}}\",\"opUser\":\"\",\"orderNo\":\"26KH031909100094\",\"orderNodeNext\":\"1\",\"orderNodeNow\":\"0\",\"orderType\":\"dsczichanform\",\"sysCode\":\"FsopForm\"}]";
        Gson gson = new Gson();
//        gson.to
    }
}
