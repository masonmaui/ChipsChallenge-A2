package com.example.group16a2.Tiles;

public class Water extends Tile{

    private String filename;
    public Water(boolean isInteractable) {
        super(isInteractable , "water.png");
        filename = "water.png";
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
