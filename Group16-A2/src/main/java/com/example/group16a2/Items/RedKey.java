package com.example.group16a2.Items;

/**
 * RedKey.java
 * This class represents a red key in the game.
 * @author Mason Emery
 * @version 1.6
 */
public class RedKey extends CollectableItems{
    private String filename;

    /**
     * Initialize the red key with the image file
     * path.
     */

    public RedKey() {
        super( "file:Sprites/RedKey.png");
        filename = "file:Sprites/RedKey.png";
    }

    /**
     * Returns a string representation of the red
     * key.
     * @return the string "Red Key".
     */
    public String toString() {
        return "Red Key";
    }
}
