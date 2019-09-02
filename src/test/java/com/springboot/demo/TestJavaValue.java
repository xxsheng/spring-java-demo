package com.springboot.demo;

import org.junit.Test;

public class TestJavaValue {

//    public static void main(String[] args) {
//        User user = new User();
//        testValue(user);
//        
//        System.out.println(user);
//    }
    
    public static void main(String[] args) { 
        TestJavaValue t = new TestJavaValue(); 
        int a=99; 
        t.test1(a);//这里传递的参数a就是按值传递 
        System.out.println(a);
         
        MyObj obj=new MyObj(); 
        t.test2(obj);//这里传递的参数obj就是引用传递
        System.out.println(obj.b);
        
        System.out.println(5<<1);
    } 
     
    public void test1(int a){ 
        a=a++;
        System.out.println(a);
        } 
     
    public void test2(MyObj obj){ 
        obj.b=100;
        System.out.println(obj.b);
        }
    
    public static User testValue(User user) {
        user.setId("1");
        user.setName("2");
        
        return user;
    }
    
    @Test
    public void testLong() {
        Long a = 3L;
        System.out.println(a>0);
    }
}

class User{
    
    private String id;
    private String name;
    public User(String id, String name) {
        super();
        this.id = id;
        this.name = name;
    }
    public User() {
        super();
    }
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    @Override
    public String toString() {
        return "User [id=" + id + ", name=" + name + "]";
    }
    
}

class MyObj{
    public int b=99;
}