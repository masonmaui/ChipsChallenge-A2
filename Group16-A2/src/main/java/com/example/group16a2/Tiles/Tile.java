package com.example.group16a2.Tiles;

public class Tile {

    private String ID;
    private boolean isInteractable;

    public Tile(String ID, boolean isInteractable) {
        this.ID = ID;
        this.isInteractable = isInteractable;
    }

    //method to get the ID of the tile
    public String getID() {
        return ID;
    }

}
