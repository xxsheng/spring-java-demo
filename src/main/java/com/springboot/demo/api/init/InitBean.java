package com.springboot.demo.api.init;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

public class InitBean implements InitializingBean{

    @Override
    public void afterPropertiesSet() throws Exception {
        // TODO Auto-generated method stub
        System.out.println("---------InitBean---------------------");
    }

    
}
