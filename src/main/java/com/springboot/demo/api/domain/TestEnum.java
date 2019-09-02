/**
 * 
 */
package com.springboot.demo.api.domain;


import lombok.Getter;

/**
 * @author IGEN
 *
 */
public enum TestEnum {

    TEST_ZERO((byte)0),
    TEST_ONE((byte)1),
    TEST_TWO((byte)2);
    
    @Getter
    private byte val;

    private TestEnum(byte value) {
        this.val = value;
    }
 
    public static TestEnum getTestEnum(byte val) {
        
        for (TestEnum testEnum : TestEnum.values()) {
            
            if (testEnum.val == val) {
                
                return testEnum;
            }
        }
        
        return null;
    }
}
