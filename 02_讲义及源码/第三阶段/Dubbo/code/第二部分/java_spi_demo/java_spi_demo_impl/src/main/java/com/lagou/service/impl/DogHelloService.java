package com.lagou.service.impl;

import com.lagou.service.HelloService;

public class DogHelloService  implements HelloService {
    @Override
    public String sayHello() {
        return "wang wang";
    }
}
