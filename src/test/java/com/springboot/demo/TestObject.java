/**
 * 
 */
package com.springboot.demo;

import org.junit.Test;

/**
 * @author IGEN
 *
 */
public class TestObject {

    @Test
    public void testMethdo1() {
        User user1 = new User("1id", "2name");
        User user2 = new User("2id", "2name");
        
        System.out.println(user1.hashCode());
        System.out.println(user2.hashCode());
        
//        user2.setId(user1.getId());
//        user1 = user2;
        
        System.out.println(user1);
        User editUser = editUser(user1);
        System.out.println(editUser);
        System.out.println(user1);
//        System.out.println(user1.hashCode());
//        System.out.println(user2.hashCode());
//        System.out.println(System.identityHashCode(user1));
//        System.out.println(System.identityHashCode(user2));
    }
    @Test
    public void test2() {
        int i = 2;
        System.out.println(i+=i-=i*i); 
    }
    
    private User editUser(User user) {
        user.setId("editId");
        return user;
    }
}
