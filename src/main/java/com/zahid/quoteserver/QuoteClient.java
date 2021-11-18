package com.zahid.quoteserver;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.concurrent.TimeUnit;

public class QuoteClient {
    public static void main(String[] args) throws IOException {
        System.out.println("[Client] Started");
        try (
            // getting datagram socket
            DatagramSocket socket = new DatagramSocket(4321); // socket opened on client side for sending/receiving
        ) {
            // sending request
            byte[] buffer = new byte[2048];
            String received;
            int count = 0;
            while (true) {
                DatagramPacket packet = new DatagramPacket(buffer, buffer.length, InetAddress.getLocalHost(), 9999); // client preparing packet for server on server port 9999
                socket.send(packet);
                
                packet = new DatagramPacket(buffer, buffer.length);
                socket.receive(packet);

                received = new String(packet.getData(), 0, packet.getLength());
                if(received == null || received.length() < 1) break;
 
                System.out.printf("[Client] Quote %02d: `%s`\n", ++count, received);
                sleep(100);
            }
            
        } catch (Exception e) {}
        System.out.println("[Client] Connection Closed");
    }

    public static void sleep(int ms) {
        try { TimeUnit.MILLISECONDS.sleep(ms);
        } catch (InterruptedException e) {}
    }
}
