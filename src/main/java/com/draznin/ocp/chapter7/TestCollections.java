package com.draznin.ocp.chapter7;

import java.util.*;
import java.util.concurrent.*;
import java.util.stream.Stream;

public class TestCollections {

    public static void main(String[] args) throws InterruptedException {
        Map<Integer, String> hashMap = new HashMap<>();
        hashMap.put(1, "One");
        hashMap.put(2, "Two");

        for (Integer key : hashMap.keySet()) {
            //hashMap.remove(key); ConcurrentModificationException
        }

        Map<Integer, String> concurrentHashMap = new ConcurrentHashMap<>();
        concurrentHashMap.put(1, "One");
        concurrentHashMap.put(2, "Two");

        System.out.println(concurrentHashMap); // {1=One, 2=Two}

        for (Integer key : concurrentHashMap.keySet()) {
            concurrentHashMap.remove(key); // ok
        }

        System.out.println(concurrentHashMap); // {}

        BlockingQueue<String> blockingQueue = new LinkedBlockingQueue<>();
        blockingQueue.offer("test", 10, TimeUnit.SECONDS);
        String result = blockingQueue.poll(10, TimeUnit.SECONDS);

        ConcurrentSkipListSet<String> concurrentSkipListSet = new ConcurrentSkipListSet<>(); // The same as TreeSet
        concurrentSkipListSet.add("Test");
        concurrentSkipListSet.add("Test");
        System.out.println(concurrentSkipListSet); // [Test]

        ConcurrentSkipListMap<String, String> concurrentSkipListMap = new ConcurrentSkipListMap<>(); // The same as TreeMap
        concurrentSkipListMap.put("Test", "test");
        concurrentSkipListMap.put("Test", "test2");
        System.out.println(concurrentSkipListMap); // {Test=test2}

        List<Integer> list = new CopyOnWriteArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);

        int index = 0;
        for (Integer i : list) {
            list.add(i);
            System.out.println(list.get(index++)); // 1, 2, 3
        }

        System.out.println(list); // [1, 2, 3, 1, 2, 3]

        List<String> syncList = Collections.synchronizedList(Arrays.asList("test", "test2"));

        Stream.of(1, 2, 3, 4).unordered().parallel().skip(1).forEach(System.out::println);


    }
}
