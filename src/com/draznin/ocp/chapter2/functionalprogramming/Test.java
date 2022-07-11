package com.draznin.ocp.chapter2.functionalprogramming;

import java.util.function.BiPredicate;
import java.util.function.Predicate;

public class Test {

    public static void main(String[] args) {
        Car car = new Car(101);
        checkSpeed(c -> c.getSpeed() > 100, car);
        Car car2 = new Car(99);
        checkSpeed(c -> c.getSpeed() > 100, car2);

        Predicate<Car> lambda1 = c -> false;
        Predicate<Car> lambda2 = c -> {return false;};
        Predicate<Car> lambda3 = (c) -> false;
        Predicate<Car> lambda4 = (Car c) -> false; //brackets are required
        BiPredicate<String, Car> lambda5 = (s, c) -> false; //brackets are required
        BiPredicate<String, Car> lambda6 = (String s, Car c) -> false; //brackets are required and types for both are required
    }

    private static void checkSpeed(Speed speed, Car car) { //method should receive the same param as declared in lambda(here it's Car)
        if (speed.isFaster(car)) {
            System.out.println("It's very fast");
        } else {
            System.out.println("To slow");
        }
    }
}
