package com.draznin.ocp.chapter2.pattern.factory;

public class Lion implements Animal{
    @Override
    public void sound() {
        System.out.println("Roar");
    }
}
