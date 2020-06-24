package com.springboot.demo.api.interf;


import org.springframework.aop.framework.AopContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class InterfaceImpl implements Interface1 {

    protected int a = 1;

    @Autowired
    Interface2 interface2;

    @Override
    @Transactional
    public void sayHello() {
        // TODO Auto-generated method stub

        System.out.println("---------");

//        System.out.println(AopContext.currentProxy());
//        try {
//
//            interface2.sayHello();
//        } catch (Exception e) {
//            System.out.println(AopContext.currentProxy());
//        }
    }

}

class A extends InterfaceImpl{
//    @Test
//    public void test2() {
//        System.out.println(this.a);
//    }
}