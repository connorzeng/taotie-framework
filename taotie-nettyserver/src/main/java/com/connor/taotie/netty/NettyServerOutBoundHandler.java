package com.connor.taotie.netty;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelOutboundHandlerAdapter;
import io.netty.channel.ChannelPromise;

public class NettyServerOutBoundHandler extends ChannelOutboundHandlerAdapter {

    @Override
    public void read(ChannelHandlerContext ctx) throws Exception {
        System.out.println("NettyServerOutBoundHandler - read");
        ctx.writeAndFlush("NettyServerOutBoundHandler.read 发来一条消息\r\n");
        super.read(ctx);
    }

    @Override
    public void write(ChannelHandlerContext ctx, Object msg, ChannelPromise promise) throws Exception {
        System.out.println("NettyServerOutBoundHandler - write");
        ctx.writeAndFlush("NettyServerOutBoundHandler.write 发来一条消息\r\n");
        super.write(ctx, msg, promise);
    }


}
