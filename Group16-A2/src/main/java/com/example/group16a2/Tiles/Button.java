package com.example.group16a2.Tiles;

/**
 * Button.java
 * Represents a button on the grid
 * @author Mason Emery
 * @version 1.6
 */
public class Button extends Tile{

    private String filename;
    private Trap connectedTrap;

    /**
     * Class constructor
     * @param isPassable
     */
    public Button(boolean isPassable) {
        super(isPassable , "file:Sprites/Button.png");
        filename = "file:Sprites/Button.png";
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
     * returns a string detailing the name of the class
     * @return a string giving the name of the class
     */
    //to string
    public String toString() {
        return "Button";
    }
}
