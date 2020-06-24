package com.springboot.demo.api.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@ConfigurationProperties(prefix = "xxq")
@Setter
@Getter
public class XxqProperties {

    private String lastName;

    private Integer age;

    private Boolean sex;


    // ... getter and setters


}
