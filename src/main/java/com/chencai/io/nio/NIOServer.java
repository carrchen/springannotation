package com.chencai.io.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.*;
import java.nio.charset.Charset;
import java.util.Iterator;
import java.util.Set;

public class NIOServer {

    Selector selector;
    int port;

    public NIOServer(int port) throws IOException {
        this.port = port;

        ServerSocketChannel server = ServerSocketChannel.open();

        server.bind(new InetSocketAddress(this.port));
        server.configureBlocking(false);

        selector = Selector.open();

        server.register(selector, SelectionKey.OP_ACCEPT);
        System.out.println("服务已启动，监听端口为：" + this.port);
    }

    public void listener() throws IOException {
        while (true) {
            int wait = selector.select();
            if (wait == 0) continue;
            Set<SelectionKey> keys = selector.selectedKeys();
            Iterator<SelectionKey> iterator = keys.iterator();
            while (iterator.hasNext()) {
                SelectionKey key = iterator.next();
                iterator.remove();
                process(key);
            }

        }
    }

    private void process(SelectionKey key) throws IOException {
        if (key.isAcceptable()) {
            ServerSocketChannel channel = (ServerSocketChannel)key.channel();
            SocketChannel client = channel.accept();
            client.configureBlocking(false);
            client.register(selector, SelectionKey.OP_ACCEPT);

            key.interestOps(SelectionKey.OP_ACCEPT);

        }
    }
}
