package com.springboot.demo.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class JDKproxy implements InvocationHandler {
    private Object targetObject;

    public JDKproxy(Object targetObject) {
        this.targetObject = targetObject;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        return method.invoke(targetObject, args);
    }
}
