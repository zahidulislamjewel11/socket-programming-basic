package com.zahid.duochatserver;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;
import java.util.Scanner;

public class FirstClient {
    public static void main(String[] args) {
        System.out.println("[Person 1] Chat initiated");
        try (
            Socket soc = new Socket("127.0.0.1", 4800);
            DataOutputStream dos = new DataOutputStream(soc.getOutputStream());
            DataInputStream dis = new DataInputStream(soc.getInputStream());
            Scanner sc = new Scanner(System.in);
        ) {
            String incomingMessage = "";
            String outgoingMessage = "";
            
            while(true) {
                System.out.print("[Me] ");
                outgoingMessage = sc.nextLine();
                dos.writeUTF(outgoingMessage);
                dos.flush();

                if(outgoingMessage.equalsIgnoreCase("end")) {
                    System.out.println("[Me] Closing Chatbox");
                    break;
                }

                incomingMessage = dis.readUTF();
                System.out.print("[Person 2] " + incomingMessage);
                System.out.println();

                if(incomingMessage.equalsIgnoreCase("end")) {
                    System.out.println("[Me] Chat Closed by other party");
                    break;
                }
            }
            
        } catch (Exception e) {}
        System.out.println("[Person 1] Chat ended");

    }
}
