package com.example.group16a2.Tiles;

public class Path extends Tile {

    private String filename;

    public Path(boolean isPassable) {
        super(isPassable, "file:Sprites/Path.png");
        filename = "file:Sprites/Path.png";
    }

    //get file name
    public String getFileName() {
        return filename;
    }

    //to string
    public String toString() {
        return "Path";
    }
}