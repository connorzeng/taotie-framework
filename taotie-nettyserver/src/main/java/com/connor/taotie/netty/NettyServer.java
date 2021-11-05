package com.connor.taotie.netty;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.logging.LogLevel;
import io.netty.handler.logging.LoggingHandler;

public class NettyServer {

    public static void main(String[] args) throws InterruptedException {
        //1. 声明线程组 (一主多从,变异模型)
        EventLoopGroup bossGroup = new NioEventLoopGroup(1);//接收事件socket的  mainReactor
        EventLoopGroup workerGroup = new NioEventLoopGroup();//默认CPU合数, 处理读写事件.  subReactor/subReactor/subReactor/....多个子subReactor


        // 配置参数
        ServerBootstrap serverBootstrap = new ServerBootstrap();
        // 设置线程池
        serverBootstrap.group(bossGroup, workerGroup)
                .channel(NioServerSocketChannel.class)
                .option(ChannelOption.SO_BACKLOG, 100)
                .handler(new LoggingHandler(LogLevel.DEBUG))// serverSocket channel
                .childHandler(new ChannelInitializer<SocketChannel>() {
                    @Override
                    protected void initChannel(SocketChannel socketChannel) throws Exception {
                        ChannelPipeline pipeline = socketChannel.pipeline();
                        //给pipeline 设置处理器
                        //添加handler
                        pipeline.addLast(new NettyServerOutBoundHandler());
                        pipeline.addLast(new NettyServerHandler());
                    }
                });
        // 绑定端口  启动服务
        ChannelFuture channelFuture = serverBootstrap.bind(6668).sync();
        // 对关闭通道进行监听
        channelFuture.channel().closeFuture().sync();
    }
}
