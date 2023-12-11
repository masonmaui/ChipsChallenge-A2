package com.example.group16a2.Items;

/**
 * GreenKey.java
 * This class represents a green key in the game.
 * @author Mason Emery
 * @version 1.6
 */
public class GreenKey extends CollectableItems{
    private String fileName;

    /**
     * Initialize the green key with the image file
     * path.
     */
    public GreenKey() {
        super( "file:Sprites/GreenKey.png");
        fileName = "file:Sprites/GreenKey.png";
    }

    /**
     * Returns a string representation of the green
     * key.
     * @return the string "Green Key".
     */
    public String toString() {
        return "Green Key";
    }
}
