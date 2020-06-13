package com.lagou.service.impl;

import com.lagou.service.HelloService;
import org.apache.dubbo.config.annotation.Service;

@Service
public class HelloServiceImpl implements HelloService {

    @Override
    public String sayHello(String name, int timeToWait) {
        try {
            Thread.sleep(timeToWait);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "hello:"+name;
    }
}
