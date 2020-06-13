package com.lagou;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ProviderApplication {
    public static void main(String[] args) throws  Exception{
        ClassPathXmlApplicationContext   applicationContext  = new ClassPathXmlApplicationContext("classpath:dubbo-provider.xml");
        applicationContext.start();
        System.in.read();
    }
}
