package com.draznin.ocp.chapter3.generic;

public class Container <E>{



    private final E [] value;

    @SafeVarargs
    public Container(E ... value) {
        this.value = value;
    }

    public E getByIndex(int index) {
        return value[index];
    }
}
