package com.example.group16a2.Tiles;

/**
 * Water.java
 * This class represents the tile that is associated with
 * water in the game.
 * @author Mason Emery
 * @version 1.6
 */
public class Water extends Tile{

    private String filename;

    /**
     * Constructs water tile with the specified passability
     * and default sprite image file path.
     * @param isPassable true if it can pass through the tile,
     *                   false otherwise.
     */
    public Water(boolean isPassable) {
        super(isPassable , "file:Sprites/Water.png");
        filename = "file:Sprites/Water.png";
    }

    /**
     * Gets the file name associated with the water tile.
     * @return The file name of the sprite image for
     * the water tile.
     */
    //get file name
    public String getFileName() {
        return filename;
    }

    /**
     * Returns a string representation of the water tile.
     * @return The string "water".
     */
    //to string
    public String toString() {
        return "Water";
    }
}
