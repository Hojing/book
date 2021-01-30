package cn.liguohao.netty.echo;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

/**
 * @author <a href="mailto:liguohao_cn@qq.com">liguohao_cn@qq.com</a>
 * @see <a href="https://netty.io/4.1/xref/io/netty/example/echo/EchoServerHandler.html">https://netty.io/4.1/xref/io/netty/example/echo/EchoServerHandler.html</a>
 * @since 2021/1/30
 */
public class EchoServerHandler extends ChannelInboundHandlerAdapter {

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        ctx.write(msg);
    }

    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
        ctx.flush();
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        cause.printStackTrace();
        ctx.close();
    }
}
