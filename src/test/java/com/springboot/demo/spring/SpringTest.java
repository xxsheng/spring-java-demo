/**
 * 
 */
package com.springboot.demo.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.springboot.demo.api.config.Appconfig;
import com.springboot.demo.api.domain.User;

/**
 * @author IGEN
 *
 */
public class SpringTest {

    public static ApplicationContext abc;
    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub

        AnnotationConfigApplicationContext ac =  new AnnotationConfigApplicationContext(Appconfig.class);
        //abc.getBean(requiredType)
        User bean = ac.getBean(User.class);
        System.out.println(bean);
    }

}
