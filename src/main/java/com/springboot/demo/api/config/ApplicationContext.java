package com.springboot.demo.api.config;

import com.springboot.demo.api.abstractClass.AbstractTest2;
import com.springboot.demo.api.interf.Interface1;
import com.springboot.demo.api.interf.Interface2;
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
//        AbstractTest2 abstractTest2 = (AbstractTest2) applicationContext.getBean("abstractTest2");
//        AbstractTest2 abstractTest3 = (AbstractTest2) applicationContext.getBean("abstractTest2");
        XXQTest bean = applicationContext.getBean(XXQTest.class);
        XxqProperties xxqProperties = applicationContext.getBean(XxqProperties.class);
        System.out.println(xxqProperties.getLastName());
        System.out.println(applicationContext.getBean(Interface1.class).getClass().getTypeName());
    }
}
