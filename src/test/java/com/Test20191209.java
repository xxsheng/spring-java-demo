package com;

import com.springboot.SpringJavaDemoApplication;
import com.springboot.demo.api.interf.Interface1;
import com.springboot.demo.api.interf.Interface2;
import com.springboot.demo.api.interf.Interface3;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = SpringJavaDemoApplication.class)
public class Test20191209 {
//    @Autowired
//    Interface2 interface2;

    @Autowired
    Interface3 interface3;

    @Test
    public void testxxxxxxx() throws Exception {
        interface3.sayHello();
    }

}
