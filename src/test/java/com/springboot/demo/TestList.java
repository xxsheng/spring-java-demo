/**
 * 
 */
package com.springboot.demo;

import java.util.Arrays;

/**
 * @author IGEN
 *为什么继承了absList还需要实现List接口
 */
public class TestList {

    public static void main(String[] args) {
        System.out.println("class Base   " + Arrays.toString(Base.class.getInterfaces()));
        System.out.println("class TestA  " + Arrays.toString(TestA.class.getSuperclass().getInterfaces()));
        System.out.println("class TestB  " + Arrays.toString(TestB.class.getInterfaces()));
    }
}

interface Test1 {
    void foo();
}

class Base implements Test1 {

    @Override
    public void foo() {
        // TODO Auto-generated method stub
        System.out.println("base class");
    }
    
}

class TestB extends Base {
    @Override
    public void foo() {
        // TODO Auto-generated method stub
        System.out.println("TestA");
    }
}

class TestC extends Base implements Test1 {
    
    public void foo() {
        // TODO Auto-generated method stub
        System.out.println("TestB");
    }
}