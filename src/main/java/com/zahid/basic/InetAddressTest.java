package com.zahid.basic;

import java.net.InetAddress;

public class InetAddressTest {
    public static void main(String[] args) throws Exception {
        System.out.println("# LoopbackAddress: " + InetAddress.getLoopbackAddress());
        System.out.println();

        InetAddress address = InetAddress.getLocalHost();
        System.out.println("# Localhost: " + address);
        System.out.println("# Localhost: " + address.getHostName());
        System.out.println("# Localhost: " + address.getHostAddress());
        System.out.println();
        
        address = InetAddress.getByName("www.google.com");
        System.out.println("# Google: " + address);
        System.out.println("# Google: " + address.getHostName());
        System.out.println("# Google: " + address.getHostAddress());
        System.out.println();
        
        System.out.println("# NBA: ");
        InetAddress[] addressList = InetAddress.getAllByName("www.nba.com");
        for (int i = 0; i < addressList.length; i++) {
            System.out.println(addressList[i]);
        }
    }
}
