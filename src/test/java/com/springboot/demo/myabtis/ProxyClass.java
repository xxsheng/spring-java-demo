package com.springboot.demo.myabtis;

import org.apache.ibatis.annotations.Select;

import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class ProxyClass implements InvocationHandler {



    public ProxyClass() {

    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        Select annotations = method.getAnnotation(Select.class);
        System.out.println(annotations.value().toString());

        return null;
    }

    public static <T> T getProxy(Class<T> clazz){

        T o = clazz.cast(Proxy.newProxyInstance(ProxyClass.class.getClassLoader(), new Class[]{clazz}, new ProxyClass()));

        return o;
    }
}
