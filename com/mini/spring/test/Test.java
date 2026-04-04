package com.mini.spring;

import com.mini.spring.beans.BeansException;
import com.mini.spring.context.ClassPathXmlApplicationContext;

public class Test {
    public static void main(String[] args) throws BeansException {
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("beans.xml");
        AService aService = (AService) ctx.getBean("aservice");
        aService.sayHello();
    }
}
