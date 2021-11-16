package com.zahid.multiclientserver;

import java.net.ServerSocket;
import java.net.Socket;

public class MainServer {
    public static void main(String[] args) {
        System.out.println("[Server] Started");
        try (
            ServerSocket ss = new ServerSocket(4096);
            ) {
                while (true) {
                    Socket newClinetSocket = ss.accept();
                    System.out.println("[Server] New Client Connected");
                    new EchoThread(newClinetSocket).start();
            }
        } catch (Exception e) {}
        System.out.println("[Server] Closed");
    }
}
