/**
 * 
 */
package com.springboot.demo.api.advice;

import static com.springboot.demo.api.tool.CommonCode.*;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.springboot.demo.api.exception.ApplicationException;
import com.springboot.demo.api.exception.ExceptionView;

import lombok.extern.slf4j.Slf4j;

/**
 * @author IGEN
 *
 */
//@Slf4j
//@ControllerAdvice
//@ResponseBody
//public class RestExceptionHandler {
//
//    @ResponseStatus(HttpStatus.PRECONDITION_FAILED)
//    @ExceptionHandler(ApplicationException.class)
//    public ExceptionView applicationException(ApplicationException e) {
//        return new ExceptionView(e.getCode(),e.getParam());
//    }
//
//    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
//    @ExceptionHandler(Exception.class)
//    public ExceptionView serverErrorException(Exception e) {
//        log.error("server exception:", e);
//        return new ExceptionView(sorry_for_server_exception.name());
//    }
//}
