package com.example.group16a2.Tiles;

/**
 * IceBottomRight.java
 * Represents an ice tile that has a corner in the bottom right
 * @author Mason Emery
 * @version 1.6
 */
public class IceBottomRight extends Tile{

    private String filename;

    /**
     * Class constructor takes isPassable as parameter
     * @param isPassable represents whether tile can be moved past
     */
    public IceBottomRight(boolean isPassable) {
        super(isPassable, "file:Sprites/IceBottomRight.png");
        filename = "file:Sprites/IceBottomRight.png";
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
    public String toString(){
        return "IceBottomRight";
    }
}
