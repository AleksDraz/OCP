package com.draznin.ocp.chapter1.nestedclasses;

public class Test {

    public static void main(String[] args) {
        Container container = new Container();
        container.printMemberInnerClass();
        Container.MemberInnerClass memberInnerClass = container.new MemberInnerClass();
        memberInnerClass.printInstanceVariable();

        Container.StaticInnerClass staticInnerClass = new Container.StaticInnerClass();
        staticInnerClass.printStaticVariable();
    }
}
