/**
 * 
 */
package com.springboot.demo.aop;

import java.lang.reflect.Method;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.aop.framework.AopContext;
import org.springframework.stereotype.Component;

/**
 * @author IGEN
 *
 */
@Component
@Aspect
public class AopClass {

    @Pointcut("execution( public * com.springboot.demo.*.controller..*.*(..))")
    public void addAdvice() {};
    
    @Pointcut("execution( public * com.springboot.demo.*.interf..*.*(..))")
    public void interfaceAdvice() {};
    
    @Before("addAdvice()")
    public void doBefor(JoinPoint joint) {
        Method method = ((MethodSignature) joint.getSignature()).getMethod();
        System.out.println(joint.getArgs());
        System.out.println("target is-----------" + joint.getTarget());
        System.out.println(System.identityHashCode(joint.getTarget()));
        System.out.println("this is------------" + joint.getThis());
        System.out.println(System.identityHashCode(joint.getThis()));
        System.out.println(joint.getTarget() == joint.getThis());
        System.out.println(joint.getTarget().equals(joint.getThis()));
        System.out.println("target class name is ----------------" + joint.getTarget().getClass().getName());
        System.out.println("this class name is ------------------" + joint.getThis().getClass().getName());
        System.out.println("---------------------------------------------------------");
        Object object = AopContext.currentProxy();
        System.out.println(object);
    }
    
    @Before("interfaceAdvice()")
    public void doBefore(JoinPoint joint) {
        Method method = ((MethodSignature) joint.getSignature()).getMethod();
        System.out.println(joint.getTarget());
        System.out.println(joint.getThis());
//        method.invoke(obj, args)
    }
}
