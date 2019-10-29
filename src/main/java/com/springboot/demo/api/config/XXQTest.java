package com.springboot.demo.api.config;

public class XXQTest {

    private static String abcde = "123";

    public static void main(String[] args) {
        TestLambda abcd = new TestLambda(abcde) {
            @Override
            void say() {
                System.out.println(abcde);
            }

            @Override
            void buy() {
                System.out.println(abcde);
            }
        };
        abcd.say();
    }

    class ABC {

    }
}

abstract class TestLambda {

    private String abc;

    public String getAbc() {
        return abc;
    }

    public void setAbc(String abc) {
        this.abc = abc;
    }

    public TestLambda(String test) {
        this.abc = test;
        System.out.println(abc);
        this.abc = "234";
        System.out.println(abc);
    }

    void say(){
        System.out.println("1111");
    }

    void buy() {
        System.out.println("222");
    }
}
