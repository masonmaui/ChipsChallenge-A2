package com.example.group16a2.Items;

/**
 * YellowKey.java
 * This class represents a yellow key in the game.
 * @author Mason Emery
 * @version 1.6
 */
public class YellowKey extends CollectableItems{
    private String filename;

    /**
     * Initialize the yellow key with the image file
     * path.
     */
    public YellowKey() {
        super( "file:Sprites/YellowKey.png");
        filename = "file:Sprites/YellowKey.png";
    }

    public String toString() {
        return "Yellow Key";
    }
}
