package com.zahid.multiclientserver;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;

public class EchoThread extends Thread {
    Socket clientSocket;

	public EchoThread(Socket clientSocket) {
		this.clientSocket = clientSocket;
	}

    @Override
    public void run() {
        try (
            DataInputStream dis = new DataInputStream(clientSocket.getInputStream());
            DataOutputStream dos = new DataOutputStream(clientSocket.getOutputStream());
        ) {
            String incomingText;
            String outgoingText;
            while (true) {
                incomingText = dis.readUTF();
                System.out.println("[Server] incomingText: " + incomingText);
                outgoingText = revese(incomingText);
                System.out.println("[Server] outgoingText: " + outgoingText);
                dos.writeUTF(outgoingText);
            }
        } catch (Exception e) {}

    }

    public static String revese(String str) {
        StringBuilder sb = new StringBuilder(str);
        return sb.reverse().toString();
    }
}
