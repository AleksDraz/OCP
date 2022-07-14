package com.draznin.ocp.chapter2.pattern;

public class LazySingleton {

    private static volatile LazySingleton INSTANCE; //volatile prevents a subtle case
    // where the compiler tries to optimize the code such that the object is accessed before it is finished being constructed

    private LazySingleton() {

    }

    public static LazySingleton getInstance() {
        if (INSTANCE == null) {
            synchronized (LazySingleton.class) {
                if (INSTANCE == null) {
                    INSTANCE = new LazySingleton();
                }
            }
        }

        return INSTANCE;
    }
}
