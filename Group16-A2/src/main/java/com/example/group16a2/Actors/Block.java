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

    //check block is on water
    public void isOnWater(Tile[][] tile,ArrayList<Actor> actors){
        if(tile[y][x] instanceof Water) {
            //if it is set water to be a path
            tile[y][x] = new Path(true);
            //remove block from actors using try catch
            actors.remove(this);
        }
    }

    //is in bounds
    public boolean isInBounds(int x, int y, Tile[][] tile){
        return x >= 0 && x < tile[0].length && y >= 0 && y < tile.length;
    }

    //to string
    public String toString(){
        return "Block";
    }
}
