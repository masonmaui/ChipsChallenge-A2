package com.example.group16a2.Tiles;

public class Dirt extends Tile {

    private String filename;

    public Dirt(boolean isPassaable) {
        super(isPassaable, "file:Sprites/Dirt.png");
        filename = "file:Sprites/Dirt.png";
    }

    //get file name
    public String getFileName() {
        return filename;
    }

    //to string
    public String toString() {
        return "Dirt";
    }
}