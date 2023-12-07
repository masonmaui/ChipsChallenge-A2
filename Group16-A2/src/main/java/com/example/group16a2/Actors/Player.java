package com.example.group16a2.Actors;

public class Player extends Actor{
    private String player;
    private int[] inv;

    private String filename;
    private int x;
    private int y;

    public Player(int x, int y){
        super(x, y, "file:Sprites/Actor.png");
        this.filename = "file:Sprites/Actor.png";
        //grab values from super
        this.x = x;
        this.y = y;
    }

    //overide super getx and gety
    public int getX(){
        return x;
    }
    public int getY(){
        return y;
    }
    //set x
    public void setX(int x){
        this.x = x;
    }

    //set y
    public void setY(int y){
        this.y = y;
    }
    public void addItems(int item){
        inv[item]++; 
    }

    //to string
    public String toString(){
        return "Player";
    }
}
