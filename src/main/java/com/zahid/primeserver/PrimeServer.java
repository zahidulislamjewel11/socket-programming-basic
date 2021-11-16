package com.zahid.primeserver;

import java.net.Socket;
import java.net.ServerSocket;
import java.io.DataOutputStream;
import java.io.DataInputStream;

import static com.zahid.primeserver.Utility.sleep;;

public class PrimeServer {

    public static void main(String[] args) throws Exception {
        System.out.println("[Server] Started ");

        try (
            ServerSocket ss = new ServerSocket(4096);
            Socket soc = ss.accept();
            
            DataOutputStream dos = new DataOutputStream(soc.getOutputStream());
            DataInputStream dis = new DataInputStream(soc.getInputStream());

        ) {
            int incomingNum;
            boolean outgoingResult;
    
            while(true) {
                incomingNum = dis.readInt();
                if(incomingNum == -1) break;
                System.out.println("[SERVER] Input: " + incomingNum);
                
                outgoingResult = isPrime(incomingNum);
                System.out.println("[SERVER] isPrime: " + outgoingResult);
                // sleep(500);
                sleep(1000);
    
                dos.writeBoolean(outgoingResult);
            }
            
        } catch (Exception e) {}
        System.out.println("[SERVER] Stopped ");
    }    

    public static boolean isPrime(int num) {
        if(num == 0 || num == 1) return false;
        for(int i=2; i<= Math.sqrt(num); i++) {
            if( num%i == 0) return false;
        }
        return true;
    }
}
