package com.lagou.service;

import org.apache.dubbo.common.URL;
import org.apache.dubbo.common.extension.Adaptive;
import org.apache.dubbo.common.extension.SPI;

@SPI("human")
public interface HelloService {
    String  sayHello();
    @Adaptive
    String  sayHello(URL  url);
}
