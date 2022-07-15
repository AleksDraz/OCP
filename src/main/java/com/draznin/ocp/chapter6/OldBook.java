package com.draznin.ocp.chapter6;

import java.io.Closeable;
import java.io.IOException;

public class OldBook implements Closeable {

    @Override
    public void close() throws IOException {
        System.out.println("Old book is closed");
        throw new IOException("Exception in close");
    }
}
