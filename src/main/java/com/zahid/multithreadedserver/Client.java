package com.zahid.multithreadedserver;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main(String[] args)  throws Exception {
        System.out.printf("[Client] Started\n");
        try (
            Socket soc = new Socket("127.0.0.1", 4923);
            Scanner sc = new Scanner(System.in);
            DataOutputStream dos = new DataOutputStream(soc.getOutputStream());
            DataInputStream dis = new DataInputStream(soc.getInputStream());
        ) {
            while (true) {
                System.out.printf("[Client] Enter an integer> ");
                int num = sc.nextInt();
                if(num == -1) break;
                Thread.sleep(1000);
                dos.writeInt(num);
                dos.flush();
                int factorial = dis.readInt();
                System.out.printf("[Client] factorial(%d) = %d\n", num, factorial);
            }
            
        } catch (Exception e) {}
        System.out.printf("[Client] Closed\n");
    }
}
