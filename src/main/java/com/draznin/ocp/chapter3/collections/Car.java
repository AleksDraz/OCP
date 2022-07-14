package com.draznin.ocp.chapter3.collections;

public class Car implements Comparable<Car> {

    private int price;
    private int speed;

    public Car() {
    }

    public Car(int price, int speed) {
        this.price = price;
        this.speed = speed;
    }

    public static int increasePrice(Car car, Integer i) {
        car.setPrice(car.getPrice() + i);
        return car.getPrice();
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public boolean isSportCar() {
        return speed >= 500;
    }

    @Override
    public int compareTo(Car o) {
        return price - o.getPrice();
    }
}
