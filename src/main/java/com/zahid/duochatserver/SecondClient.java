package com.zahid.duochatserver;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class SecondClient {
    public static void main(String[] args) {
        System.out.println("[Person 2] Chat initiated");
        try (
            ServerSocket ss = new ServerSocket(4800);
            Socket soc = ss.accept();
    
            DataOutputStream dos = new DataOutputStream(soc.getOutputStream());
            DataInputStream dis = new DataInputStream(soc.getInputStream());
            Scanner sc = new Scanner(System.in);
        ) {
            String incomingText = "";
            String outgoingText = "";
            
            while(true) {
                incomingText = dis.readUTF();
                System.out.print("[Person 1] " + incomingText);
                System.out.println();
        
                if(incomingText.equalsIgnoreCase("end")) {
                    System.out.println("[Me] Chat Closed by other party");
                    break;
                }
                System.out.print("[Me] ");
                outgoingText = sc.nextLine();
                dos.writeUTF(outgoingText);

                if(outgoingText.equalsIgnoreCase("end")) {
                    System.out.println("[Me] Chatbox Closing");
                    break;
                }
                dos.flush();
            } 
        }catch (Exception e) {} 
        System.out.println("[Person 2] Chat ended");
    } 
}
