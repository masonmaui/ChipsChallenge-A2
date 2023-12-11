package com.example.group16a2.Tiles;

/**
 * Dirt.java
 * Represents a dirt tile
 * @author Mason Emery
 * @version 1.6
 */
public class Dirt extends Tile {

    private String fileName;

    /**
     * Class constructor takes is passable as parameter
     * @param isPassable represents whether tile can be moved past
     */
    public Dirt(boolean isPassable) {
        super(isPassable, "file:Sprites/Dirt.png");
        fileName = "file:Sprites/Dirt.png";
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
        return "Dirt";
    }
}