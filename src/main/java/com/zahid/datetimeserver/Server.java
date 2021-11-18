package com.zahid.datetimeserver;

import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) {
        System.out.println("[Server] Started");

        try (
            ServerSocket ss = new ServerSocket(4096); // listening for client socket
        ){
            while (true) {
                Socket clientSocket = ss.accept(); // getting client socket
                System.out.println("[Server] New Client Connected");   
                new Worker(clientSocket);
            }
        } catch (Exception e) {System.out.println(e);}
        
    }
}
