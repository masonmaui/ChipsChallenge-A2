package com.example.group16a2.Items;

/**
 * BlueKey.java
 * This class represents a blue key in the chip
 * socket challenge game.
 * @author Mason Emery
 * @version 1.6
 */

public class BlueKey extends CollectableItems{

    private String filename;

    /**
     * Constructs the object with the default image
     * filename.
     */
    public BlueKey() {
        super( "file:Sprites/BlueKey.png");
        filename = "file:Sprites/BlueKey.png";
    }

    /**
     * Returns a string representation of the blue key.
     * @return the string "Blue Key".
     */
    public String toString() {
        return "Blue Key";
    }
}
