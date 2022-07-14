package com.draznin.ocp.chapter1.access.package2;


import com.draznin.ocp.chapter1.access.package1.Parent;

/**
 * Child class extend parent class in the different package.
 * */
public class Child extends Parent {

    public void testAccess() {
        Parent parent = new Parent();

        // Only public method is accessible
        /*parent.privatePackageMethod();
        parent.protectedMethod();*/
        parent.publicMethod();

        // Only public variable is accessible
        /*int privatePackageVariable = parent.privatePackageVariable;
        int protectedVariable = parent.protectedVariable;*/
        int publicVariable = parent.publicVariable;

        // Only public and protected(!!!) methods are accessible. (Private and private package not!!!)
        //this.privatePackageMethod();
        this.protectedMethod();
        this.publicMethod();

        // Only public and protected(!!!) nested fields are accessible. (Private and private package not!!!)
       // int nestedPrivatePackageVariable =  this.privatePackageVariable;
        int nestedProtectedVariable =  this.publicVariable;
        int nestedPublicVariable = this.protectedVariable;
    }
}
