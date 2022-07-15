package com.draznin.ocp.chapter6;

public class Book implements AutoCloseable{

    @Override
    public void close() throws Exception {
        System.out.println("book is closed");
    }
}
