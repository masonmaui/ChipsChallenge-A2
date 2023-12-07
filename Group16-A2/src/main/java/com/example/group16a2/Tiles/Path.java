package com.example.group16a2.Tiles;

public class Path extends Tile {

    private String filename;

    public Path(boolean isInteractable) {
        super(isInteractable, "file:Sprites/Path.png");
        isInteractable = false;
        filename = "file:Sprites/Path.png";
    }

    //get file name
    public String getFileName() {
        return filename;
    }

    //to string
    public String toString() {
        return "Path";
    }
}