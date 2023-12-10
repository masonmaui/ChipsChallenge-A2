package com.example.group16a2.Actors;

import com.example.group16a2.Tiles.*;

import java.util.ArrayList;

public class Block extends Actor{
    private String block;
    private String filename;
    private int x;
    private int y;
    public Block(int y, int x){
        super(y, x, "file:Sprites/Block.png");
        this.filename = "file:Sprites/Block.png";
        this.x = x;
        this.y = y;
    }

    //get x and y
    public int getX(){
        return x;
    }

    public int getY(){
        return y;
    }

    //moving functions for block
    public void moveUp(){
        y--;
    }

    public void moveDown(){
        y++;
    }

    public void moveLeft(){
        x--;
    }

    public void moveRight() {
        x++;
    }
    private boolean hasActors(Actor tile) {
        return tile != null;
    }

    //check block is on water
    public boolean isOnWater(Tile[][] tile){
        if(tile[y][x] instanceof Water){
            //if it is set water to be a path
            tile[y][x] = new Path(true);
            return true;
        }
        return false;
    }

    //to string
    public String toString(){
        return "Block";
    }
}
