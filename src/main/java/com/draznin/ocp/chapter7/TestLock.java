package com.draznin.ocp.chapter7;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TestLock {

    public static void main(String[] args) {
        DeadLock deadLock = new DeadLock();
        Object o1 = new Object();
        Object o2 = new Object();
        ExecutorService executorService = null;

        try{
            executorService = Executors.newFixedThreadPool(2);
            executorService.execute(() -> deadLock.goLock(o1, o2));
            executorService.execute(() -> deadLock.goLock(o2, o1));
        } finally {
            if (executorService != null) {
                executorService.shutdown();
            }
        }
    }
}
