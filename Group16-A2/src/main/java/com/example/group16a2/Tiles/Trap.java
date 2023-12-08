package com.example.group16a2.Tiles;

public class Trap extends Tile {

    private String filename;

    public Trap(boolean isPassable) {
        super(isPassable, "file:Sprites/Trap.png");
        filename = "file:Sprites/Trap.png";
    }

    //get file name
    public String getFileName() {
        return filename;
    }

    //to string
    public String toString() {
        return "Trap";
    }
}
