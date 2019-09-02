package com.springboot.demo;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.Method;
import java.net.URL;

import org.aopalliance.intercept.Joinpoint;
import org.aspectj.lang.JoinPoint;
import org.junit.Test;
import org.springframework.cglib.core.DebuggingClassWriter;
import org.springframework.cglib.proxy.InvocationHandler;
import org.springframework.cglib.proxy.Proxy;

import com.springboot.demo.api.interf.Interface1;

import sun.misc.ProxyGenerator;

public class TestA extends TestJdkProxy{

    public static void main(String[] args) throws IOException {
        System.setProperty(DebuggingClassWriter.DEBUG_LOCATION_PROPERTY, "d:\\temp"); 
        Interface1 newProxyInstance = (Interface1)Proxy.newProxyInstance(TestA.class.getClassLoader() , new Class [] {Interface1.class}, new InvocationHandler() {
            
            @Override
            public Object invoke(Object arg0, Method arg1, Object[] arg2) throws Throwable {
                // TODO Auto-generated method stub
                System.out.println(arg0.getClass());
                arg1.invoke(arg0, arg2);
                return arg0;
            }
        });
        newProxyInstance.sayHello();
        transClass();
        System.out.println(newProxyInstance.getClass());
    }
    
    
    public static void transClass() throws IOException {
        URL resource = TestJdkProxy.class.getClass().getResource("/");
        byte[] bts = ProxyGenerator.generateProxyClass("Proxy$ProxyImpl$$EnhancerByCGLIB$$737add79", new Class[]{Interface1.class});
        File file = new File(resource.getPath(),"Proxy$ProxyImpl$$EnhancerByCGLIB$$737add79.class");
        if (!file.exists()){
            file.createNewFile();
        }
        FileOutputStream fos = new FileOutputStream(file);
        fos.write(bts);
        fos.flush();
        fos.close();
        System.out.println(resource.getPath());
    }
}
