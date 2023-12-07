package com.example.group16a2.Actors;

import java.util.Arrays;

public class Actor {
    private String fileName;

    private int Posx;
    private int Posy;
    // Constructor
    public Actor(int y, int x, String fileName) {
        this.Posx = x;
        this.Posy = y;
        this.fileName = fileName;
    }

    //get file name
    public String getFileName() {
        return fileName;
    }

    //get x
    public int getX() {
        return Posx;
    }

    //get y
    public int getY() {
        return Posy;
    }
}