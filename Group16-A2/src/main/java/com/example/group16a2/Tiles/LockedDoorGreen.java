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

    public LockedDoorGreen(boolean isPassable) {
        super(isPassable, "file:Sprites/GreenLock.png");
        filename = "file:Sprites/GreenLock.png";
    }

    //get file name
    public String getFileName() {
        return filename;
    }

    //to string
    public String toString() {
        return "LockedDoorGreen";
    }
}
