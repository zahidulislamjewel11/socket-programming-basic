package com.zahid.datetimeserver;

import java.io.DataOutputStream;
import java.net.Socket;
import java.util.Date;

public class Worker implements Runnable {
    Socket clientSocket;

    public Worker(Socket clientSocket) {
        this.clientSocket = clientSocket;
        new Thread(this).start();
    }

    @Override
    public void run() {
        try (
            DataOutputStream dos = new DataOutputStream(clientSocket.getOutputStream());
        ) {
            while (true) {
                String dateText = new Date().toString();
                dos.writeUTF(dateText);
            }
        } catch (Exception e) {System.out.println(e);}
        System.out.println("[Server] Clinet Connection Closed");   
    }
}
