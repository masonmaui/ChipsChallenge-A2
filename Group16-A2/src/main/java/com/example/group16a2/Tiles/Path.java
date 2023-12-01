package com.example.group16a2.Tiles;

public class Path extends Tile {

    private String filename;

    public Path(boolean isInteractable) {
        super(isInteractable);
        isInteractable = false;
        filename = "path.png";
    }

    //to string
    public String toString() {
        return "Path";
    }
}