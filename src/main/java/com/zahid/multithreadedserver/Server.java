package com.zahid.multithreadedserver;

import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static volatile int count = 0;
    public static void main(String[] args) throws Exception {
        System.out.println("[Server] Started");
        try (
            ServerSocket ss = new ServerSocket(4923);
        ) {
            while (true) {
                Socket clientSocket = ss.accept();
                count++;
                System.out.printf("[Server] Client-%02d connected\n", count);
                new ServerThread(clientSocket);
                new ServerThread(clientSocket);
            }
        } catch (Exception e) {}

        System.out.println("[Server] Closed");
    }
}
