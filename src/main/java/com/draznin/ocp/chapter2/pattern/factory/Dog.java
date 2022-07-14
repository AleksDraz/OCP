package com.draznin.ocp.chapter2.pattern.factory;

public class Dog implements Animal{
    @Override
    public void sound() {
        System.out.println("Woof");
    }
}
