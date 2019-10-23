package com.springboot.demo.api.config;

import com.springboot.demo.api.abstractClass.AbstractTest1;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

@Component
public class ApplicationContext implements ApplicationContextAware {
    private  org.springframework.context.ApplicationContext applicationContext;
    @Override
    public void setApplicationContext(org.springframework.context.ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
//        System.out.println(applicationContext.getBean("abstractTest1"));
//        System.out.println(applicationContext.getBean(AbstractTest1.class));
    }
}
