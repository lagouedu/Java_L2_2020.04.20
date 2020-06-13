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
            for (int i=0;i<1000;i++){
                Thread.sleep(5);
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        String   msg =  service.sayHello("world",0);
                        System.out.println(msg);
                    }
                }).start();
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
