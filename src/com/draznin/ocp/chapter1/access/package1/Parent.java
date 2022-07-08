package com.draznin.ocp.chapter1.access.package1;

public class Parent {

    private int privateVariable;
    protected int protectedVariable;
    int privatePackageVariable;
    public int publicVariable;

    private int privateMethod() {
        return privateVariable;
    }

    protected int protectedMethod() {
        return protectedVariable;
    }

    int privatePackageMethod() {
        return privatePackageVariable;
    }

    public int publicMethod() {
        return publicVariable;
    }
}
