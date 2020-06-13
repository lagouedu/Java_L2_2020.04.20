package com.lagou.bean;

import com.lagou.service.HelloService;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.stereotype.Component;

@Component
public class ConsumerComponent {

    @Reference(loadbalance = "onlyFirst")
    private HelloService helloService;

    public String sayHello(String name, int timeToWait) {
        return helloService.sayHello(name, timeToWait);
    }

}
