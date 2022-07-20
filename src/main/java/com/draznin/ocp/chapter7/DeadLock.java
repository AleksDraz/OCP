package com.draznin.ocp.chapter7;

public class DeadLock {

    public void goLock(Object o1, Object o2) {
        synchronized (o1) {
            System.out.println("Thread id: " + Thread.currentThread().getId() + " inside o1");
            synchronized (o2) {
                System.out.println("Thread id: " + Thread.currentThread().getId() + " inside o2");
            }
        }
    }
}
