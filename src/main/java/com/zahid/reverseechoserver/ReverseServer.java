package com.zahid.reverseechoserver;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class ReverseServer {
    public static void main(String[] args) {
        System.out.println("[SERVER] Started");
        String incomingText = "";
        String outgoingText = "";
        String str = "";
        
        try (
            ServerSocket ss = new ServerSocket(4096);
            Socket soc = ss.accept();
            
            DataOutputStream dos = new DataOutputStream(soc.getOutputStream());
            DataInputStream dis = new DataInputStream(soc.getInputStream());
            ) {
                while (!incomingText.equalsIgnoreCase("end")) {
                    str = dis.readUTF();
                    System.out.println("[SERVER] Incoming Text: " + str); // printing reverserd string from server side
                    outgoingText = reverse(str);
                    System.out.println("[SERVER] Outgoing Text: " + outgoingText); // printing reverserd string from server side
                    dos.writeUTF(outgoingText);
                }
                
            } catch (Exception e) {}
        System.out.println("[SERVER] Closed");
    }

    public static String reverse(String str) {
        StringBuilder sb = new StringBuilder(str);
        sb = sb.reverse();
        String text = sb.toString();
        return text;
    }
}
