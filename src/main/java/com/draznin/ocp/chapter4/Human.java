package com.draznin.ocp.chapter4;

import java.util.HashSet;
import java.util.Set;

public class Human {
    private String name;
    private int realAge;
    private Set<String> hobby = Set.of("Sport", "Games", "Study");


    public Human() {

    }

    public Human(String name, int realAge) {
        this.name = name;
        this.realAge = realAge;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRealAge() {
        return realAge;
    }

    public void setRealAge(int realAge) {
        this.realAge = realAge;
    }

    public static Integer getAge() {
        return 0;
    }

    public Integer getHeight() {
        return 190;
    }

    public void setName(String lastName, String firstName) {
        this.name = firstName + " " + lastName;
    }

    public static String sayWord(String word) {
        return word;
    }

    public Human addPrefix(String prefix) {
        name = prefix + " " + name;
        return this;
    }

    public Human doNothing() {
        return this;
    }

    public Human doNothingWith(Human human) {
        return this;
    }

    public boolean isMan() {
        return false;
    }

    public boolean isOlderThan(Integer age) {
        return false;

    }

    public Set<String> getHobby() {
        return hobby;
    }

    @Override
    public String toString() {
        return "Human{" +
                "name='" + name + '\'' +
                ", realAge=" + realAge +
                '}';
    }
}
