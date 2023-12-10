package com.example.group16a2.Actors;

import com.example.group16a2.Tiles.LockedDoorBlue;
import com.example.group16a2.Tiles.LockedDoorGreen;
import com.example.group16a2.Tiles.LockedDoorRed;
import com.example.group16a2.Tiles.LockedDoorYellow;
import com.example.group16a2.Tiles.Tile;
import com.example.group16a2.Tiles.TileLayer;
import com.example.group16a2.Tiles.Wall;

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


    public void push(String direction, Tile[][] grid, Actor[][] actors) {
        int deltaX = 0;
        int deltaY = 0;

        // Determine the change in position based on the direction
        switch (direction) {
            case "UP":
                deltaY = -1;
                break;
            case "DOWN":
                deltaY = 1;
                break;
            case "LEFT":
                deltaX = -1;
                break;
            case "RIGHT":
                deltaX = 1;
                break;
            default:
                return;
        }

        int newX = getX() + deltaX;
        int newY = getY() + deltaY;

        // Check if the new position is within the bounds of the layer
        if (newX >= 0 && newX < actors.length && newY >= 0 && newY < actors[0].length) {
            // Check if the new position is empty and not blocked by a wall
            if (grid[newY][newX] == null || !(grid[newY][newX] instanceof Wall) || !(grid[newY][newX] instanceof LockedDoorBlue) || 
                !(grid[newY][newX] instanceof LockedDoorGreen) ||!(grid[newY][newX] instanceof LockedDoorRed) ||!(grid[newY][newX] instanceof LockedDoorYellow) || 
                hasActors(actors[newX][newY])) {
                    
                setPosx(newX);
                setPosy(newY);
            }
        }
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

    //to string
    public String toString(){
        return "Block";
    }
}
