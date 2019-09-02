package com.springboot.demo;

import java.time.LocalDate;

public class TestFor {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
//        int a=0;
//        for(int i=0;i<100;i++) 
//            //a=a++;
//        System.out.println(a);
        LocalDate now = LocalDate.now();
        System.out.println(now.getDayOfMonth());
        System.out.println(now.getDayOfYear());
        System.out.println(now.getDayOfWeek());
        System.out.println(now.getMonthValue());
        System.out.println(now.getYear());
    }

}
