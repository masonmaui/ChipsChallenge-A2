package com.example.group16a2.Tiles;

/**
 * Button.java
 * Represents a button on the grid
 * @author Mason Emery
 * @version 1.6
 */
public class Button extends Tile{

    private String filename;
    private boolean activated = false;
    private String ID;

    /**
     * Class constructor
     * @param isPassable
     */
    public Button(boolean isPassable, String ID) {
        super(isPassable , "file:Sprites/Button.png");
        filename = "file:Sprites/Button.png";
        this.ID = ID;
    }

    /**
     * get ID of button
     * @return ID of button
     */
    //get ID
    public String getID(){
        return ID;
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
     * get if activated
     * @return if activated
     */
    //get if activated
    public boolean getActivated(){
        return activated;
    }

    /**
     * set activated
     * @param activated
     */
    //set activated
    public void setActivated(boolean activated){
        this.activated = activated;
    }
    

    /**
     * returns a string detailing the name of the class
     * @return a string giving the name of the class
     */
    //to string
    public String toString() {
        return "Button" + ID;
    }
}
