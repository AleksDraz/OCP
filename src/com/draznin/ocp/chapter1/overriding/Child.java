package com.draznin.ocp.chapter1.overriding;


/**
 * Child class extend parent class and implements Human class.
 * */
public class Child extends Parent implements Human {

    private String privateVariable = "Child private variable";
    public static String staticPrivateVariable = "Static Child private variable";

    public String publicVariable = "Child public variable";
    public static String staticPublicVariable = "Static Child public variable";

    private String getPrivateVariable() {
        return privateVariable;
    }

    public String getPublicVariable() {
        return publicVariable;
    }

    public static String getStaticPublicVariable() {
        return staticPublicVariable;
    }

    private static String getStaticPrivateVariable() {
        return staticPrivateVariable;
    }

    public void testOverrideNonStaticInInterface() { }// Instance method doesn't override static method from interface and there is no compile error

   // public static void testOverrideDefaultInInterface() { }// Static method can't override default method from interface and there is compile error

   // public static void testOverrideDefaultInClass() { } // Static method can't override default method from super class and there is compile error

   //  public void testOverrideStaticInClass() { } // Instance method can't override static method from super class and there is
    //  compile error. It is difference between overriding in interface and super class!

}
