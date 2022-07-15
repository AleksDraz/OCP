package com.draznin.ocp.chapter6;

import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalTime;

public class Test {

    public static void main(String[] args) {

        try {
            testThrowable();
        } catch (CustomThrowable e) {
            e.printStackTrace();
        }

        testError(); // catching not required

        try {
            testException();
        } catch (CustomException e) {
            e.printStackTrace();
        }

        testRuntimeException(); // catching not required
        System.out.println(testFinally ());

        try(Book book = new Book()) {
            System.out.println("book is open");
        } catch (Exception e) {
            e.printStackTrace();
        }
        try (OldBook oldBook = new OldBook()) {
            System.out.println("Old book is open");
            throw new RuntimeException("Exception in try");
        } catch (Exception e) {
            System.out.println(e.getMessage()); // Exception in try
            System.out.println(e.getSuppressed()[0].getMessage()); // Exception in close
        }

        assert !LocalTime.now().isBefore(LocalTime.of(12, 0)): "To early"; // exception will throw if
        // assertion flag will be enabled and time will before 12


    }

    private static void testThrowable() throws CustomThrowable {

    }

    private static void testError() throws CustomError {

    }

    private static void testException() throws CustomException {

    }

    private static void testRuntimeException() throws CustomRuntimeException {

    }

    private static int testFinally () {
        try {
            throw new RuntimeException();
        } catch (Exception e) {
            return 0;
        } finally {
            System.out.println("Finally");
        }
    }

    private static void testCheckedException () throws SQLException {
        try {

        }/* catch (SQLException e) { Checked exception can be catch only if in try possible they throw

        }*/ finally {
            System.out.println("Finally");
        }
    }
}
