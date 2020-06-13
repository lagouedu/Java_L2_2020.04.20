package com.lagou;

import com.lagou.service.HelloService;
import org.apache.dubbo.common.extension.ExtensionLoader;

import java.util.Set;

public class DubboSpiMain {
    public static void main(String[] args) {
        // 获取扩展加载器
        ExtensionLoader<HelloService>  extensionLoader  = ExtensionLoader.getExtensionLoader(HelloService.class);
        // 遍历所有的支持的扩展点 META-INF.dubbo
        Set<String>  extensions = extensionLoader.getSupportedExtensions();
        for (String extension : extensions){
            String result = extensionLoader.getExtension(extension).sayHello();
            System.out.println(result);
        }

    }
}
