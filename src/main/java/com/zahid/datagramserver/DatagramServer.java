package com.zahid.datagramserver;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class DatagramServer {
    public static void main(String[] args) throws Exception {
        System.out.println("[Server] Started");
        try (
            DatagramSocket ds = new DatagramSocket(2000);
        ) {
            String incomingText;
            String outgoingText;
            while (true) {
                byte[] b = new byte[1024];
                DatagramPacket dp = new DatagramPacket(b, 1024);
                ds.receive(dp);
                incomingText = new String(dp.getData()).trim();
                if(incomingText.equalsIgnoreCase("end")) break;

                System.out.println("[Server] incomingText: " + incomingText);
                outgoingText = reverse(incomingText);
                
                dp = new DatagramPacket(outgoingText.getBytes(), outgoingText.length(), InetAddress.getByName("localhost"), 2001);
                ds.send(dp);
                System.out.println("[Server] outgoingText: " + outgoingText);
            }
            
        } catch (Exception e) {}
        System.out.println("[Server] Closed: " );
    }

    public static String reverse(String str) {
        StringBuilder sb = new StringBuilder(str);
        sb.reverse();
        String text = sb.toString();
        return text;
    }
}
