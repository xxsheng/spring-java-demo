package com.springboot.demo.api.interf;


public class InterfaceImpl implements Interface1 {

    protected int a = 1;
    
    @Override
    public void sayHello() {
        // TODO Auto-generated method stub

        System.out.println("---------");
    }

}

class A extends InterfaceImpl{
//    @Test
//    public void test2() {
//        System.out.println(this.a);
//    }
}