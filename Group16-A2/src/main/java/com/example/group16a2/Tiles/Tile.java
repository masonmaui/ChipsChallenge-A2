package com.example.group16a2.Tiles;

/**
 * Tile.java
 * This class represents the basic tile in the game.
 * @author Mason Emery
 * @version 1.6
 */
public class Tile {

    private boolean isPassable;

    private String filename;

    /**
     * Constructs a new tile with the specified passable and
     * filename.
     * @param isInteractable true if the file is passable,false otherwise.
     * @param filename The filename associated with the tile.
     */
    public Tile(boolean isInteractable, String filename) {
        this.isPassable = isInteractable;
    }

    /**
     * Gets the file name associated with the tile.
     * @return the filename of the tile.
     */
    //get filename
    public String getFileName() {
        return filename;
    }

    /**
     * Checks if the tile is passable.
     * @return true if the tile is passable, false otherwise.
     */
    public boolean isPassable() {
        return isPassable;
    }

    /**
     * Checks if the tile is passable for the monster.
     * @return true if the tile is passable for the monster, false
     * otherwise.
     */
    
    //ispassabelMonster
    public boolean isPassableMonster() {
        if (this instanceof Water){
            return false;
        }else if (this instanceof Ice) {
            return false;
        }else if (this instanceof Wall) {
            return false;
        }else if(this instanceof IceBottomLeft){
            return false;
        }else if(this instanceof IceBottomRight) {
            return false;
        }else if(this instanceof IceTopLeft) {
            return false;
        }else if(this instanceof IceTopRight) {
            return false;
        }else if(this instanceof LockedDoorBlue) {
            return false;
        }else if(this instanceof LockedDoorGreen) {
            return false;
        }else if(this instanceof LockedDoorRed) {
            return false;
        }else if(this instanceof LockedDoorYellow) {
            return false;
        }else if (this instanceof Dirt){
            return false;
        }
        return true;
    }
}
