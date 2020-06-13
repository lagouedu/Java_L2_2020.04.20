package com.lagou.service.impl;

import com.lagou.service.HelloService;

import java.util.concurrent.TimeUnit;


public class HelloServiceImpl  implements HelloService {
    @Override
    public String sayHello(String name){
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "hello:"+name;
    }
}
