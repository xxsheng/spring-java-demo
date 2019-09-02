package com.springboot.demo;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
public class TestSqlSessionFactory {

    @Autowired
    private SqlSessionFactory factory;
    
    @Autowired
    private SqlSessionTemplate template;
    
    @Test
    public void test1() {
        SqlSession openSession = factory.openSession();
        System.out.println(factory);
        System.out.println(openSession.getClass().getSimpleName());
        System.out.println(template.getSqlSessionFactory());
//        openSession.delete(statement)
        
    }
}
