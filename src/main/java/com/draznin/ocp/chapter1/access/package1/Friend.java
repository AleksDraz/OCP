package com.draznin.ocp.chapter1.access.package1;


/**
 * Friend class NOT extend parent class in the same package.
 * */
public class Friend {

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

        // No nested methods
        /*this.privatePackageMethod();
        this.protectedMethod();
        this.publicMethod();*/

        // No nested fields
        /*int nestedPrivatePackageVariable =  this.privatePackageVariable;
        int nestedProtectedVariable =  this.publicVariable;
        int nestedPublicVariable = this.protectedVariable;*/
    }
}
