package com.draznin.ocp.chapter1.overloading;

public interface Human {

    public static void staticPrint(String text) {
        System.out.println(text);
    }

    public default void print(String text) {
        System.out.println(text);
    }
}
