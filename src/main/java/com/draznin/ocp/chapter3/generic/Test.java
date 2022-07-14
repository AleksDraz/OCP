package com.draznin.ocp.chapter3.generic;

public class Test {

    public static void main(String[] args) {
        Container<String> container = new Container<>("Cat", "Dog");
        System.out.println(container.getByIndex(0));
    }
}
