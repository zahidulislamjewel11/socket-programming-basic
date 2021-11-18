package com.zahid.basic;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.Date;

public class URLConnectionTest {
    public static void main(String[] args) throws IOException {
        URL url = new URL("https://www.youtube.com");
        URLConnection urlConnection = url.openConnection();

        System.out.println("# Date: " + new Date(urlConnection.getDate()));
        System.out.println("# Expires: " + new Date(urlConnection.getExpiration()));
        System.out.println("# Last-Modified: " + new Date(urlConnection.getLastModified()));
        System.out.println("# Content-Length: " + urlConnection.getContentLengthLong());

        InputStream in = urlConnection.getInputStream();
        while (true) {
            if(in.read() == -1) break;
            System.out.print((char)in.read());
        }
    }
}
