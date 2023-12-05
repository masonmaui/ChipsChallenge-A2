package com.example.group16a2.Actors;

public class Frog extends Independent {

    private String filename;

    public Frog(String frog, int[] position, String name) {
        super(position, name);

        filename = "frog.png";

    }

    //default constructor
    public Frog(){
    }

    //to string
    public String toString(){
        return "Frog";
    }
}
