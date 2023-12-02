package com.example.group16a2.Tiles;

public class Trap extends Tile {

    private String filename;

    public Trap(boolean isInteractable) {
        super(isInteractable);
        filename = "trap.png";
    }

    //to string
    public String toString() {
        return "Trap";
    }
}
