package com.draznin.ocp.chapter7;

public class SimpleRun implements Runnable{

    private int number;

    public SimpleRun(int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }

    @Override
    public void run() {
        System.out.println("Hi, my number is: " + number);
    }
}
