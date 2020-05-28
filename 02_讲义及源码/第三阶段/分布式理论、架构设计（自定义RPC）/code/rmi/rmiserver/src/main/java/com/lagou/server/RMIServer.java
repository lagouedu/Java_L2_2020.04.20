package com.lagou.server;

import com.lagou.demo.HelloServiceImpl;
import com.lagou.demo.IHelloService;

import java.net.MalformedURLException;
import java.rmi.AlreadyBoundException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

public class RMIServer {

    public static void main(String[] args) throws RemoteException, AlreadyBoundException, MalformedURLException {

        //1.创建一个远程对象,同时也会创建stub对象，以及skeleton对象
        IHelloService helloService = new HelloServiceImpl();

        //2.启动注册服务:创建了远程对象注册表Registry的实例，并指定端口为8888
        LocateRegistry.createRegistry(8888);

        //3.真正注册：绑定的URL的标准格式：rmi://host:port/name rmi可以省略
        Naming.bind("//127.0.0.1:8888/zm",helloService);


    }



}
