package com.example.group16a2.Tiles;

public class Exit extends Tile {

    private String filename;

    public Exit(boolean isInteractable) {
        super(isInteractable, "exit.png");
        filename = "exit.png";
    }

    //get file name
    public String getFileName() {
        return filename;
    }

    //to string
    public String toString() {
        return "Exit";
    }
}
