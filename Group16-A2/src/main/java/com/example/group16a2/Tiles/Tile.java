package com.example.group16a2.Tiles;

public class Tile {

    private boolean isPassable;

    private String filename;

    public Tile(boolean isInteractable, String filename) {
        this.isPassable = isInteractable;
    }

    //get filename
    public String getFileName() {
        return filename;
    }

    public boolean isPassable() {
        return isPassable;
    }



}
