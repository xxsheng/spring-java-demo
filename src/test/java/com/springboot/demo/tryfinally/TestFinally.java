/**
 * 
 */
package com.springboot.demo.tryfinally;

/**
 * @author IGEN
 *
 */
public class TestFinally {

    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub

        Long test = test();
        System.out.println(test);
    }

    static Long test() {
        long num = 1;
        try {
            int a = 4/2;
            return num = num +1L;
        } catch (Exception e) {
            
            e.printStackTrace();
            return num = num +1L;
            // TODO: handle exception
        }finally {
            return num = num +1L;
        }
        
    }
}
