package com.zahid.basic;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.Map;

public class HttpURLConnectionTest {
    public static void main(String[] args) throws IOException {
        URL url = new URL("http://www.google.com");
        HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();

        System.out.println("# Request Method: " + httpURLConnection.getRequestMethod());
        System.out.println("# Response Code: " + httpURLConnection.getResponseCode());
        System.out.println("# Response Message: " + httpURLConnection.getResponseMessage());
        System.out.println();

        Map<String, List<String>> headerFieldMap = httpURLConnection.getHeaderFields();
        for (Map.Entry<String, List<String>> entry : headerFieldMap.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}
