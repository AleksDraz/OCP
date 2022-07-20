package com.draznin.ocp.chapter7;

import java.util.Arrays;
import java.util.concurrent.RecursiveAction;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class ForkAction extends RecursiveAction{

    private final Double[] array;

    public ForkAction(Double[] array) {
        this.array = array;
    }

    @Override
    protected void compute() {
        if (array.length <= 4) {
            System.out.println("Min value: " + getMin().intValue());
        } else {
            invokeAll(new ForkAction(Arrays.copyOfRange(array, 0, array.length/2)),
                    new ForkAction(Arrays.copyOfRange(array, array.length/2, array.length)));
        }
    }

    private Double getMin() {
        double min = array[0];
        for (Double aDouble : array) {
            if (aDouble < min) {
                min = aDouble;
            }
        }

        return min;
    }
}
