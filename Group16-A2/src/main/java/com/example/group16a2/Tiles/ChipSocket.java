package com.example.group16a2.Tiles;

public class ChipSocket extends Tile {
    private String filename;
    private int chipsRequired;

    public ChipSocket(boolean isPassable, int chipsRequired) {
        super(isPassable, "file:Sprites/ChipSocket.png");
        filename = "file:Sprites/ChipSocket2.png";
        this.chipsRequired = chipsRequired;
    }

    public int getChipsRequired() {
        return chipsRequired;
    }

    public String getFileName() {
        return filename;
    }

    public String toString() {
        return "ChipSocket" + chipsRequired;
    }
}