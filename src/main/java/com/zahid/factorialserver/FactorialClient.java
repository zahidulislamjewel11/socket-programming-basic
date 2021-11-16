package com.zahid.factorialserver;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;
import java.util.Scanner;

import static com.zahid.factorialserver.Utility.sleep;

public class FactorialClient {
    public static void main(String[] args) {
        System.out.println("[Client] Started");
        try (
            Socket soc = new Socket("127.0.0.1", 4923);
            Scanner sc = new Scanner(System.in);
            DataOutputStream dos = new DataOutputStream(soc.getOutputStream());
            DataInputStream dis = new DataInputStream(soc.getInputStream());
        ) {
            while (true) {
                System.out.print("[Client] Enter an integer> ");
                int num = sc.nextInt();
                if(num == -1) break;
                sleep(1000);
                dos.writeInt(num);
                int factorial = dis.readInt();
                System.out.printf("[Client] factorial(%d) = %d\n", num, factorial);
            }
            
        } catch (Exception e) {}
        System.out.println("[Client] Closed");
    }
}