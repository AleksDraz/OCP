package com.draznin.ocp.chapter1.equalsandhashcode;

import com.draznin.ocp.chapter1.instanceofoperator.Child;
import com.draznin.ocp.chapter1.instanceofoperator.Parent;

/**
 * Some info about equals and hashcode:
 * - equals and hashcode should dependent on same subset of fields
 * - if equals return true between 2 objects, then hashcode of this should be the same
 * - if equals return false it can be so that hashcode return true
 * - value in fields which used for hashcode should not be changed, it can lead to wrong behaviour in hash collections
 * */
public class Test {

    public static void main(String[] args) {

        Human human = new Human();
        human.setLastName("Snow");
        human.setName("John");

        Human human2 = new Human();
        human2.setLastName("John");
        human2.setName("Snow");

        System.out.println("humans equals: " + human2.equals(human)); // false
        // Example of good hashcode method
        System.out.println("humans hashcode: " + (human2.hashCode() == human.hashCode())); // false

        Alien alien = new Alien();
        alien.setLastName("Snow");
        alien.setName("John");

        Alien alien2 = new Alien();
        alien2.setLastName("John");
        alien2.setName("Snow");

        System.out.println("aliens equals: " + alien2.equals(alien)); // false
        // Example of bad hashcode method
        System.out.println("aliens hashcode: " + (alien2.hashCode() == alien.hashCode())); // true, but equals is false, it can lead
        // to collisions.
    }
}
