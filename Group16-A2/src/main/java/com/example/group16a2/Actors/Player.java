package com.example.group16a2.Actors;

import com.example.group16a2.MasonMain;
import com.example.group16a2.Tiles.Tile;

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

    //move right
    public void moveRight(Tile[][] tile){
        if (isInBounds(x + 1, y, tile)){
            if (tile[y][x+1].isInteractable() == false){
                x++;
            }
        }
    }

    //is in bounds
    public boolean isInBounds(int x, int y, Tile[][] tile){
        if (x < 0 || x >= tile.length || y < 0 || y >= tile[0].length){
            return false;
        }
        return true;
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
