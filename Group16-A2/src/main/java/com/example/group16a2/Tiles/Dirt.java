package com.example.group16a2.Tiles;

public class Dirt extends Tile {

    private String filename;

    public Dirt(boolean isInteractable) {
        super(isInteractable);
        filename = "dirt.png";
    }

    //to string
    public String toString() {
        return "Dirt";
    }
}