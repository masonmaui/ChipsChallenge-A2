package com.example.group16a2.Tiles;

public class Tile {

    private boolean isInteractable;

    private String filename;

    public Tile(boolean isInteractable, String filename) {
        this.isInteractable = isInteractable;
    }

    //get filename
    public String getFileName() {
        return filename;
    }



}
