package com.draznin.ocp.chapter2.pattern;

public class Target {

    private int a;
    private int b;
    private int c;

    public Target(int a, int b, int c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public static class TargetBuilder {

        private int a;
        private int b;
        private int c;

        public TargetBuilder a(int a) {
            this.a = a;
            return this;
        }

        public TargetBuilder b(int b) {
            this.b = b;
            return this;
        }

        public TargetBuilder c(int c) {
            this.c = c;
            return this;
        }

        public Target build() {
            return new Target(a, b, c);
        }
    }
}
