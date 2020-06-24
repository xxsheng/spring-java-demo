package com.springboot.demo.test;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalUnit;

public class Test {
    public static void main(String[] args) throws InterruptedException {
//        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(Appconfig.class);
//        System.out.println("-----");
//        Thread.sleep(60000000L);
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("ss mm HH dd MM ? yyyy");
        LocalDateTime of = LocalDateTime.of(2020, 5, 27, 11, 9);
        ZonedDateTime prc1 = of.atZone(ZoneId.of("PRC"));

        Instant now = Instant.now();
        Instant minus = now.minus(30, ChronoUnit.MINUTES);
//        System.out.println();
        LocalDateTime prc = LocalDateTime.ofInstant(minus, ZoneId.of("PRC"));

        System.out.println(prc.format(dateTimeFormatter));

    }
}
