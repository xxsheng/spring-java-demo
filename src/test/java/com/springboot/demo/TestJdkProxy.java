/**
 * 
 */
package com.springboot.demo;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.net.URL;

import org.junit.Test;

import com.springboot.demo.api.interf.Interface1;

import sun.misc.ProxyGenerator;


/**
 * @author IGEN
 *
 */
public class TestJdkProxy implements InvocationHandler{

    protected int a = 5;
    /**
     * @param args
     * @throws IOException 
     */
    @Test
    public static void main(String[] args) throws IOException {
        // TODO Auto-generated method stub
        System.getProperties().put("sun.misc.ProxyGenerator.saveGeneratedFiles","true");
        System.getProperties().put("sun.misc.ProxyGenerator.saveGeneratedFiles",true);
        System.out.println("$Proxy0.class全名: "+Proxy.getProxyClass(Interface1.class.getClassLoader(), Interface1.class));
        Interface1 newProxyInstance = (Interface1)Proxy.newProxyInstance(Interface1.class.getClassLoader(), new Class [] {Interface1.class}, new TestJdkProxy());
        
        newProxyInstance.sayHello();
        transClass();
    }

    @Override
    public Object invoke(Object arg0, Method arg1, Object[] arg2) throws Throwable {
        // TODO Auto-generated method stub
        //System.out.println("---------------");
        //System.out.println(arg0);
        arg1.invoke(arg0, arg2);
        return null;
    }

    public static void transClass() throws IOException {
        URL resource = TestJdkProxy.class.getClass().getResource("/");
        byte[] bts = ProxyGenerator.generateProxyClass("$Proxy0", new Class[]{Interface1.class});
        File file = new File(resource.getPath(),"$Proxy0.class");
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

 
