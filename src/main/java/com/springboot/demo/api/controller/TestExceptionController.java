package com.springboot.demo.api.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class TestExceptionController {

    @RequestMapping("/test/exception")
    public ModelAndView test() throws Exception {

        throw new Exception("xxxxxxxxxxx");

    }
}
