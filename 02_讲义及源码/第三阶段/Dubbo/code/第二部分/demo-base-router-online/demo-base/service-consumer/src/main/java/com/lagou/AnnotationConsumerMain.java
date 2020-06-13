package com.lagou;

import com.lagou.bean.ConsumerComponent;
import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import java.io.IOException;


public class AnnotationConsumerMain {
    public static void main(String[] args) throws IOException, InterruptedException {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ConsumerConfiguration.class);
        context.start();
        ConsumerComponent service = context.getBean(ConsumerComponent.class);
        while (true) {
            System.in.read();
            try {
                String hello = service.sayHello("world", 0);
                System.out.println("result :" + hello);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Configuration
    @PropertySource("classpath:/dubbo-consumer.properties")
    //@EnableDubbo(scanBasePackages = "com.lagou.bean")
    @ComponentScan("com.lagou.bean")
    @EnableDubbo
    static class ConsumerConfiguration {

    }
}
