package com.draznin.ocp.chapter3.collections;

import java.util.*;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Stream;

public class Test {

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();

        //common collection methods
        boolean b = list.add("Test");
        boolean r = list.remove("test");
        int size = list.size();
        boolean e = list.isEmpty();
        list.clear();
        boolean c = list.contains("Test");

        // list methods
        list.add(0, "Test");
        list.add(1, "Test");
        list.add(2, "Test");
        list.add(3, "Test");
        String value = list.remove(0);
        String getValue = list.get(0);
        int index = list.indexOf("Test");
        int lastIndex = list.lastIndexOf("Test");
        String replacement = list.set(0, "Test 2");

        list.removeIf(s -> s.contains("2"));
        list.replaceAll(String::toLowerCase);

        //Set
        Set<String> treeSet = new TreeSet<>(); // Unique values in natural order. Use red-black tree.
        Set<String> hashSet = new HashSet<>(); // Unique values unordered. Use hash table. Load factor = 0.75, initial capacity = 16

        //Tree set implements navigable interface. Methods:
        NavigableSet<String> navigableSet = new TreeSet<>();
        navigableSet.lower("a"); // ? < a or null
        navigableSet.floor("a"); // ? <= a or null
        navigableSet.ceiling("a"); // ? >= a or null
        navigableSet.higher("a"); // ? > a or null

        Comparator<Car> speedComparator = new Comparator<Car>() {

            @Override
            public int compare(Car o1, Car o2) {
                return o1.getSpeed() - o2.getSpeed();
            }
        };

        //Queue
        ArrayDeque<String> arrayDeque = new ArrayDeque<>();
        boolean a1 = arrayDeque.add("Test"); //Add to end or throw Exception
        String a2 = arrayDeque.element(); // Return next element ot throw exception
        String a4 = arrayDeque.remove(); // Remove next element or throws Exception;

        boolean a3 = arrayDeque.offer("Test"); // Add to end or return false
        String a5 =  arrayDeque.poll(); // Remove next element and return it, or return null if queue is empty
        String a8 = arrayDeque.peek(); // Return next element or null if empty

        arrayDeque.push("Test"); // Add to front (Stack)
        String a7 = arrayDeque.pop(); // Remove next element or throws exception (Stack) (Not queue)
        String a6 = arrayDeque.peek(); // Return next element or null if empty (Stack)

        //Map
        HashMap<String, String> hashMap = new HashMap<>();
        TreeMap<String, String> treeMap = new TreeMap<>();

        String mapValue = hashMap.put("Key", "Value"); //Return previous value or null
        boolean isEmpty = hashMap.isEmpty();
        int mapSize = hashMap.size();
        String valueByKey = hashMap.get("Key");
        String removedValue = hashMap.remove("Key");
        hashMap.clear();
        boolean containsKey = hashMap.containsKey("Key");
        boolean containsValue = hashMap.containsValue("Value");
        Set<String> keys = hashMap.keySet();
        Collection<String> values = hashMap.values();
        String putIfAbsent = hashMap.putIfAbsent("Key", "Value");
        String merge = hashMap.merge("Key", "value2", (s1, s2) -> s1.length() > s2.length() ? s1 : s2);
        String ifAbsent = hashMap.computeIfAbsent("Key", (s1) -> {return s1 + "Test";});
        String ifPresent = hashMap.computeIfPresent("Key", (k, v) -> v + k);


        // Sorting and search
        List<Car> cars = Arrays.asList(new Car(10, 20), new Car(20, 10));
        Collections.sort(cars); //Compile only if comparable interface implemented
        Collections.sort(cars, speedComparator); // Can compile without comparable interface
        int indexBySearch = Collections.binarySearch(cars, new Car()); //collection should be sorted and element implement comparable

        // Method reference
        BiConsumer<Car, Integer> staticReference = Car::increasePrice; // Static method

        Car car = new Car(10, 15);
        Predicate<Car> carPredicate = car::equals; //instance method

        Predicate<Car> sportCarPredicate = Car::isSportCar; // runtime instance method

        Supplier<Car> carSupplier = Car::new; // constructor
    }

    static class Node {

        private int salt;

        public Node() {
        }

        public Node(int salt) {
            this.salt = salt;
        }

        @Override
        public int hashCode() {
            return salt;
        }

        @Override
        public boolean equals(Object o) {
            return false;
        }
    }
}
