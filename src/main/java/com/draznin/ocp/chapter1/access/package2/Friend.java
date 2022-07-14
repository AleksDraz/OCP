package com.draznin.ocp.chapter1.access.package2;


import com.draznin.ocp.chapter1.access.package1.Parent;

/**
 * Friend class NOT extend parent class in the same package.
 * */
public class Friend {

    public void testAccess() {
        Parent parent = new Parent();

        // Only public method is accessible
        //parent.privatePackageMethod();
        //parent.protectedMethod();
        parent.publicMethod();

        // Only public variable is accessible
        // int privatePackageVariable = parent.privatePackageVariable;
        // int protectedVariable = parent.protectedVariable;
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
