/**
 * 
 */
package com.springboot.demo;

/**
 * @author IGEN
 *
 */
public class TestJavaMM {

    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub

        User user = null;
         user = test(user);
        System.out.println(user.getId());
        System.out.println(user.hashCode());
    }

    private static User test(User user) {
        // TODO Auto-generated method stub
        if(null == user) {
            user = new User();
            user.setId("1");
            user.setName("2");
        } else {
            user.setId("edit");
            user.setName("edit");
        }
        
        return user;
    }

}
