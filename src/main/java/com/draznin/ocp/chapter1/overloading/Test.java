package com.draznin.ocp.chapter1.overloading;


import com.draznin.ocp.chapter1.overriding.Human;
import com.draznin.ocp.chapter1.overriding.Parent;

/**
 * Test class show overloading logic. Static method can be also "overloaded".
 * */
public class Test {

    public static void main(String[] args) {
        Child child = new Child();
        child.print(new Object());
        child.print("String");
        child.print(123);
    }
}
