package com.example.group16a2.Tiles;

/**
 * Path.java
 * This class represents a tile that is part
 * of a path in the game.
 * @author Mason Emery
 * @version 1.6
 */
public class Path extends Tile {

    private String filename;

    /**
     * Constructs the path with the specified passable
     * and image file name.
     * @param isPassable if the path is passable.
     */

    public Path(boolean isPassable) {
        super(isPassable, "file:Sprites/Path.png");
        filename = "file:Sprites/Path.png";
    }

    /**
     * Gets the filename of the image associated with the
     * path tile.
     * @return filename of the image.
     */

    //get file name
    public String getFileName() {
        return filename;
    }

    /**
     * Represents a string representation of a path tile.
     * @return the string representation of the path tile.
     */
    
    //to string
    public String toString() {
        return "Path";
    }
}