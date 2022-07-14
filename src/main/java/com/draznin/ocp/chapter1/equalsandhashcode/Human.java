package com.draznin.ocp.chapter1.equalsandhashcode;

public class Human {

    private String name;
    private String lastName;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public boolean equals(Object object) {
        if (object == null) {
            return false;
        }

        if (!(object instanceof Human)) {
            return false;
        }

        Human otherHuman = (Human) object;

        return otherHuman.getLastName().equals(this.lastName) && otherHuman.getName().equals(this.name);
    }

    @Override
    public int hashCode() {
        int h = lastName.hashCode();
        h = h * 31 + name.hashCode();
        return h;
    }
}
