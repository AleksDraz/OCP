package com.draznin.ocp.chapter3.bounds;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Test {

    public static void main(String[] args) {
        List<?> unboundedList = new ArrayList<>();
        //unboundedList.add("test"); incompatible types: java.lang.String cannot be converted to capture#1 of ?

        List<String> stringList = Arrays.asList("Cat", "Dog");
        printUnbounded(stringList);
        //printUpperBounded(stringList); not compile. can apply only ? extends Number
        //printLowerBounded(stringList); not compile. can apply only ? super Integer

        List<Integer> integerList = Arrays.asList(1, 2);
        printUnbounded(integerList);
        printUpperBounded(integerList); //here is ok
        printLowerBounded(integerList); //here is ok
    }

    private static void printUnbounded(List<?> list) {
        //list.add(100); not possible. it can be so, that as param will be applied List<String>
        list.forEach(System.out::println);
    }

    private static void printUpperBounded(List<? extends Number> list) { // can extends interface
        //list.add(100); not possible. it can be so, that as param will be applied List<Float>
        list.forEach(System.out::println);
    }

    private static void printLowerBounded(List<? super Integer> list) { // can super interface
        list.add(100); //it's ok. Only Integer or super class like Number can be applied.
        list.forEach(System.out::println);
    }
}
