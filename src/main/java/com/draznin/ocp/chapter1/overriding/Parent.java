package com.draznin.ocp.chapter1.overriding;

public class Parent {

    private String privateVariable = "Parent private variable";
    private static String staticPrivateVariable = "Static parent private variable";

    public String publicVariable = "Parent public variable";
    public static String staticPublicVariable = "Static parent public variable";

    private String getPrivateVariable() {
        return privateVariable;
    }

    public String getPublicVariable() {
        return publicVariable;
    }

    public static String getStaticPublicVariable() {
        return staticPublicVariable;
    }

    public static void print() {
        System.out.println("I'm parent.");
    }

    private static String getStaticPrivateVariable() {
        return staticPrivateVariable;
    }

    public void testOverrideDefaultInClass() {

    }

    public static void testOverrideStaticInClass() {

    }
}
