package com.springboot.demo.test;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class CornTest {

    @Scheduled(cron = "0 29 18 26 5 ?")
    public void execute() {
        System.out.println("---execute--");
    }
}
