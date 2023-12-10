package com.example.group16a2.Tiles;

/**
 * Trap.java
 * This class represents a trap which is part of the tile class
 * that can be used in the game.
 * @author Mason Emery
 * @version 1.6
 */
public class Trap extends Tile {

    private String filename;

    /**
     * Constructs trap tile with the specified passable
     * and default sprite image file path.
     * @param isPassable true if it can pass through the tile,
     *                   false otherwise.
     */

    public Trap(boolean isPassable) {
        super(isPassable, "file:Sprites/Trap.png");
        filename = "file:Sprites/Trap.png";
    }

    /**
     * Gets the file name associated with the trap tile.
     * @return The file name of the sprite image for
     * the water tile.
     */
    
    //get file name
    public String getFileName() {
        return filename;
    }

    //to string
    public String toString() {
        return "Trap";
    }
}
