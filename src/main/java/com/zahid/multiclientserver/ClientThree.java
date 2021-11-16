package com.zahid.multiclientserver;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class ClientThree {
    public static void main(String[] args)  throws Exception {
        System.out.println("[Client] Started");
        try (
            Socket soc = new Socket("127.0.0.1", 4096);
            Scanner sc = new Scanner(System.in);
            DataOutputStream dos = new DataOutputStream(soc.getOutputStream());
            DataInputStream dis = new DataInputStream(soc.getInputStream());
        ) {
            while (true) {
                System.out.print("[Client] Enter a string> ");
                String input = sc.nextLine();
                sleep(1000);
                dos.writeUTF(input);
                
                if(input.equalsIgnoreCase("end")) break;

                String output = dis.readUTF();
                System.out.printf("[Client] Reversed: %s\n", output);
            }
            
        } catch (Exception e) {}
        System.out.println("[Client] Closed");
    }
    
    public static void sleep(int ms) {
        try {TimeUnit.MILLISECONDS.sleep(ms);
        } catch (InterruptedException e) {}
    }
}
