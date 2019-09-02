/**
 * 
 */
package com.springboot.demo.api.config.testdomain;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author IGEN
 *
 */
public class TestApplication {

    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub

        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext();
        ac.register(TestConfig.class);
        ac.refresh();
        
        ac.getBean(Test1.class);
//        System.out.println(ac.getType("test1"));
    }

}
