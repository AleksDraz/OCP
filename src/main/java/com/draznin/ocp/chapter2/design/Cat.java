package com.draznin.ocp.chapter2.design;

/**
 * Animal -> Cat is "Is-a" relationship
 * Cat -> Tooth is "Has-a" relationship
 *
 * */
public class Cat extends Animal{

    private final Tooth tooth;
    private final Claw claw;

    public Cat(Tooth tooth, Claw claw) {
        this.tooth = tooth;
        this.claw = claw;
    }

    public void defend() {
        tooth.bite();
        claw.scratch();
    }
}
