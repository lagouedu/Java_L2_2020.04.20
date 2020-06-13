package com.lagou;

import com.lagou.service.HelloService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ConsumerApplication {
    public static void main(String[] args) throws  Exception{
        ClassPathXmlApplicationContext applicationContext  = new ClassPathXmlApplicationContext("classpath:dubbo-comsumer.xml");
        //applicationContext.start();
        HelloService  helloService  = applicationContext.getBean("helloService",HelloService.class);
        System.in.read();
        String result = helloService.sayHello("world");
        System.out.println("result="+result);

    }
}
