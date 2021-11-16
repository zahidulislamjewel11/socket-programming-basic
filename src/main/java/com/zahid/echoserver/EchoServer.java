package com.zahid.echoserver;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;
import java.net.ServerSocket;
import java.lang.Thread;

public class EchoServer {
    public static void main(String[] args) {

        System.out.println("[Server] Started");
        try (
            ServerSocket ss = new ServerSocket(4999);
            Socket soc = ss.accept();
            DataOutputStream dos = new DataOutputStream(soc.getOutputStream());
            DataInputStream dis = new DataInputStream(soc.getInputStream());
        ) {
            while (true) {
                String str = dis.readUTF();
                System.out.println("[Server] Received: " + str);
                Thread.sleep(1000);
                System.out.println("[Server] Sending back: " + str);
                dos.writeUTF(str);
                if(str.equalsIgnoreCase("end")) break;
            }
            
        } catch (Exception e) {}
        System.out.println("[Server] Connection closed");
    }
}