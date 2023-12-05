package com.example.group16a2.Actors;

public class Bug extends Independent {

    private String filename;

    public Bug(String block, int[] position, String name) {
        super(position, name);

        filename = "bug.png";


    }

    //default constructor
    public Bug(){
    }

    public int[] bestPath(){
        return null;
    }

    //to string
    public String toString(){
        return "Bug";
    }
}
