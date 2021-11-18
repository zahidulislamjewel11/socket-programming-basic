package com.zahid.datetimeserver;

import java.util.concurrent.TimeUnit;

public class Utility {
    
    public static void sleep(int ms) {
        try {TimeUnit.MILLISECONDS.sleep(ms);
        } catch (InterruptedException e) {}
    }
}
