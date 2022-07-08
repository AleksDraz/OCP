package com.draznin.ocp.chapter1.access.package1;


/**
 * Child class extend parent class in the same package.
 * */
public class Child extends Parent {

    public void testAccess() {
        Parent parent = new Parent();

        // All methods are accessible except private method
        parent.privatePackageMethod();
        parent.protectedMethod();
        parent.publicMethod();

        // All variables are accessible except private variable
        int privatePackageVariable = parent.privatePackageVariable;
        int protectedVariable = parent.protectedVariable;
        int publicVariable = parent.publicVariable;

        // All nested methods are accessible except private method
        this.privatePackageMethod();
        this.protectedMethod();
        this.publicMethod();

        // All nested fields are accessible except private field
        int nestedPrivatePackageVariable =  this.privatePackageVariable;
        int nestedProtectedVariable =  this.publicVariable;
        int nestedPublicVariable = this.protectedVariable;
    }
}
