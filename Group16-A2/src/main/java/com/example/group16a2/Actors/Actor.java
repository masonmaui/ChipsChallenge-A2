package com.example.group16a2.Actors;

/**
 * Actor.java
 * This class represents an actor in a position of X coordinate and Y coordinate and to
 * access the actor's image.
 * @version 2.0
 * @author Danah Abu Qrais
 * @version 1.6
 */
public class Actor {
    private String fileName;
    private int posX;
    private int Posy;

    /**
     *
     * @param x represents the X coordinate of the actor's position.
     * @param y represents the Y coordinate of the actor's position.
     * @param fileName represents the filename of the actor's image.
     */
    // Constructor
    public Actor(int y, int x, String fileName) {
        this.posX = x;
        this.Posy = y;
        this.fileName = fileName;
    }

    /**
     * Gets the filename.
     * @return The filename of the actor's image.
     */

    //get file name
    public String getFileName() {
        return fileName;
    }

    /**
     * Gets the X coordinator.
     * @return The x coordinator of the actor's position.
     */

    //get x
    public int getX() {
        return posX;
    }

    /**
     * Gets the Y coordinator.
     * @return The y coordinator of the actor's position.
     */
    //get y
    public int getY() {
        return Posy;
    }
}