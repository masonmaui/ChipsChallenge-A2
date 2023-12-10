package com.example.group16a2.Tiles;

/**
 * LockedDoorGreen.java
 * This class represents a tile that represents a green
 * locked door.
 * @author Mason Emery
 * @version 1.6
 */
public class LockedDoorGreen extends Tile{

    private String filename;

    /**
     * Creates a new instance of the class, specifying whether
     * the tile is passable or not.
     * @param isPassable if the tile is passable, false otherwise.
     */

    public LockedDoorGreen(boolean isPassable) {
        super(isPassable, "file:Sprites/GreenLock.png");
        filename = "file:Sprites/GreenLock.png";
    }

    /**
     * Returns the filename of the sprite.
     * @return The filename of the sprite.
     */
    //get file name
    public String getFileName() {
        return filename;
    }

    /**
     * Returns a string representation of the locked
     * door green.
     * @return The string "LockedDoorGreen".
     */
    //to string
    public String toString() {
        return "LockedDoorGreen";
    }
}
