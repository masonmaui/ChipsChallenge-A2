package com.example.group16a2.Tiles;

public class Exit extends Tile {

    private String filename;

    public Exit(boolean isInteractable) {
        super(isInteractable);
        filename = "exit.png";
    }

    //to string
    public String toString() {
        return "Exit";
    }
}
