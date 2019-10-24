package com.springboot.demo.myabtis;

import java.lang.annotation.Annotation;

public class Test {
    public static void main(String[] args) {
        UserMapper userMapper = ProxyClass.getProxy(UserMapper.class);
        userMapper.selectByAll();

//        for (Annotation annotation : UserMapper.class.getAnnotations()) {
//            System.out.println(annotation);
//        }
    }
}
