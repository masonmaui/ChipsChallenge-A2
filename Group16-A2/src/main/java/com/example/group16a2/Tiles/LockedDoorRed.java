package com.example.group16a2.Tiles;

public class LockedDoorRed extends Tile{

    private String filename;

    public LockedDoorRed(boolean isPassable) {
        super(isPassable, "file:Sprites/RedLock.png");
        filename = "file:Sprites/RedLock.png";
    }

    public void openDoor() {
        // Perform actions when the door is successfully opened
        System.out.println("Red door opened!");
    }

    public void blockPlayer() {
        // Perform actions when the player is blocked (no key or wrong key)
        System.out.println("You need the Red Key to open this door!");
    }

    //get file name
    public String getFileName() {
        return filename;
    }

    //to string
    public String toString() {
        return "LockedDoorRed";
    }
}

