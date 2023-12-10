package com.example.group16a2.Tiles;

public class LockedDoorGreen extends Tile{

    private String filename;

    public LockedDoorGreen(boolean isPassable) {
        super(isPassable, "file:Sprites/GreenLock.png");
        filename = "file:Sprites/GreenLock.png";
    }

    public void openDoor() {
        // Perform actions when the door is successfully opened
        System.out.println("Green door opened!");
    }

    public void blockPlayer() {
        // Perform actions when the player is blocked (no key or wrong key)
        System.out.println("You need the green key to open this door!");
    }

    //get file name
    public String getFileName() {
        return filename;
    }

    //to string
    public String toString() {
        return "LockedDoorGreen";
    }
}
