package com.example.group16a2.Tiles;

/**
 * LockedDoorYellow.java
 * This class represents a tile that represents a yellow
 * locked door.
 * @author Mason Emery
 * @version 1.6
 */

public class LockedDoorYellow extends Tile{

    private String fileName;


    /**
     * Creates a new instance of the class, specifying whether
     * the tile is passable or not.
     * @param isPassable if the tile is passable, false otherwise.
     */
    public LockedDoorYellow(boolean isPassable) {
        super(isPassable, "file:Sprites/YellowLock.png");
        fileName = "file:Sprites/YellowLock.png";
    }

    /**
     * Returns the filename of the sprite.
     * @return The filename of the sprite.
     */
    //get file name
    public String getFileName() {
        return fileName;
    }

    /**
     * Returns a string representation of the locked
     * door yellow.
     * @return The string "LockedDoorYellow".
     */
    //to string
    public String toString() {
        return "LockedDoorYellow";
    }
}