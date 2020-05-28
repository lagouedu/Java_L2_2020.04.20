package com.lagou.demo;

import com.lagou.pojo.User;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * 远程服务对象接口必须要集成Remote接口的,同时方法必须抛出throws RemoteException
 */
public interface IHelloService extends Remote {

    public String sayHello(User user)throws RemoteException;


}
