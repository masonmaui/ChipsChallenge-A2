package com.example.group16a2.Tiles;

/**
 * Water.java
 * This class represents the tile that is associated with
 * water in the game.
 * @author Mason Emery
 * @version 1.6
 */
public class Water extends Tile{

    private String filename;
    public Water(boolean isPassable) {
        super(isPassable , "file:Sprites/Water.png");
        filename = "file:Sprites/Water.png";
    }

    //get file name
    public String getFileName() {
        return filename;
    }

    //to string
    public String toString() {
        return "Water";
    }
}
