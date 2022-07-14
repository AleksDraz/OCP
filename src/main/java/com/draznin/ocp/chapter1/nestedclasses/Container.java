package com.draznin.ocp.chapter1.nestedclasses;

public class Container {

    private String instanceVariable = "instance variable";
    private static String staticVariable = "static variable";
    private final MemberInnerClass memberInnerClass;

    public Container() {
        memberInnerClass = new MemberInnerClass();
    }

    public void printMemberInnerClass() {
        System.out.println(memberInnerClass.memberInnerClassInstanceVariable); //has access to private instance variable
        System.out.println(MemberInnerClass.memberInnerClassStaticVariable); //has access to private static variable
    }

    public void testAnonymousInnerClass() {
        Anonymous anonymous = new Anonymous() {

            @Override
            public void print() {
                System.out.println("I'm anonymous");
            }
        };
    }

    public void testLocalInnerClass() {
        int outOfLocalClassVariable = 1;
        outOfLocalClassVariable++;
        class LocalInnerClass { //Scope of visibility only method of declaration
            private final String localInnerClassInstanceVariable = "local Inner Class Instance Variable";

            // Illegal static declaration in inner class(for method the same)
            //because those inner classes are "instance" inner classes. That is, they are like an instance attribute of the enclosing object and dependent on enclosing class.
           // private static String staticVariable = "static variable";
            public void printInstanceVariable() {
                System.out.println(Container.this.instanceVariable); // has access to private instance variable
            }

            public void printStaticVariable() {
                System.out.println(Container.staticVariable); // has access to private static variable
            }

            public void printLocalVariable() {
             //   System.out.println(outOfLocalClassVariable); // variable out of class should be final or effectively final
            }
        }

        String localInnerClassInstanceVariable = new LocalInnerClass().localInnerClassInstanceVariable; // has access to private variable

    }

    public class MemberInnerClass {

        private final String  memberInnerClassInstanceVariable = "member inner class instance variable";
        //private static String memberInnerClassStaticVariable = "member inner class static variable";
        // Illegal static declaration in inner class(for method the same)
        //because those inner classes are "instance" inner classes. That is, they are like an instance attribute of the enclosing object and dependent on enclosing class.
        private final static String memberInnerClassStaticVariable = "member inner class FINAL static variable"; // For constant static is ok

        public void printInstanceVariable() {
            System.out.println(Container.this.instanceVariable); // has access to private instance variable
        }

        public void printStaticVariable() {
            System.out.println(Container.staticVariable); // has access to private static variable
        }
    }

    public static class StaticInnerClass {

        public void printInstanceVariable() {
      //      System.out.println(Container.this.instanceVariable); // has no access to private INSTANCE variable
            throw new UnsupportedOperationException("has no access to private INSTANCE variable");
        }

        public void printStaticVariable() {
            System.out.println(Container.staticVariable); // has access to private static variable
        }
    }

    private interface Anonymous {
        void print();
    }
}
