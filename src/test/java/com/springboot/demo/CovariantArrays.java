package com.springboot.demo;


import java.util.ArrayList;
import java.util.List;

class Fruit {}
class Apple extends Fruit {}
class Jonathan extends Apple {}
class Orange extends Fruit {}

public class CovariantArrays {
    public static void main(String[] args) {
        //上界
        List<? extends Fruit> flistTop = new ArrayList<Apple>();
        flistTop.add(null);
        //add Fruit对象会报错
//        flistTop.add(new Apple());
        Fruit fruit1 = flistTop.get(0);

        //下界
        List<? super Apple> flistBottem = new ArrayList<Apple>();
        flistBottem.add(new Apple());
        flistBottem.add(new Jonathan());
//        flistBottem.add(new Fruit())
        //get Apple对象会报错
        //Apple apple = flistBottem.get(0);
    }
}