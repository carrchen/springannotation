package com.chencai.io.bio;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class BIOServer {

    ServerSocket server;

    public BIOServer(int port) {
        try {
            server = new ServerSocket(port);
            System.out.println("服务端已启动，监听端口为：8080");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void listener() throws IOException {
        while (true) {
            Socket client = server.accept();
            InputStream is = client.getInputStream();
            byte[] buff = new byte[1024];
            int len = is.read(buff);
            if (len > 0) {
                String msg = new String(buff, 0, len);
                System.out.println("收到：" + msg);
            }
        }
    }

    public static void main(String[] args) {
        try {
            new BIOServer(8080).listener();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
