package com.springboot.demo;

import java.io.UnsupportedEncodingException;
import java.util.List;

import org.junit.Test;

public class TestString {

    public static void main(String[] args) throws UnsupportedEncodingException {
        // TODO Auto-generated method stub

        String [] split = new String [] {"测试"};
        
        String str = new String(split[0].getBytes("UTF-8"),"ISO-8859-1");
        
        String str1 = new String(str.getBytes("ISO-8859-1"),"UTF-8");
        System.out.println(str1);
    }

    public static int main(List<String> value1) {
        return 1;
    }
//    
//    public static String main(List<Integer> value1) {
//        return "";
//    }
    
    @Test
    public void testMath() {
        System.out.println(Math.round(11.5));
        System.out.println(Math.round(-11.5));
    }
}
