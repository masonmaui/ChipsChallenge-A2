package com.example.group16a2.Tiles;

/**
 * Ice.java
 * Represents an ice tile
 * @author Mason Emery
 * @version 1.6
 */
public class Ice extends Tile{

        private String filename;

    /**
     * Class constructor takes isPassable as parameter
     * @param isPassable represents whether tile can be moved past
     */
    public Ice(boolean isPassable) {
            super(isPassable, "file:Sprites/ice.png");
            filename = "file:Sprites/ice.png";
        }

    /**
     * get filename of image
     * @return filename of image
     */
        //get file name
    public String getFileName() {
        return filename;
    }

    /**
     * Returns a string with name of class
     * @return name of class as string
     */
        //to string
    public String toString() {
        return "Ice";
    }
}
