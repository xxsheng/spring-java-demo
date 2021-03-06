/**
 * 
 */
package com.springboot.demo.api.service;

import com.springboot.demo.api.controller.TestController;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.aop.framework.AopContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author IGEN
 *
 */
@Service
@Transactional(readOnly = true)
public class TestService implements ITestService{

    @Autowired
    private SqlSessionFactory sqlSessionFactory;

    @Autowired
    private TestController testController;
    
    public void testService() {
        System.out.println("-------service-------");
//        Object object = AopContext.currentProxy();
//        System.out.println(object);
        sqlSessionFactory.openSession();
    }
}
