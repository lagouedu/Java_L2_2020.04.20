package com.lagou.demo;

import com.lagou.pojo.User;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 * 远程服务对象实现类：必须要继承UnicastRemoteObject
 */
public class HelloServiceImpl  extends UnicastRemoteObject implements IHelloService {


    public HelloServiceImpl() throws RemoteException {
    }

    public String sayHello(User user) throws RemoteException {
        System.out.println("this is server, hello:"+user.getName());
        return "success";
    }
}
