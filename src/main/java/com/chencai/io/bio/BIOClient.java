package com.chencai.io.bio;


import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.util.UUID;

public class BIOClient {
    public static void main(String[] args) {
        try {
            Socket client = new Socket("localhost", 8080);
            OutputStream os = client.getOutputStream();
            String name = UUID.randomUUID().toString();
            os.write(name.getBytes());
            os.close();
            client.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
