package com.draznin.ocp.chapter2.functionalprogramming;

@FunctionalInterface
public interface Speed {

    boolean isFaster(Car car); // in functional interface only one abstract method is possible, but unlimited for non abstract

    default void print() {
        System.out.println("Do nothing.");
    }
}
