package com.springboot.demo.api2.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.demo.api.domain.User;
import com.springboot.demo.api.exception.ApplicationException;
import com.springboot.demo.api.tool.AuthToolException;

@RestController
@RequestMapping("/test1")
public class TestController1 {

    @GetMapping("/{userId}/user")
    public User testUser(@PathVariable Integer userId) {
        
//        throw new NullPointerException("userId is null");
        //throw new ApplicationException(AuthToolException.AU_NO_OUT_OPERATION_PERMISSION);
        
//        User user = new User();
//        user.setUserId(userId);
//        return user;
        
        
        
        
        return null;
    }
    
    public static void main(String[] args) {
        String name = "test";
        List<String> list = Arrays.asList("test1","test2","test3");
        
        switch (name) {
        case "test": 
            for(String s : list) {
                System.out.println(s);
            }
            break;

        default: System.out.println(name);
            break;
        }
    }
}
