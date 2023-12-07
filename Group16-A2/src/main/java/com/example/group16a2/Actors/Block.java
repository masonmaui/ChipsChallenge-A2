package com.example.group16a2.Actors;

public class Block extends Actor{
    private String block;
    private String filename;
    private int x;
    private int y;
    public Block(int x, int y){
        super(x, y, "file:Sprites/Block.png");
        this.filename = "file:Sprites/Block.png";
        this.x = x;
        this.y = y;
    }

    public void push(){

    }
    
    public void checkPushable(){

    }

    //to string
    public String toString(){
        return "Block";
    }
}
