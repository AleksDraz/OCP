package com.draznin.ocp.chapter7;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

public class TestSync {


    public static void main(String[] args) throws InterruptedException {
        ExecutorService service = null;
        Dummy dummy = new Dummy();

        try {
            service = Executors.newFixedThreadPool(20);
            for (int i = 0; i < 20 ; i++) {
                service.submit(dummy::updateNotAtomicAndShow);
            }

            for (int i = 0; i < 20 ; i++) {
                service.submit(dummy::testSync);
                service.submit(dummy::withoutSync);
            }

        } finally {
            if (service != null) {
                service.shutdown();
            }
        }

    }
}

class Dummy {
    private final AtomicInteger atomic = new AtomicInteger(0);
    private int notAtomic = 0;

    public void updateNotAtomicAndShow() {
        System.out.println("Atomic: " + atomic.incrementAndGet() + " Not atomic: " + ++notAtomic);
    }

    public void testSync() {
        synchronized (Dummy.class) {
            System.out.println("With sync, thread id: " + Thread.currentThread().getId());
        }
    }

    public void withoutSync() {
            System.out.println("Without  sync, thread id: " + Thread.currentThread().getId());
    }
}
