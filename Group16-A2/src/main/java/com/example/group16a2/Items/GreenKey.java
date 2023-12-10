package com.example.group16a2.Items;

/**
 * GreenKey.java
 * This class represents a green key in the game.
 * @author Mason Emery
 * @version 1.6
 */
public class GreenKey extends CollectableItems{
    private String filename;
    public GreenKey() {
        super( "file:Sprites/GreenKey.png");
        filename = "file:Sprites/GreenKey.png";
    }

    public String toString() {
        return "Green Key";
    }
}
