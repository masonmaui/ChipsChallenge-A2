package com.example.group16a2.Tiles;

/**
 * Wall.java
 * This class represents the wall which is part of the tile class
 * that can be used in the game.
 * @author Mason Emery
 * @version 1.6
 */
public class Wall extends Tile {

        String fileName;

    /**
     * Constructs wall tile with the specified passable
     * and default sprite image file path.
     * @param isPassable true if it can pass through the tile,
     *                   false otherwise.
     */
        public Wall(boolean isPassable) {
            super(isPassable , "file:Sprites/Wall.png");
            fileName = "file:Sprites/Wall.png";
        }

    /**
     * Gets the file name associated with the wall tile.
     * @return The file name of the sprite image for
     * the wall tile.
     */
    
        //get file name
        public String getFileName() {
            return fileName;
        }

        //to string
        public String toString() {
            return "Wall";
        }
}
