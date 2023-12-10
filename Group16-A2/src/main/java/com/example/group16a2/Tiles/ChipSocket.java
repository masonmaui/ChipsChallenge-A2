package com.example.group16a2.Tiles;

public class ChipSocket extends Tile {
    private String filename;
    private int chipsRequired;

    public ChipSocket(boolean isPassable, int chipsRequired) {
        super(isPassable, "file:Sprites/ChipSocket.png");

        // Corrected logic to set the filename based on the chipsRequired value
        if (chipsRequired == 1) {
            filename = "file:Sprites/ChipSocket1.png";
        } else if (chipsRequired == 2) {
            filename = "file:Sprites/ChipSocket2.png";  // Corrected filename
        } else if (chipsRequired == 3) {
            filename = "file:Sprites/ChipSocket3.png";
        } else {
            throw new IllegalArgumentException("Invalid chipsRequired value");
        }

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