/**
 * 
 */
package com.springboot.demo.cast;

import com.springboot.demo.domain.User;
import com.springboot.demo.domain.UserSon;

/**
 * @author IGEN
 *
 */
public class TestCast {

    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub

        User user = new UserSon("1","2");
        String a = new String("a");
//        a = (String)user;
        System.out.println(a);
    }

}
