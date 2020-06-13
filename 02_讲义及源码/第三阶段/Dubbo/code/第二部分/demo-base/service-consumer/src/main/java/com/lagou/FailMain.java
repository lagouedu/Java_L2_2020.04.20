package com.lagou;

import org.apache.dubbo.common.URL;
import org.apache.dubbo.common.extension.ExtensionLoader;
import org.apache.dubbo.registry.Registry;
import org.apache.dubbo.registry.RegistryFactory;

public class FailMain {
    public static void main(String[] args) {
        RegistryFactory registryFactory =
                ExtensionLoader.getExtensionLoader(RegistryFactory.class).getAdaptiveExtension();
        Registry registry = registryFactory.getRegistry(URL.valueOf("zookeeper://127.0.0.1:2181"));
        registry.register(URL.valueOf("override://0.0.0.0/com.lagou.service.HelloService?category=configurators&dynamic=false&application=service-consumer"));
    }
}
