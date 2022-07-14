package com.draznin.ocp.chapter1.overloading;


/**
 * Child class extend parent class and implements Human class.
 * */
public class Child extends Parent implements Human {

    public static void print(Object object) {
        System.out.println("Print object");
    }

    public void print(String text) {
        System.out.println("Print string");
    }

    public void print(int number) {
        System.out.println("Print int");
    }

    /* Var args is the same as array and can't be overload param.

    public void print(String ... a) {
        System.out.println(a[0]);
    }

    public void print(String [] a) {
        System.out.println(a[0]);
    }
    */

}
