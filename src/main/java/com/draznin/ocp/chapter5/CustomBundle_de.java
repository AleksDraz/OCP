package com.draznin.ocp.chapter5;

import java.util.ListResourceBundle;

public class CustomBundle_de extends ListResourceBundle {

    @Override
    protected Object[][] getContents() {
        Object[][] objects = new Object[][] {
                {"hello", "guten tag"}, {"how are you?", "wie gehts es dir?"}, {"bye", "aufwiedersehen"}
        };
        return objects;
    }
}
