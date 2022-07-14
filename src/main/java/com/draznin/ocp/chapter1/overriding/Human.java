package com.draznin.ocp.chapter1.overriding;

public interface Human {

    public static String staticPublicVariable = "Static human public variable";

    public static String getStaticPublicVariable() {
        return staticPublicVariable;
    }

    public default String getPublicVariable() {
        return "Human public variable";
    }

    public static void testOverrideNonStaticInInterface() {

    }

    public default void testOverrideDefaultInInterface() {

    }
}
