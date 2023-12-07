package com.example.group16a2.Actors;

public class Frog extends Actor {

    private String filename;

    private int x;
    private int y;

    public Frog(int x, int y){
        super(x, y, "file:Sprites/Frog.png");
        this.filename = "file:Sprites/Frog.png";
        this.x = x;
        this.y = y;
    }

    //to string
    public String toString(){
        return "Frog";
    }
}
