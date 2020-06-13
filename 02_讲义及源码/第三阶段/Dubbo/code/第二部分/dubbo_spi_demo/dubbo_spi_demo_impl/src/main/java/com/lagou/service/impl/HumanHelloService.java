package com.lagou.service.impl;

import com.lagou.service.HelloService;
import org.apache.dubbo.common.URL;

public class HumanHelloService implements HelloService{
    @Override
    public String sayHello() {
        return "hello 你好";
    }

    @Override
    public String sayHello(URL url) {
        return  "hello url";
    }
}
