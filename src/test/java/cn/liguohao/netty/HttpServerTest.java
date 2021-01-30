package cn.liguohao.netty;

import cn.liguohao.netty.http.HttpServer;

/**
 * @author <a href="mailto:liguohao_cn@qq.com">liguohao_cn@qq.com</a>
 * @since 2021/1/26
 */
public class HttpServerTest {
    public static void main(String[] args) throws Exception {

        HttpServer httpServer = new HttpServer(9000);
        httpServer.start();
    }
}
