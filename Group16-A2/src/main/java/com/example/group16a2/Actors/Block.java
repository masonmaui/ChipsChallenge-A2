package com.example.group16a2.Actors;

public class Block extends Independent {
    private String block;

    public Block(String block, int[] position, String name) {
        super(position, name);
        this.block = block;

    }

    //default constructor
    public Block(){
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
