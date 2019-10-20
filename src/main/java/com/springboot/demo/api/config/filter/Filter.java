package com.springboot.demo.api.config.filter;

import org.apache.logging.log4j.ThreadContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;
import java.util.UUID;

//@WebFilter(filterName = "xxx")
@Component
public class Filter implements javax.servlet.Filter {

    @Value("${abc.yvc}")
    private String tmp;

    @Autowired
    RedisTemplate redisTemplate;

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        String s = UUID.randomUUID().toString();
//        UUID uuid = mains;
        System.out.println(s);
        ThreadContext.put("uuid", UUID.randomUUID().toString());
        filterChain.doFilter(servletRequest, servletResponse);
    }


}
