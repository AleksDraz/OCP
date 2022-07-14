package com.draznin.ocp.chapter3.generic;

public class Car implements Transportable<Human>{

    @Override
    public void move(Human human) {
        System.out.println("Can move human to some point.");
    }
}
