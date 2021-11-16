package com.zahid.datagramserver;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

public class DatagramClient {
    public static void main(String[] args) throws Exception {
        System.out.println("[Client] Started");
        try (
            DatagramSocket ds = new DatagramSocket(2001);
            Scanner sc = new Scanner(System.in);
        ) {
            String str;
            String msg;
            while (true) {
                // sending to datagram server
                System.out.print("[Client] Input: ");
                str = sc.nextLine();
                DatagramPacket dp = new DatagramPacket(str.getBytes(), str.length(), InetAddress.getByName("localhost"), 2000);
                ds.send(dp);
                if(str.equalsIgnoreCase("end")) break;
    
                // receiving back from datagram server
                byte[] b = new byte[1024];
                dp = new DatagramPacket(b, 1024);
                ds.receive(dp);
                msg = new String(dp.getData()).trim();
                System.out.printf("[Client] Reversed: `%s`\n", msg);
            }
            
        } catch (Exception e) {}
        System.out.println("[Client] Closed");
    }
}