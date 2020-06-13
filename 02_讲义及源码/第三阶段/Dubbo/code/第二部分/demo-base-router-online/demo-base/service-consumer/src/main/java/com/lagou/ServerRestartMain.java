package com.lagou;

import com.lagou.router.ReadyRestartInstances;

public class ServerRestartMain {
    public static void main(String[] args) throws  Exception {
        //ReadyRestartInstances.create().addRestartingInstance("service-provider","192.168.20.1");
        ReadyRestartInstances.create().removeRestartingInstance("service-provider","192.168.20.1");
    }
}
