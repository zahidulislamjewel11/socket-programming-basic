package com.zahid.multithreadedserver;

import static com.zahid.multithreadedserver.Utility.fact;
import static com.zahid.multithreadedserver.Utility.sleep;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;;

public class ServerThread implements Runnable {
    Socket clientSocket = null;

    public ServerThread(Socket clientSocket) {
        this.clientSocket = clientSocket;
        new Thread(this);
    }

    @Override
    public void run() {
        try (
            DataInputStream dis = new DataInputStream(clientSocket.getInputStream());
            DataOutputStream dos = new DataOutputStream(clientSocket.getOutputStream());
        ) {
            while (true) {
                int num = dis.readInt();
                System.out.printf("[Server] Input = %d\n", num);
                int result = fact(num);
                if (num == -1) break;
                sleep(100);
                System.out.printf("[Server] fact(%d) = %d\n", num, result);
                dos.writeInt(result);
            }
        } catch (Exception e) {}
    }
}
