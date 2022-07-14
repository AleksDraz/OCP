package com.draznin.ocp.chapter2.pattern;

import com.draznin.ocp.chapter2.pattern.factory.Animal;
import com.draznin.ocp.chapter2.pattern.factory.Cat;
import com.draznin.ocp.chapter2.pattern.factory.Dog;
import com.draznin.ocp.chapter2.pattern.factory.Lion;

public class AnimalFactory {

    public static Animal getAnimal(AnimalType type) {
        switch (type) {
            case CAT: return new Cat();
            case DOG: return new Dog();
            case LION: return new Lion();
            default: throw new IllegalArgumentException("Unsupported type");
        }
    }

    enum AnimalType {
        CAT,
        DOG,
        LION
    }
}
