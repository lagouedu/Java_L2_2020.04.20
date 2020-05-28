package com.lagou.handler;

import com.lagou.service.UserServiceImpl;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

public class UserServerHandler extends ChannelInboundHandlerAdapter {


    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {

        // 判断是否符合约定，符合则调用本地方法，返回数据
        // msg:  UserService#sayHello#are you ok?
        if(msg.toString().startsWith("UserService")){
            UserServiceImpl userService = new UserServiceImpl();
            String result = userService.sayHello(msg.toString().substring(msg.toString().lastIndexOf("#") + 1));
            ctx.writeAndFlush(result);
        }


    }
}
