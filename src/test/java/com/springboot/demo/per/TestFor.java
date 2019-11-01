package com.springboot.demo.per;

import java.util.ArrayList;

public class TestFor {

    public static void main(String[] args) {

//        ArrayList<Integer> list = new ArrayList<>(20000000);
        ArrayList<Integer> list1 = new ArrayList<>();

        long start = System.currentTimeMillis();
        for(int i = 0; i< 10000000;i++){
            list1.add(i);
        }
        long end = System.currentTimeMillis();
        System.out.println("------------1");
        System.out.println("------------2");
        System.out.println("------------3");
        System.out.println("------------4");
        System.out.println("第一次耗时："+(end - start));

        long start1 = System.currentTimeMillis();
        for(int i = 10000000; i< 20000000;i++){
            list1.add(i);
        }
        long end1 = System.currentTimeMillis();
        System.err.println("第一次耗时："+(end1 - start1));
//
//        ArrayList<Integer> list2 = new ArrayList<>();
//
//        long start2 = System.currentTimeMillis();
//        for(int i = 0; i< 10000000;i++){
//            list2.add(i);
//        }
//        long end2 = System.currentTimeMillis();
//        System.out.println("第二次耗时："+(end2 - start2));
//
//        ArrayList<Integer> list3 = new ArrayList<>();
//
//        long start3 = System.currentTimeMillis();
//        for(int i = 0; i< 10000000;i++){
//            list3.add(i);
//        }
//        long end3 = System.currentTimeMillis();
//        System.out.println("第三次耗时："+(end3 - start3));
//
//        ArrayList<Integer> list4 = new ArrayList<>();
//
//        long start4 = System.currentTimeMillis();
//        for(int i = 0; i< 10000000;i++){
//            list4.add(i);
//        }
//        long end4 = System.currentTimeMillis();
//        System.out.println("第四次耗时："+(end4 - start4));
//
//        ArrayList<Integer> list5 = new ArrayList<>();
//        long start5 = System.currentTimeMillis();
//        for(int i = 0; i< 10000000;i++){
//            list5.add(i);
//        }
//        long end5 = System.currentTimeMillis();
//        System.out.println("第二次耗时："+(end5 - start5));

    }
}
