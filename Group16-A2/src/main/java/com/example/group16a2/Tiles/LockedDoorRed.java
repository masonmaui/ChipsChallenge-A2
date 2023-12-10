package com.example.group16a2.Tiles;

/**
 * LockedDoorRed.java
 * This class represents a tile that represents a red
 * locked door.
 * @author Mason Emery
 * @version 1.6
 */
public class LockedDoorRed extends Tile{

    private String filename;

    /**
     * Creates a new instance of the class, specifying whether
     * the tile is passable or not.
     * @param isPassable if the tile is passable, false otherwise.
     */
    public LockedDoorRed(boolean isPassable) {
        super(isPassable, "file:Sprites/RedLock.png");
        filename = "file:Sprites/RedLock.png";
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
     * door red.
     * @return The string "LockedDoorRed".
     */
    //to string
    public String toString() {
        return "LockedDoorRed";
    }
}

