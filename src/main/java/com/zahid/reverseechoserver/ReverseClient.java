package com.zahid.reverseechoserver;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;
import java.util.Scanner;

public class ReverseClient {
    public static void main(String[] args) {
        System.out.println("[CLIENT] Started");
        String incomingText = "";
        String outgoingText = "";
        
        try (
            Socket soc = new Socket("127.0.0.1", 4096);
            DataOutputStream dos = new DataOutputStream(soc.getOutputStream());
            DataInputStream dis = new DataInputStream(soc.getInputStream());
            Scanner sc = new Scanner(System.in);
            
            ) {
                while (!outgoingText.equalsIgnoreCase("end")) {
                    System.out.print("[CLIENT] Enter a string> ");
                    outgoingText = sc.nextLine();
                    dos.writeUTF(outgoingText);
                    dos.flush();
                    
                    incomingText = dis.readUTF();
                    System.out.println("[CLIENT] Reversed: " + incomingText);
                }
                
        } catch (Exception e) {}
        System.out.println("[CLIENT] Closed");
    }
}
