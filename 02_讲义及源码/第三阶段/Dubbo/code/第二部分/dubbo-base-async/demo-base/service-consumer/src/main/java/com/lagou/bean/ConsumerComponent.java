package com.lagou.bean;

import com.lagou.service.HelloService;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ConsumerComponent {

    //@Reference
   @Autowired
    private HelloService helloService;

    public String sayHello(String name, int timeToWait) {
        return helloService.sayHello(name, timeToWait);
    }

}
