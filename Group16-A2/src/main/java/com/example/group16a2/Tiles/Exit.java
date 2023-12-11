package com.example.group16a2.Tiles;

/**
 * Exit.java
 * Represents an exit tile
 * @author Mason Emery
 * @version 1.6
 */
public class Exit extends Tile {

    private String fileName;

    /**
     * Class constructor takes isPassable as parameter
     * @param isPassable represents whether tile can be moved past
     */
    public Exit(boolean isPassable) {
        super(isPassable, "file:Sprites/Exit.png");
        fileName = "file:Sprites/Exit.png";
    }

    /**
     * get filename of image
     * @return filename of image
     */
    //get file name
    public String getFileName() {
        return fileName;
    }

    /**
     * Returns a string with name of class
     * @return name of class as string
     */
    //to string
    public String toString() {
        return "Exit";
    }
}
