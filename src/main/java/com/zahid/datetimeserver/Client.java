package com.zahid.datetimeserver;

import java.io.DataInputStream;
import java.net.Socket;

public class Client {
    public static void main(String[] args) {
        System.out.println("[Client] Started");
        try (
            Socket soc = new Socket("localhost", 4096);
            DataInputStream dis = new DataInputStream(soc.getInputStream());
        ) {
            while (true) {
                System.out.println("[Client] Requesting Current Date From Server");
                Utility.sleep(2000);
                String today = dis.readUTF();
                System.out.println("[Client] Current Date: " + today);
            }
            
        } catch (Exception e) {e.printStackTrace();}
        System.out.println("[Client] Connection Closed");
    }
}
