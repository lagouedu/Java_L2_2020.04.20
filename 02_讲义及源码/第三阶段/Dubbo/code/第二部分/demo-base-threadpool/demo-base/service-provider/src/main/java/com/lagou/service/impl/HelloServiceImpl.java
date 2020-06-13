package com.lagou.service.impl;

import com.lagou.service.HelloService;
import org.apache.dubbo.config.annotation.Service;

import java.util.concurrent.TimeUnit;

@Service
public class HelloServiceImpl implements HelloService {

    @Override
    public String sayHello(String name, int timeToWait) {
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "hello:"+name;
    }
}
