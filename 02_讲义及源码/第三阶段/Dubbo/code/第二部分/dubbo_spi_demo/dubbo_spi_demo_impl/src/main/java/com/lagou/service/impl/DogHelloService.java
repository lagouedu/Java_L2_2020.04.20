package com.lagou.service.impl;

import com.lagou.service.HelloService;
import org.apache.dubbo.common.URL;

public class DogHelloService implements HelloService{
    @Override
    public String sayHello() {
        return "wang wang";
    }

    @Override
    public String sayHello(URL url) {
        return "wang url";
    }
}
