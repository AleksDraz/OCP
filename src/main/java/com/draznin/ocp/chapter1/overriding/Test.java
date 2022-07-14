package com.draznin.ocp.chapter1.overriding;


/**
 * Test class show that static variables and methods are not overridden but hidden. Instance variables depends on class type.
 * Methods depends on instance type. Static methods and variables depends on class type. Static method of interface can be
 * called only on interface qualifier not on instance.
 * */
public class Test {

    public static void main(String[] args) {
        Parent parent = new Parent();

        System.out.println("Parent parent = new Parent();");
        System.out.println(parent.publicVariable); // Parent public variable
        System.out.println(parent.staticPublicVariable); // Static parent public variable
        System.out.println(parent.getPublicVariable()); // Parent public variable
        System.out.println(parent.getStaticPublicVariable()); // Static parent public variable
        System.out.println("---------------------------");

        Child child = new Child();

        System.out.println("Child child = new Child();");
        System.out.println(child.publicVariable); // Child public variable
        System.out.println(child.staticPublicVariable); // Static Child public variable
        System.out.println(child.getPublicVariable()); // Child public variable
        System.out.println(child.getStaticPublicVariable()); // Static Child public variable
        System.out.println("---------------------------");

        Parent parentChild = new Child();

        System.out.println("Parent parentChild = new Child();");
        System.out.println(parentChild.publicVariable); // Parent public variable
        System.out.println(parentChild.staticPublicVariable); // Static parent public variable
        System.out.println(parentChild.getPublicVariable()); // Child public variable
        System.out.println(parentChild.getStaticPublicVariable()); // Static parent public variable
        System.out.println("---------------------------");

        Human humanChild = new Child();

        System.out.println("Human humanChild = new Child();");
        System.out.println(humanChild.getPublicVariable()); // Child public variable
        System.out.println(humanChild.staticPublicVariable); // Static human public variable
        //System.out.println(humanChild.getStaticPublicVariable()); //illegal static interface method call. Possible only with type qualifier.
        System.out.println("---------------------------");
    }
}
