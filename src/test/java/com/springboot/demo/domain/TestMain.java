/**
 * 
 */
package com.springboot.demo.domain;

import java.util.ArrayList;
import java.util.List;

/**
 * @author IGEN
 *
 */
public class TestMain {

    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub

        
        UserSon userSon = new UserSon();
        
        
        userSon.setUserSonName("userSonName");
        
        System.out.println(userSon);
        
        List<UserDto> list = new ArrayList<UserDto>();
        
        userSon.setUserSonId("1");
        list.add(new UserDto(userSon));
        
        userSon.setUserSonId("2");
        list.add(new UserDto(userSon));
        
        System.out.println(list.toString());
    }

}
