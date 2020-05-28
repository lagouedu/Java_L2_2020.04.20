package com.lagou.IO;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;

public class NettyServer3 {

    public static void main(String[] args) {
        //1.设置boss和work
        // step 1 设置boss 和 work
        EventLoopGroup bossGroup = new NioEventLoopGroup();
        EventLoopGroup workerGroup = new NioEventLoopGroup();
        try {
            // step 2 服务启动辅助类
            ServerBootstrap b = new ServerBootstrap();
            // 设置线程池
            b.group(bossGroup, workerGroup)
                    // step3 设置channel
                    .channel(NioServerSocketChannel.class)
                    // setp4 设置channel hanlder
                    .childHandler(new ChannelInitializer<NioSocketChannel>() {
                        @Override
                        protected void initChannel(NioSocketChannel ch) throws Exception {
                            ChannelPipeline p = ch.pipeline();
                            p.addLast(new StringDecoder());
                            p.addLast(new StringEncoder());
                            ch.pipeline().addLast(new SimpleChannelInboundHandler<String>() {
                                @Override
                                protected void channelRead0(ChannelHandlerContext ctx, String msg) {
                                    System.out.println(msg);
                                }
                            });
                        }


                    });
            // step 7 Bind 监听端口.
            ChannelFuture f = b.bind(8000).sync();
            System.out.println("tcp server start success... ");
            f.channel().closeFuture().sync();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
        }
    }


}
