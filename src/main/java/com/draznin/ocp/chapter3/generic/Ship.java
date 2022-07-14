package com.draznin.ocp.chapter3.generic;

public class Ship {

    @SafeVarargs
    public static <T> Container<T> load(T... t) {
        return new Container<>(t);
    }
}
