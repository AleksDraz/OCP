package com.draznin.ocp.chapter7;

import java.util.Arrays;
import java.util.concurrent.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TestProcesses {

    public static void main(String[] args) throws InterruptedException {
        CyclicBarrier cyclicBarrier = new CyclicBarrier(2, () -> System.out.println("Barrier is full"));
        ExecutorService executorService = Executors.newFixedThreadPool(4);
        try {
            executorService.invokeAll(Arrays.asList(() -> { // if 5 then will be deadlock
                        testBarrier(cyclicBarrier);
                        return null;
                    },
                    () -> {
                        testBarrier(cyclicBarrier);
                        return null;
                    }, () -> {
                        testBarrier(cyclicBarrier);
                        return null;
                    }, () -> {
                        testBarrier(cyclicBarrier);
                        return null;
                    }, () -> {
                        testBarrier(cyclicBarrier);
                        return null;
                    }, () -> {
                        testBarrier(cyclicBarrier);
                        return null;
                    }));
        } finally {
            executorService.shutdown();
        }

        //////////////////// FORK JOIN
        Double[] array =  Stream.generate(() -> Math.random()*100).limit(1000).toArray(Double[]::new);
        ForkJoinTask<?> forkJoinTask = new ForkAction(array);
        ForkJoinPool forkJoinPool = new ForkJoinPool(10);
        forkJoinPool.invoke(forkJoinTask);
        System.out.println("--------------------------------");
        System.out.println("Original array: " + Stream.of(array).map(Double::intValue).map(String::valueOf).collect(Collectors.joining(", ")));
        ForkJoinTask<?> forkJoinTask2 = new ForkTask(array);
        ForkJoinPool forkJoinPool2 = new ForkJoinPool(10);
        System.out.println(forkJoinPool2.invoke(forkJoinTask2));
    }

    private static void testBarrier(CyclicBarrier cyclicBarrier) throws BrokenBarrierException, InterruptedException {
        System.out.println("I'm in. " + Thread.currentThread().getId());
        cyclicBarrier.await();
        System.out.println("I'm in barrier. " + Thread.currentThread().getId());
    }
}
