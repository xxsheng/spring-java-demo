package com.springboot.demo.api.interf;


import org.springframework.aop.framework.AopContext;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class InterfaceImp2 implements Interface2 {


    @Override
//    @Transactional
    public void sayHello() throws Exception {
        // TODO Auto-generated method stub

        System.out.println("---------");
        System.out.println(AopContext.currentProxy());
//        throw new Exception("22");
    }

    @Override
    public void sayHello1() {

    }

}
