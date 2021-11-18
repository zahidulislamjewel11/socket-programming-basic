package com.zahid.basic;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class SocketTest {
    public static void main(String[] args) throws Exception {
        System.out.println("# Welcome to socket programming 1");
        try (
            Socket soc = new Socket("localhost", 4321);
            InputStream in = soc.getInputStream();
            OutputStream out = soc.getOutputStream();
        ) {
            System.out.println("# Welcome to socket programming 2");
            while (true) {
                if(in.read() == -1) break;
                System.out.println((char)in.read());
            }
            System.out.println(soc.getPort());
            System.out.println(soc.getInetAddress());
            System.out.println(soc.getSendBufferSize());
        } catch (Exception e) {}

    }  
}
