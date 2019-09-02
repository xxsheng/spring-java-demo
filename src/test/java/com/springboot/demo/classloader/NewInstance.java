package com.springboot.demo.classloader;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class NewInstance {

    public static void main(String[] args) {
        try{
            Class aclass=ClassLoader.getSystemClassLoader().loadClass("com.springboot.demo.classloader.A");//只是加载类
            Constructor c=aclass.getConstructor(int.class);//此时完成验证、准备、解析工作
            A a=(A)c.newInstance(1);//完成初始化工作，接着调用构造函数，此时可能发生解析
            System.out.println(a.y);
        }
        catch(ClassNotFoundException x){
            System.out.println("无法加载对应类");
        }
        catch (NoSuchMethodException x)
        {
            System.out.println("类中没有对应方法");
        }
        catch(InstantiationException x)
        {
            System.out.println("为抽象类或接口");
        }
        catch(IllegalAccessException x)
        {
            System.out.println("构造方法非public修饰");
        }
        catch(InvocationTargetException x){
            System.out.println("方法抛出了异常");
        }
    }

}

class A {
    int y;

    public A(int x) {
        y = x;
    }

    static {
        System.out.println("加载类A");
    }
}