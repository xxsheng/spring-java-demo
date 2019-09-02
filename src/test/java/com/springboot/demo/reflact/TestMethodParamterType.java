/**
 * 
 */
package com.springboot.demo.reflact;

import java.lang.reflect.Method;
import java.util.List;

/**
 * @author IGEN
 *
 */
public class TestMethodParamterType {

    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub

        Method[] methods = TestB.class.getMethods();
        for (Method method : methods) {
//            System.out.println(method.getName());
            if (method.getName().equals("test2")) {
                Class<?>[] parameterTypes = method.getParameterTypes();
                for (Class clazz : parameterTypes) {
                    System.out.println(clazz);
                }
            }
        }
    }

}
class TestA{
    public void test1(String arg0, Integer arg1) {
        System.out.println("-------");
    }
}

interface TestB{
    void test2(List<Long> list, Object o);
}