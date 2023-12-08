package com.example.group16a2.Tiles;

public class Button extends Tile{

    private String filename;

    public Button(boolean isPassable) {
        super(isPassable , "file:Sprites/Button.png");
        filename = "file:Sprites/Button.png";
    }

    //get file name
    public String getFileName() {
        return filename;
    }

    //to string
    public String toString() {
        return "Button";
    }
}
