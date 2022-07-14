package com.draznin.ocp.chapter1.overriding;

public class StarLord implements Human, Alien{

    /**
     * SHOULD be overridden because Human and Alien have the same default methods.
     * */
    @Override
    public String getPublicVariable() {
        return "StarLord public variable";
    }
}
