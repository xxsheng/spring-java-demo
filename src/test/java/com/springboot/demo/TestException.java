package com.springboot.demo;

import org.junit.Test;

import com.springboot.demo.api.exception.ApplicationException;

public class TestException {

    @Test
    public void testException() throws Exception {
        try {
            test();
        } catch (Exception e) {
          throw  new Exception(e);
        }
        
    }

    private void test() {
        // TODO Auto-generated method stub
        Integer a = null;
        System.out.println(a.intValue());
    }
}
