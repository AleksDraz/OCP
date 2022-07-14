package com.draznin.ocp.chapter1.overriding;

public interface Alien {

    public static String staticPublicVariable = "Static alien public variable";

    public static String getStaticPublicVariable() {
        return staticPublicVariable;
    }

    public default String getPublicVariable() {
        return "Alien public variable";
    }
}
