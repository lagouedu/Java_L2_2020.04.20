package com.lagou;

import com.lagou.service.HelloService;
import org.apache.dubbo.common.URL;
import org.apache.dubbo.common.extension.ExtensionLoader;

public class DubboAdaptiveMain {
    public static void main(String[] args) {
        URL   url  = URL.valueOf("test://localhost/hello?hello.service=dog");
        HelloService  adaptiveExtension = ExtensionLoader.getExtensionLoader(HelloService.class).getAdaptiveExtension();
        String  msg = adaptiveExtension.sayHello(url);
        System.out.println(msg);
    }
}
