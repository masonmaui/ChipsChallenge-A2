package com.example.group16a2.Actors;

public class Bug extends Actor{

    private String filename;
    private int x;
    private int y;

    public Bug(int x, int y){
        super(x, y, "file:Sprites/BugUp.png");
        this.filename = "file:Sprites/BugUp.png";
        this.x = x;
        this.y = y;
    }

    public int[] bestPath(){
        return null;
    }

    //to string
    public String toString(){
        return "Bug";
    }
}
