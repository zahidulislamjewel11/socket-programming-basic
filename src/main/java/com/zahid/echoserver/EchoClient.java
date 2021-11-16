package com.zahid.echoserver;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;
import java.util.Scanner;
import java.lang.Thread;

public class EchoClient {
    public static void main(String[] args) {
        System.out.println("[Client] Started");
        try (
            Socket soc = new Socket("localhost", 4999);
            Scanner sc = new Scanner(System.in);
            DataOutputStream dos = new DataOutputStream(soc.getOutputStream());
            DataInputStream dis = new DataInputStream(soc.getInputStream());
        ) {
            while (true) {
                System.out.print("[Client] Enter a text> ");
                String line = sc.nextLine();
                if(line.equalsIgnoreCase("end")) break;
                Thread.sleep(1000);
                dos.writeUTF(line);
                String str = dis.readUTF();
                System.out.println("[Client] Received: " + str);
            }
            
        } catch (Exception e) {}
        System.out.println("[Client] Connection closed");
    }
}