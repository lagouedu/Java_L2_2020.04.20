package com.lagou.router;

import org.apache.dubbo.common.URL;
import org.apache.dubbo.common.extension.ExtensionLoader;
import org.apache.dubbo.registry.Registry;
import org.apache.dubbo.registry.RegistryFactory;

import java.io.IOException;

public class RouterMain {
    public static void main(String[] args) throws IOException {
        RegistryFactory  registryFactory  =
                ExtensionLoader.getExtensionLoader(RegistryFactory.class).getAdaptiveExtension();
        Registry registry = registryFactory.getRegistry(URL.valueOf("zookeeper://127.0.0.1:2181"));
        registry.register(URL.valueOf("condition://0.0.0.0/com.lagou.service.HelloService?category=routers&force=true&dynamic=true&rule="
                + URL.encode("=>host != 192.168.20.1")));
        System.in.read();
    }
}
