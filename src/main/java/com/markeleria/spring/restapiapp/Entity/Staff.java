package com.markeleria.spring.restapiapp.Entity;

public class Staff {
    public Staff(){
        //empty constructor
    }

    private String name;

    public Staff(String name) {
        this.name = name;
    }

    public String getName(){
        return name;
    }
}
