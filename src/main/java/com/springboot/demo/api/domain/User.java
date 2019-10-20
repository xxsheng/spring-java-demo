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

    private Integer userId;
    private String userName;
    private String userDescription;
    
}
