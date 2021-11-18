package com.zahid.quoteserver;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.net.DatagramSocket;
import java.util.ArrayList;
import java.util.List;

public class QuoteServer {

    protected static DatagramSocket socket = null;
    protected List<String> quoteList = null;
    protected BufferedReader br = null;

    public QuoteServer(int port) throws IOException {
        socket = new DatagramSocket(port); // socket opened on server side for listening/reveiving
    }
    public static void main(String[] args) throws IOException, InterruptedException {
        
        System.out.println("[Server] Started");
        QuoteServer quoteServer = new QuoteServer(9999);

        List<String> quoteList = quoteServer.generateQuoteList();
        quoteServer.serveClient(quoteList);
        
        System.out.println("[Server] Connection Closed");
    }
    
    public List<String> generateQuoteList() throws IOException {
        br = new BufferedReader(new FileReader("src/main/resources/one-liners.txt"));
        quoteList = new ArrayList<>();
        String quote;
        while((quote = br.readLine()) != null) {
            quoteList.add(quote);
        } 
        return quoteList;
    }
    
    public void serveClient(List<String> ql) throws IOException, InterruptedException {
        QuoteProcessorThread quoteProcessorThread =  new QuoteProcessorThread(socket, ql);
        quoteProcessorThread.start();
        quoteProcessorThread.join();
    }
}
