package com.lagou.IO;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;

public class NettyServer2 {

    public static void main(String[] args) throws InterruptedException {

        //1.创建  NioEventLoopGroup的两个实例:bossGroup workerGroup
        // 当前这两个实例代表两个线程池，默认线程数为CPU核心数乘2
        // bossGroup接收客户端传过来的请求
        // workerGroup处理请求
        EventLoopGroup bossGroup = new NioEventLoopGroup();
        EventLoopGroup workerGroup = new NioEventLoopGroup();
        
        //2、创建服务启动辅助类:组装一些必要的组件
        ServerBootstrap serverBootstrap = new ServerBootstrap();
        serverBootstrap.group(bossGroup,workerGroup)
                //channel方法指定服务器监听的通道
                .channel(NioServerSocketChannel.class)
                //设置channel handler
                .childHandler(new ChannelInitializer<NioSocketChannel>() {
                    @Override
                    protected void initChannel(NioSocketChannel ch) throws Exception {
                        ChannelPipeline pipeline = ch.pipeline();
                        pipeline.addLast(new StringEncoder());
                        pipeline.addLast(new StringDecoder());
                        pipeline.addLast(new SimpleChannelInboundHandler<String>() {
                            @Override
                            protected void channelRead0(ChannelHandlerContext channelHandlerContext, String s) throws Exception {
                                System.out.println(s);
                            }
                        });


                    }
                });

        //bind监听端口
        ChannelFuture f = serverBootstrap.bind(8000).sync();
        System.out.println("tcp server start success..");
        //会阻塞等待直到服务器的channel关闭
        f.channel().closeFuture().sync();


    }


}
