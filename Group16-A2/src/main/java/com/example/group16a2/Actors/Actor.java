package com.example.group16a2.Actors;

public class Actor {
    private String fileName;

    private int posX;
    private int Posy;
    // Constructor
    public Actor(int y, int x, String fileName) {
        this.posX = x;
        this.Posy = y;
        this.fileName = fileName;
    }

    //get file name
    public String getFileName() {
        return fileName;
    }

    //get x
    public int getX() {
        return posX;
    }

    //get y
    public int getY() {
        return Posy;
    }

}