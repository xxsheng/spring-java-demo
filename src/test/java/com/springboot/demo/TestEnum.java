package com.springboot.demo;

import org.junit.Test;


public class TestEnum {

    @Test
    public void testEnum() {
        
//        System.out.println(com.springboot.demo.api.domain.TestEnum.values()[0]);
//        System.out.println(com.springboot.demo.api.domain.TestEnum.valueOf("TEST_ZERO2"));
//        System.out.println(com.springboot.demo.api.domain.TestEnum.valueOf(com.springboot.demo.api.domain.TestEnum.class, "TEST_ZERO"));
        System.out.println(com.springboot.demo.api.domain.TestEnum.getTestEnum((byte) 0));
    }
}
