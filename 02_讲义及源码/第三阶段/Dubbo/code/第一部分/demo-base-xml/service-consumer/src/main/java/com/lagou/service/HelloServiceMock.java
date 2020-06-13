package com.lagou.service;

public class HelloServiceMock implements  HelloService{
    @Override
    public String sayHello(String name) {
        return "hello mock";
    }
}
