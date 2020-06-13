package com.lagou;

import com.lagou.bean.ComsumerComponet;
import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

public class AnnotationConsumerMain  {
    public static void main(String[] args) throws  Exception {
        System.out.println("-------------");
        AnnotationConfigApplicationContext   context = new AnnotationConfigApplicationContext(ConsumerConfiguration.class);
        context.start();
        // 获取消费者组件
        ComsumerComponet  service = context.getBean(ComsumerComponet.class);
        while(true){
             System.in.read();
             String  hello = service.sayHello("world");
             System.out.println("result:"+hello);
        }
    }
    @Configuration
    @PropertySource("classpath:/dubbo-consumer.properties")
    @ComponentScan(basePackages = "com.lagou.bean")
    @EnableDubbo
    static  class  ConsumerConfiguration{

    }
}
