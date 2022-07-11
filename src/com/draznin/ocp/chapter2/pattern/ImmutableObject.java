package com.draznin.ocp.chapter2.pattern;

import java.util.ArrayList;
import java.util.List;

public final class ImmutableObject {

    private final String name;
    private final List<Thing> things;

    public ImmutableObject(String name, List<Thing> things) {
        this.name = name;
        if (things == null) {
            throw new RuntimeException("things is null");
        }
        this.things = new ArrayList<>(things);
    }

    public List<Thing> getThings() {
        return new ArrayList<>(things);
    }

    public Thing getThing(int index) {
        return new Thing(things.get(index).getA(), things.get(index).getB());
    }

    public class Thing {

        private int a;
        private int b;

        public Thing(int a, int b) {
            this.a = a;
            this.b = b;
        }

        public int getA() {
            return a;
        }

        public void setA(int a) {
            this.a = a;
        }

        public int getB() {
            return b;
        }

        public void setB(int b) {
            this.b = b;
        }
    }
}
