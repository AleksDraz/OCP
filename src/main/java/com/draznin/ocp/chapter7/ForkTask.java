package com.draznin.ocp.chapter7;

import java.util.Arrays;
import java.util.Set;
import java.util.concurrent.ConcurrentSkipListSet;
import java.util.concurrent.RecursiveTask;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

public class ForkTask extends RecursiveTask<Integer> {

    private final static AtomicInteger count = new AtomicInteger(0);
    private final static AtomicBoolean flag = new AtomicBoolean(true);
    private final Double[] array;
    private final static Set<Integer> threadsId = new ConcurrentSkipListSet<>();

    public ForkTask(Double[] array) {
        this.array = array;
    }

    @Override
    protected Integer compute() {
        threadsId.add(Long.valueOf(Thread.currentThread().getId()).intValue());
        if (array.length <= 4) {
            if (flag.getAndSet(false)) {
                try {
                    Thread.sleep(1000); // for correct count of threads
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("Count of sub tasks: " + count.intValue() + " count of threads: " + threadsId.size());
            }
            return getMin();
        } else {
            count.addAndGet(2);
            RecursiveTask<Integer> otherTask = new ForkTask(Arrays.copyOfRange(array, 0, array.length/2));
            otherTask.fork();
            return Math.min(new ForkTask(Arrays.copyOfRange(array, array.length/2, array.length)).compute(), otherTask.join());
        }
    }

    private Integer getMin() {
        Double min = array[0];
        for (Double aDouble : array) {
            if (aDouble < min) {
                min = aDouble;
            }
        }

        return min.intValue();
    }
}
