package com.example.group16a2.Tiles;

public class Water extends Tile{

    private String filename;
    public Water(boolean isInteractable) {
        super(isInteractable);
        filename = "water.png";
    }

    //to string
    public String toString() {
        return "Water";
    }
}
