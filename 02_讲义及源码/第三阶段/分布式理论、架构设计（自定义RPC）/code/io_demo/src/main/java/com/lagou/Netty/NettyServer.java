package com.lagou.Netty;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;

public class NettyServer {

    public static void main(String[] args) throws InterruptedException {

        //1.创建NioEventLoopGroup的两个实例对象
        // 它们就是两个线程池 ，默认的线程数就是CPU核心数*2
        EventLoopGroup bossGroup = new NioEventLoopGroup();
        EventLoopGroup workerGroup = new NioEventLoopGroup();

        //2.创建服务启动辅助类:装配一些组件的
        ServerBootstrap bootstrap = new ServerBootstrap();
        bootstrap.group(bossGroup,workerGroup)
                //指定服务器端监听套接字通道NioServerSocketChannel
                .channel(NioServerSocketChannel.class)
                //设置业务职责链 channelhandle组成
                //ChannelInitializer:初始化channel的chanelpipeline
                .childHandler(new ChannelInitializer<NioSocketChannel>() {
                    @Override
                    protected void initChannel(NioSocketChannel ch) throws Exception {
                        ChannelPipeline pipeline = ch.pipeline();
                        //将一个一个的channelhandler添加到责任链上，在请求进来或者响应出去的时候，都会经过链上channelhandler进行处理
                        pipeline.addLast(new StringEncoder());
                        pipeline.addLast(new StringDecoder());
                        pipeline.addLast(new SimpleChannelInboundHandler<String>() {
                            @Override
                            protected void channelRead0(ChannelHandlerContext channelHandlerContext, String msg) throws Exception {
                                System.out.println(msg);
                            }
                        });


                    }
                });

        // bind 监听端口
        //sync:用于阻塞当前的thread,一直到端口绑定操作完成
        ChannelFuture f = bootstrap.bind(8000).sync();
        System.out.println("tcp server start success..");
        //应用程序会阻塞等待直到服务器的channel关闭
        f.channel().closeFuture().sync();

    }



}
