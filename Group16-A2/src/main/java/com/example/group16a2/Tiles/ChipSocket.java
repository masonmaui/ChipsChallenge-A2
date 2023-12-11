package com.example.group16a2.Tiles;

/**
 * ChipSocket.java
 * Represents a chip socket tile
 * @author Mason Emery
 * @version 1.6
 */


public class ChipSocket extends Tile {
    private String fileName;
    private int chipsRequired;

    /**
     * class constructor that initiates whether the tile is passable
     * and the number of chips required.
     * Constructor checks number of chips required and uses appropriate
     * image file
     * @param isPassable represents whether tile can be moved past
     * @param chipsRequired number of chips required to open socket
     */
    public ChipSocket(boolean isPassable, int chipsRequired) {
        super(isPassable, "file:Sprites/ChipSocket.png");

        // Corrected logic to set the filename based on the chipsRequired value
        if (chipsRequired == 1) {
            fileName = "file:Sprites/ChipSocket1.png";
        } else if (chipsRequired == 2) {
            fileName = "file:Sprites/ChipSocket2.png";  // Corrected filename
        } else if (chipsRequired == 3) {
            fileName = "file:Sprites/ChipSocket3.png";
        } else {
            throw new IllegalArgumentException("Invalid chipsRequired value");
        }

        this.chipsRequired = chipsRequired;
    }

    /**
     * return number of chips required
     * @return number of chips required
     */
    public int getChipsRequired() {
        return chipsRequired;
    }

    /**
     * return filename of image
     * @return image filename
     */
    public String getFileName() {
        return fileName;
    }

    /**
     * returns a string detailing the name of the class and the
     * number of chips required
     * @return a string
     */
    public String toString() {
        return "ChipSocket" + chipsRequired;
    }
}