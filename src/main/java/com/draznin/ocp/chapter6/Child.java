package com.draznin.ocp.chapter6;

import java.io.IOException;

public class Child extends Parent{

    @Override
    public void testException()  { //throws not required

    }

    @Override
    public void testException2() /*throws Exception*/ { // If in parent was no throws exception then in child should be the same

    }

    @Override
    public void testException3() /*throws Exception*/ { // Exception in child should be the same or subclass

    }
}
