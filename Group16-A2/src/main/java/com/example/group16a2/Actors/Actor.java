package com.example.group16a2.Actors;

/**
 * Actor.java
 * This class represents an actor in a position of X coordinate and Y coordinate and to
 * access the actor's image.
 * @author Mason Emery
 * @version 1.6
 */

public class Actor {
    private String fileName;
    private int posX;
    private int Posy;

    /**
     * Constructs the actor with the specified position and image file name.
     * @param y The y coordinate of the actor's position.
     * @param x The x coordinate of the actor's position.
     * @param fileName The file name of the actor's image.
     */
    public Actor(int y, int x, String fileName) {
        this.posX = x;
        this.Posy = y;
        this.fileName = fileName;
    }

    /**
     * Gets the filename.
     * @return The filename of the actor's image.
     */
    public String getFileName() {
        return fileName;
    }

    /**
     * Gets the X coordinator.
     * @return The x coordinator of the actor's position.
     */
    public int getX() {
        return posX;
    }

    /**
     * Gets the Y coordinator.
     * @return The y coordinator of the actor's position.
     */
    public int getY() {
        return Posy;
    }

}
