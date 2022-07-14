package com.draznin.ocp.chapter2.pattern;

public class StaticInitSingleton {

    private final static StaticInitSingleton INSTANCE;
   // private final static StaticInitSingleton INSTANCE = new StaticInitSingleton(); It can be so, but with static block we
    // can add some logic for init.

    private StaticInitSingleton() {

    }

    static  {
        INSTANCE = new StaticInitSingleton();
    }

    public static StaticInitSingleton getInstance() {
        return INSTANCE;
    }
}
