package com.zahid.primeserver;

import java.net.Socket;
import java.io.DataOutputStream;
import java.io.DataInputStream;
import java.util.Scanner;

import static com.zahid.primeserver.Utility.sleep;;

public class PrimeClient {

    public static void main(String[] args) {
        System.out.println("[CLIENT] Started ");
        
        try (
            Socket soc = new Socket("127.0.0.1", 4096);
            
            DataOutputStream dos = new DataOutputStream(soc.getOutputStream());
            DataInputStream dis = new DataInputStream(soc.getInputStream());
            Scanner sc = new Scanner(System.in);
            
        ) {
            int outgoingNum;
            boolean incomingResult;
            
            while(true) {
                
                System.out.print("[CLIENT] Enter an integer> ");
                outgoingNum = sc.nextInt();
                if(outgoingNum == -1) break;
                
                sleep(1000);
                
                dos.writeInt(outgoingNum);
                dos.flush();
                
                incomingResult = dis.readBoolean();
                System.out.println("[CLIENT] isPrime: " + incomingResult);
            }
                
        } catch (Exception e) {}
        System.out.println("[CLIENT] Closed ");
    }
}