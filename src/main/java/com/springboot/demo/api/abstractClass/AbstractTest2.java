package com.springboot.demo.api.abstractClass;

import com.springboot.demo.api.controller.TestController;
import com.springboot.demo.api.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Lookup;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;


@Component
abstract class AbstractTest1 implements CommandLineRunner {

    @Autowired
    TestController testController;

    @Autowired
    TestService testService;


}

@Component
public abstract class AbstractTest2 implements CommandLineRunner {

    private User user;

//    private AbstractTest2() {
//        this.user = createdUser();
//    }

    @Autowired
    TestController testController;

    @Autowired
    TestService testService;

    @Lookup
    abstract User createdUser();

}

@Component
@Scope(value = "prototype")
class User {

        }

@Component
class Test1 extends AbstractTest1 {

    @Override
    public void run(String... args) throws Exception {
        System.out.println(super.testController);
        System.out.println("---");
    }
}

@Component
class Test2 extends AbstractTest1 {

    @Override
    public void run(String... args) throws Exception {
        System.out.println(super.testController);
    }
}