package com.springboot.demo;

import java.lang.reflect.Method;

import org.springframework.cglib.core.DebuggingClassWriter;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import com.springboot.demo.api.interf.Interface1;
import com.springboot.demo.api.interf.InterfaceImpl;

public class TestB1 implements MethodInterceptor{

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        System.setProperty(DebuggingClassWriter.DEBUG_LOCATION_PROPERTY, "d:\\temp1"); 
        TestB1 object = new TestB1();
        Interface1 instance = (Interface1)object.getInstance(InterfaceImpl.class);
        instance.sayHello();
        
        
    }
 // 目标对象
    private Object targetObject;
    
    /**
     * 
     * 创建代理对象
     * @param targetObject
     * @return
     */
    public Object getInstance(Class targetObject) {
        this.targetObject = targetObject;
        Enhancer enhancer = new Enhancer(); //用这个类来创建代理对象（被代理类的子类）
        System.out.println(targetObject);
        enhancer.setSuperclass( targetObject); //设置被代理类作为其父类
        
        //回调方法
        enhancer.setCallback(this);
        
        //创建代理对象
        return enhancer.create();
        
    }
    
    /* (non-Javadoc)
     * @see org.springframework.cglib.proxy.MethodInterceptor#intercept(java.lang.Object, java.lang.reflect.Method, java.lang.Object[], org.springframework.cglib.proxy.MethodProxy)
     */
    @Override
    public Object intercept(Object arg0, Method arg1, Object[] arg2, MethodProxy arg3) throws Throwable {
        // TODO Auto-generated method stub
        Object result = null;
        System.out.println(arg0.getClass());
        checkIdentity(); //前置增强
        result = arg3.invokeSuper(arg0, arg2);
        log();
        return result;
    }

    public void checkIdentity() {
        System.out.println("身份验证");
    }
    
    public void log() {
        System.out.println("日志输出");
    }
}
