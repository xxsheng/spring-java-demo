package com.springboot.demo.api.interf;

import org.springframework.aop.framework.AopContext;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class InterfaceImpl3 implements Interface3 {
    @Override
    public void sayHello() {
        //
        ((InterfaceImpl3)AopContext.currentProxy()).test1();
    }

    @Transactional
    public void test1() {
        System.out.println("-------");
    }
}
