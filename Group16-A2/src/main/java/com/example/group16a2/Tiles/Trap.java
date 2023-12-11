package com.example.group16a2.Tiles;

/**
 * Trap.java
 * This class represents a trap which is part of the tile class
 * that can be used in the game.
 * @author Mason Emery
 * @version 1.6
 */
public class Trap extends Tile {

    private String fileName;
    private boolean activated = true;
    String ID;

    /**
     * Constructs trap tile with the specified passable
     * and default sprite image file path.
     * @param isPassable true if it can pass through the tile,
     *                   false otherwise.
     * @param ID The ID associated with the trap tile.
     */
    public Trap(boolean isPassable, String ID) {
        super(isPassable, "file:Sprites/Trap.png");
        fileName = "file:Sprites/Trap.png";
        this.ID = ID;
    }

    /**
     * Gets the ID associated with the trap tile.
     * @return The ID of the sprite image for
     * the trap tile.
     */
    public String getID(){
        return ID;
    }

    /**
     * Gets the activated status of the trap tile.
     * @return The activated status of the trap tile.
     */
    //get if activated
    public boolean getActivated(){
        return activated;
    }

    /**
     * Sets the activated status of the trap tile.
     * @param activated The activated status of the trap tile.
     */
    //set activated
    public void setActivated(boolean activated){
        this.activated = activated;
    }

    /**
     * Gets the file name associated with the trap tile.
     * @return The file name of the sprite image for
     * the water tile.
     */

    //get file name
    public String getFileName() {
        return fileName;
    }


    /**
     * Returns a string representation of the trap tile.
     * @return The string "Trap".
     */
    //to string
    public String toString() {
        return "Trap";
    }
}
