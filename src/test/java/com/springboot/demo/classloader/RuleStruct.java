package com.springboot.demo.classloader;


import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 *
 * @create 2019-08-13 下午7:14
 **/
@Mapper
public interface RuleStruct {
    RuleStruct INSTANCE = Mappers.getMapper(RuleStruct.class);

    String toRuleDTO1(String alertRuleConfig);

    String toRuleDTO(String alertRuleConfig);
}
class Test{
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        
        Class cl = Class.forName("java.lang.ClassLoader", false, Thread.currentThread().getContextClassLoader());
        Method method = cl.getDeclaredMethod("findLoadedClass", new Class[] { String.class });
        method.setAccessible(true);
 
        if (method.invoke(Thread.currentThread().getContextClassLoader(), "java.lang.System") != null) {
            System.out.println("java.lang.System已经加载!");
        } else {
            System.out.println("java.lang.System尚未加载!");
        }
 
        if (method.invoke(Thread.currentThread().getContextClassLoader(), "java.sql.Date") != null) {
            System.out.println("java.lang.System已经加载!");
        } else {
            System.out.println("java.sql.Date尚未加载!");
        }
        if (method.invoke(Thread.currentThread().getContextClassLoader(), "com.igen.message.service.struct.RuleStructImpl") != null) {
            System.out.println("java.lang.RuleStructImpl已经加载!");
        } else {
            System.out.println("java.sql.RuleStructImpl尚未加载!");
        }
 
//        Class clazz = RuleStructImpl.class;
//        RuleStruct impl = new RuleStructImpl();
//        System.out.println(impl.getClass().getClassLoader());
        
//        RuleStruct instance = RuleStruct.INSTANCE;
//        System.out.println(instance.getClass().getClassLoader());
        
        if (method.invoke(Thread.currentThread().getContextClassLoader(), "java.lang.System") != null) {
            System.out.println("java.lang.System已经加载!");
        } else {
            System.out.println("java.lang.System尚未加载!");
        }
 
        if (method.invoke(Thread.currentThread().getContextClassLoader(), "java.sql.Date") != null) {
            System.out.println("java.lang.System已经加载!");
        } else {
            System.out.println("java.sql.Date尚未加载!");
        }
        if (method.invoke(Thread.currentThread().getContextClassLoader(), "com.igen.message.service.struct.RuleStructImpl") != null) {
            System.out.println("java.lang.RuleStructImpl已经加载!");
        } else {
            System.out.println("java.sql.RuleStructImpl尚未加载!");
        }
    } 
}