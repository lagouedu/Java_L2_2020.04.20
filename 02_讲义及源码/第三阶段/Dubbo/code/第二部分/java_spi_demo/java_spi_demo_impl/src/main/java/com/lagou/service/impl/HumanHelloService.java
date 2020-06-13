package com.lagou.service.impl;

import com.lagou.service.HelloService;

public class HumanHelloService   implements HelloService {
    @Override
    public String sayHello() {
        return "hello 你好";
    }
}
