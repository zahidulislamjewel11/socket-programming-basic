package com.zahid.factorialserver;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

import static com.zahid.factorialserver.Utility.sleep;

public class FactorialServer {
    public static void main(String[] args) throws Exception {
        System.out.println("[Server] Started");
        try (
            ServerSocket ss = new ServerSocket(4923);
            Socket soc = ss.accept();
            DataInputStream dis = new DataInputStream(soc.getInputStream());
            DataOutputStream dos = new DataOutputStream(soc.getOutputStream());
        ) {
            while (true) {
                int num = dis.readInt();
                System.out.printf("[Server] Input = %d\n", num);
                int result = fact(num);
                if (num == -1) break;
                sleep(1000);
                System.out.printf("[Server] fact(%d) = %d\n", num, result);
                dos.writeInt(result);
            }
        } catch (Exception e) {}

        System.out.println("[Server] Closed");
    }

    public static int fact(int n) {
        if(n<=1) return 1;
        return n*fact(n-1);
    }
}
