package com.draznin.ocp.chapter1.equalsandhashcode;

public class Alien {

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

        if (!(object instanceof Alien)) {
            return false;
        }

        Alien alien = (Alien) object;

        return alien.getLastName().equals(this.lastName) && alien.getName().equals(this.name);
    }

    @Override
    public int hashCode() {
        return lastName.hashCode() + name.hashCode();
    }
}
