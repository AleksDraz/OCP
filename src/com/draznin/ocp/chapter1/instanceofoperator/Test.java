package com.draznin.ocp.chapter1.instanceofoperator;

/**
 *  Test class show relations between interface super class and subclass and their type comparison.
 * */
public class Test {

    public static void main(String[] args) {
        Child child = new Child();

        System.out.println(child instanceof Child); //true
        System.out.println(child instanceof Parent); //true
        System.out.println(child instanceof Human); //true

        Parent parentChild = new Child();

        System.out.println(parentChild instanceof Child); //true
        System.out.println(parentChild instanceof Parent); //true
        System.out.println(parentChild instanceof Human); //true

        Human humanChild = new Child();

        System.out.println(humanChild instanceof Child); //true
        System.out.println(humanChild instanceof Parent); //true
        System.out.println(humanChild instanceof Human); //true

        Parent parent = new Parent();

        System.out.println(parent instanceof Child); //false
        System.out.println(parent instanceof Parent); //true
        System.out.println(parent instanceof Human); //false. Incompatible types between class and interface. Compiler doesn't see it on compile time
        //System.out.println(parent instanceof StarLord); Inconvertible types between 2 classes. Compiler see it on compile time
    }
}
