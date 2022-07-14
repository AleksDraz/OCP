package com.draznin.ocp.chapter1.enumdefinition;

import java.io.Serializable;

/**
 * There should only be one instance of each of the values of your enum in memory.
 * A reference to the enum then requires only the storage for that reference.
 * Checking the value of an enum is as efficient as any other reference comparison.
 *
 * After compilation in will look so:
 *
 * public final class WeekDay extends java.lang.Enum{
 *     public static final Constants MONDAY;
 *     public static final Constants TUESDAY;
 *     public static final Constants WEDNESDAY;
 *     ...
 *     public static WeekDay[] values();
 *     public static WeekDay valueOf(java.lang.String);
 *     static {};
 *     ...
 * }
 *
 * init of days will be in static block. It will be the same operation as for common object.
 * */
public enum WeekDay implements Serializable { // Enum can implement interfaces!

    MONDAY(1) {

        @Override
        public void printPlan() {
            if (isWorkDay()) {
                System.out.println("Go to work!");
            }
        }
    },
    TUESDAY(2) {

        @Override
        public void printPlan() {
            if (isWorkDay()) {
                System.out.println("Read book");
            }
        }
    },
    WEDNESDAY(3) {

        @Override
        public void printPlan() {
            if (isWorkDay()) {
                System.out.println("Got to gym");
            }
        }
    },
    THURSDAY(4) {

        @Override
        public void printPlan() {
            if (isWorkDay()) {
                System.out.println("Sleep full day");
            }
        }
    },
    FRIDAY(5) {

        @Override
        public void printPlan() {
            if (isWorkDay()) {
                System.out.println("Watch tv");
            }
        }
    },
    SATURDAY(6) {

        @Override
        public void printPlan() {
            if (isWorkDay()) {
                System.out.println("Meet with friends");
            }
        }

        @Override
        public boolean isWorkDay() {
            return false;
        }
    },
    SUNDAY(7) {

        @Override
        public void printPlan() {
            if (isWorkDay()) {
                System.out.println("Nothing");
            }
        }

        @Override
        public boolean isWorkDay() {
            return false;
        }
    };

    private WeekDay(int numberOfDay) {
        this.numberOfDay = numberOfDay;
    }

    private final int numberOfDay;

    public boolean isOddDay () {
        return numberOfDay % 2 == 0;
    }

    public boolean isWorkDay() {
        return true;
    }

    // Abstract methods can't have body! And should be overridden in all members of enum.
    public abstract void printPlan();

    private static class NestedClass { // enum can contain nested class!

    }

    private final static String SOME_CONSTANT = null; // enum can contain static variables

}
