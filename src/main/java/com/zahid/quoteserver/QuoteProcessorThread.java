package com.zahid.quoteserver;

import java.io.BufferedReader;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class QuoteProcessorThread extends Thread {

    protected DatagramSocket socket = null;
    protected BufferedReader br = null;
    protected List<String> quoteList = null;
    
    public QuoteProcessorThread(DatagramSocket ds, List<String> quoteList) throws IOException {
        super("QuoteProcessorThread");
        this.socket = ds;
        this.quoteList = quoteList;
    }
    
    @Override
    public void run() {
        try {
            DatagramPacket packet;
            byte[] buffer = new byte[2048];
            
            for(String quote: quoteList) {
                buffer = quote.getBytes();
                packet = new DatagramPacket(buffer, buffer.length, InetAddress.getByName("localhost"), 4321);
                socket.send(packet);
                sleep(100);
            } 
        } catch (Exception e) {
            e.printStackTrace();
        }
    }   
    
    public static void sleep(int ms) {
        try { TimeUnit.MILLISECONDS.sleep(ms);
        } catch (InterruptedException e) {}
    }
}
