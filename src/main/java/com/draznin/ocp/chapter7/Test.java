package com.draznin.ocp.chapter7;

import java.awt.*;
import java.time.LocalTime;
import java.util.*;
import java.util.List;
import java.util.concurrent.*;
import java.util.stream.Stream;

import static java.util.concurrent.TimeUnit.SECONDS;

public class Test {

    public static void main(String[] args) throws InterruptedException, ExecutionException, TimeoutException {
        List<SimpleRun> simpleRuns = Arrays.asList(new SimpleRun(1), new SimpleRun(6),
                new SimpleRun(2), new SimpleRun(3), new SimpleRun(4), new SimpleRun(5));
        Set<Thread> threads = new HashSet<>();

        Iterator<SimpleRun> iterator = simpleRuns.iterator();
        while(iterator.hasNext()) {
            SimpleRun simpleRun = iterator.next();
            Thread thread = new Thread(simpleRun);
            if (simpleRun.getNumber() % 2 == 0) {
                thread.setPriority(Thread.MAX_PRIORITY);
            } else {
                thread.setPriority(Thread.MIN_PRIORITY);
            }

            threads.add(thread);
        }
        threads.forEach(Thread::start);
        Thread.sleep(1000);
        System.out.println("---------------------------");

        ExecutorService executorService = null;
        try {
            executorService = Executors.newSingleThreadExecutor();
            executorService.execute(() -> Stream.generate(() -> Math.random()*100).limit(10).forEach(System.out::println));
        } finally {
            if (executorService != null) {
                Thread.sleep(1000);
                System.out.println("Before shutdown");
                System.out.println(executorService.isShutdown());
                System.out.println(executorService.isTerminated());
                executorService.shutdown();
                System.out.println("After shutdown");
                System.out.println(executorService.isShutdown());
                System.out.println(executorService.isTerminated());
            }
        }
        Thread.sleep(1000);
        System.out.println("---------------------------");

        ExecutorService executorService2 = null;
        try {
            executorService2 = Executors.newSingleThreadExecutor();
            Future<Double> doubleFuture = executorService2.submit(() -> Stream.generate(() -> Math.random()*100).limit(2).peek(System.out::println) //Callable task
                    .max(Comparator.comparingDouble(d -> d)).get());
            Future<?> doubleFuture1 = executorService2.submit(() -> Stream.generate(() -> Math.random()*100).limit(2).forEach(System.out::println)); //Runnable task
            if (doubleFuture.isDone()) {
                System.out.println("Result is: " + doubleFuture.get());
            } else {
                System.out.println("Result not done yet");
            }

        } finally {
            if (executorService2 != null) {
                executorService2.shutdown();
            }
        }

        Thread.sleep(1000);
        System.out.println("---------------------------");
        ExecutorService executorService3 = null;

        try {
            executorService3 = Executors.newSingleThreadExecutor();
            List<Future<Double>> futures = executorService3.invokeAll(Set.of(Math::random, Math::random, Math::random));
            futures.forEach(f -> {if (f.isDone()) {
                try {
                    System.out.println(f.get());
                } catch (InterruptedException | ExecutionException e) {
                    e.printStackTrace();
                }
            }});

        } finally {
            if (executorService3 != null) {
                executorService3.shutdown();
            }
        }

        Thread.sleep(1000);
        System.out.println("---------------------------");
        ExecutorService executorService4 = null;

        try {
            executorService4 = Executors.newSingleThreadExecutor();
            Double result = executorService4.invokeAny(Set.of(Math::random, Math::random, Math::random));
            System.out.println(result);
        } finally {
            if (executorService4 != null) {
                executorService4.shutdown();
            }
        }

        Thread.sleep(1000);
        System.out.println("---------------------------");
        ScheduledExecutorService executorService5 = null;

        try {
            executorService5 = Executors.newSingleThreadScheduledExecutor();
            executorService5.schedule(() -> System.out.println("Runnable with delay 2"), 2, SECONDS);
            Future<String> stringFuture = executorService5.schedule(() -> "Callable with delay 2", 2, SECONDS);
            System.out.println(stringFuture.get(3, SECONDS));
        } finally {
            if (executorService5 != null) {
                executorService5.shutdown();
            }
        }

        Thread.sleep(1000);
        System.out.println("---------------------------");
        ScheduledExecutorService executorService6 = null;
        ScheduledExecutorService executorService7 = null;

        try {
            executorService6 = Executors.newSingleThreadScheduledExecutor();
            executorService7 = Executors.newSingleThreadScheduledExecutor();
            executorService6.scheduleWithFixedDelay(() -> {
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("Runnable with delay 2");
                }, 0, 1, SECONDS); // With delay
            // between end and begin of operation
            executorService7.scheduleAtFixedRate(() -> {System.out.println("Runnable with period 2");
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }}, 0, 1, SECONDS); // With strong period
            // between end and begin of operation
            Thread.sleep(8000);
        } finally {
            if (executorService6 != null) {
                executorService6.shutdown();
            }

            if (executorService7 != null) {
                executorService7.shutdown();
            }
        }

        Thread.sleep(1000);
        System.out.println("---------------------------");

        ExecutorService executorService8 = null;
        ExecutorService executorService9 = null;
        ExecutorService executorService10 = null;

        try {
            executorService8 = Executors.newCachedThreadPool();
            executorService10 = Executors.newFixedThreadPool(2);
            executorService9 = Executors.newSingleThreadExecutor();
            List<Future<String>> listSingle = executorService9.invokeAll(Arrays.asList(() -> {Thread.sleep(1000); return "(Single)Start time: " + LocalTime.now().getNano();},
                    () -> {Thread.sleep(1000); return "(Single)Start time: " + LocalTime.now().getNano();},
                    () -> {Thread.sleep(1000); return "(Single)Start time: " + LocalTime.now().getNano();}));
            List<Future<String>> list = executorService8.invokeAll(Arrays.asList(() -> {Thread.sleep(1000); return "Start time: " + LocalTime.now().getNano();},
                    () -> {Thread.sleep(1000); return  "Start time: " + LocalTime.now().getNano(); },
                    () -> {Thread.sleep(1000); return  "Start time: " + LocalTime.now().getNano();}));
            executorService10.invokeAll(Arrays.asList(() -> {list.forEach(f -> {
                if (f.isDone()) {
                    try {
                        System.out.println(f.get());
                    } catch (InterruptedException | ExecutionException e) {
                        e.printStackTrace();
                    }
                } else {
                    try {
                        f.get(2, SECONDS);
                    } catch (InterruptedException | ExecutionException | TimeoutException e) {
                        e.printStackTrace();
                    }
                }
            }); return null; }, () -> {listSingle.forEach(f -> {
                if (f.isDone()) {
                    try {
                        System.out.println(f.get());
                    } catch (InterruptedException | ExecutionException e) {
                        e.printStackTrace();
                    }
                } else {
                    try {
                        f.get(2, SECONDS);
                    } catch (InterruptedException | ExecutionException | TimeoutException e) {
                        e.printStackTrace();
                    }
                }
            }); return null; }));
        } finally {
            if (executorService8 != null) {
                executorService8.shutdown();
            }

            if (executorService9 != null) {
                executorService9.shutdown();
            }

            if (executorService10 != null) {
                executorService10.shutdown();
            }
        }
    }
}
