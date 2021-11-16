package com.zahid.multithreadedserver;

import java.util.concurrent.TimeUnit;

public class Utility {
    
    public static int fact(int n) {
        if(n<=1) return 1;
        return n*fact(n-1);
    }
    public static void sleep(int ms) {
        try {TimeUnit.MILLISECONDS.sleep(ms);
        } catch (InterruptedException e) {}
    }
}
