package com.example.group16a2.Tiles;

public class Button extends Tile{

    private String filename;

    public Button(boolean isInteractable) {
        super(isInteractable);
        filename = "button.png";
    }

    //to string
    public String toString() {
        return "Button";
    }
}
