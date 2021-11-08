package com.connor.taotie.netty;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.xml.XmlFrameDecoder;
import io.netty.handler.logging.LogLevel;
import io.netty.handler.logging.LoggingHandler;

public class NettyXmlServer {

    public static void main(String[] args) throws InterruptedException {

        //NIO 跨平台.
        //1. 声明线程组 (一主多从,变异模型)
        //核心实现是:NioEventLoop --> 对应NIO selector
        EventLoopGroup bossGroup = new NioEventLoopGroup(1);//接收事件socket的  mainReactor  负责处理ServerSocketChannel
        EventLoopGroup workerGroup = new NioEventLoopGroup();//默认CPU合数, 处理读写事件.  subReactor/subReactor/subReactor/....多个子subReactor  负责SocketChannel
        // 怎么对SocketChannel 选择 EventLoop  DefaultEventExecutorChooserFactory
        //PowerOfTwoEventExecutorChoose

        //netty页支持BIO,只要做下简单的切换即可
        //OioEventLoopGroup oioEventLoopGroup = new OioEventLoopGroup(1);

        // 配置参数
        ServerBootstrap serverBootstrap = new ServerBootstrap();
        // 设置线程池
        serverBootstrap.group(bossGroup, workerGroup)
                .channel(NioServerSocketChannel.class)//-->对应SocketChannel
                .option(ChannelOption.SO_BACKLOG, 100)
                .handler(new LoggingHandler(LogLevel.INFO))// serverSocket channel
                .childHandler(new ChannelInitializer<SocketChannel>() {
                    @Override
                    protected void initChannel(SocketChannel socketChannel) throws Exception {
                        ChannelPipeline pipeline = socketChannel.pipeline();
                        // 给pipeline 设置处理器
                        // 添加分隔符
                        pipeline.addLast(new XmlFrameDecoder(1048576));

                        //添加handler
                        pipeline.addLast(new NettyServerHandler());
                        pipeline.addLast(new NettyServerOutBoundHandler());

                    }
                });
        // 绑定端口  启动服务
        ChannelFuture channelFuture = serverBootstrap.bind(6668).sync();
        // 对关闭通道进行监听
        channelFuture.channel().closeFuture().sync();
    }
}
