package com.lagou.router;

import org.apache.curator.RetryPolicy;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.retry.ExponentialBackoffRetry;

public class ZookeeperClients {
    private final CuratorFramework  client;
    private  static  ZookeeperClients  INSTANCE;

    static {
        RetryPolicy  retryPolicy  = new ExponentialBackoffRetry(1000,3);
        CuratorFramework  client  = CuratorFrameworkFactory.newClient("127.0.0.1:2181",retryPolicy);
        INSTANCE = new ZookeeperClients(client);
        client.start();
    }

    private  ZookeeperClients(CuratorFramework client) {
        this.client = client;
    }
    public  static  CuratorFramework client(){
        return  INSTANCE.client;
    }
}
