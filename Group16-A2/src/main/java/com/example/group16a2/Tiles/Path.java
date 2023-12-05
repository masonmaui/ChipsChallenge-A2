package com.example.group16a2.Tiles;

public class Path extends Tile {

    private String filename;

    public Path(boolean isInteractable) {
        super(isInteractable, "path.png");
        isInteractable = false;
        filename = "path.png";
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