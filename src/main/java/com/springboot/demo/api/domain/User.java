/**
 * 
 */
package com.springboot.demo.api.domain;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author IGEN
 *
 */
@Data
//@Builder
@NoArgsConstructor
public class User {
    Sex sex;
    private Integer userId;
    private String userName;
    private String userDescription;

    public static void main(String[] args) {
        System.out.println(Sex.valueOf("MAN"));
        System.out.println(Sex.FEMAL.getN());
    }
}
