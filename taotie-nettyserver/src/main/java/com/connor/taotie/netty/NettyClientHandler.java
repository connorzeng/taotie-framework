package com.connor.taotie.netty;

import com.alibaba.fastjson.JSON;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.util.CharsetUtil;

import java.io.File;

public class NettyClientHandler extends ChannelInboundHandlerAdapter {

    /**
     * 连接上服务的回调方法
     * @param ctx
     * @throws Exception
     */
    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        // 发送数据
        System.out.println("channelActive: 连接上了 服务器....");
        // 测试粘包,多个包会组合在一起发送.
        for (int i=0;i<10000;i++){
            ctx.writeAndFlush(Unpooled.copiedBuffer("{\"name\": \"曾罡\", \"sex\": \"man\",\"age\": \"31\"}" + System.getProperty("line.separator"), CharsetUtil.UTF_8));
        }

        //发送一个xml
        //ctx.writeAndFlush(Unpooled.copiedBuffer("<head>hello</head>", CharsetUtil.UTF_8));
    }


    /**
     * 读取服务端返回的信息
     * @param ctx
     * @param msg
     * @throws Exception
     */
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        ByteBuf buf  = (ByteBuf) msg;
        System.out.println("channelRead: " + buf.toString(CharsetUtil.UTF_8));
    }

    @Override
    public void channelRegistered(ChannelHandlerContext ctx) throws Exception {
        super.channelRegistered(ctx);
        System.out.println("channelRegistered: ...");
        ctx.writeAndFlush(Unpooled.copiedBuffer("channelRegistered,channelRegistered,channelRegistered", CharsetUtil.UTF_8));
    }


}
