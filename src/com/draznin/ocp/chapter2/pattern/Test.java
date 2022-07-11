package com.draznin.ocp.chapter2.pattern;

import com.draznin.ocp.chapter2.pattern.factory.Animal;

public class Test {

    public static void main(String[] args) {
        Target target = new Target.TargetBuilder()
                .a(1)
                .b(2)
                .c(3)
                .build();

        Animal animal = AnimalFactory.getAnimal(AnimalFactory.AnimalType.CAT);
        animal.sound();
    }
}
