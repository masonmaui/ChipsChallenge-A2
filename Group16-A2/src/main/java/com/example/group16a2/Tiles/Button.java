package com.example.group16a2.Tiles;

public class Button extends Tile{

    private String filename;

    public Button(boolean isInteractable) {
        super(isInteractable , "button.png");
        filename = "button.png";
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
