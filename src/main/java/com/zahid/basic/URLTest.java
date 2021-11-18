package com.zahid.basic;

import java.net.MalformedURLException;
import java.net.URL;

public class URLTest {
    public static void main(String[] args) throws MalformedURLException {
        URL url = new URL("https://www.google.com");
        
        System.out.println("# Protocol: " + url.getProtocol());
        System.out.println("# Port: " + url.getPort());
        System.out.println("# Host: " + url.getHost());
        System.out.println("# File: " + url.getFile());
        System.out.println("# Ext: " + url.toExternalForm());
    }
}
