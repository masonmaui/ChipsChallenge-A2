package com.example.group16a2.Tiles;

public class LockedDoorYellow extends Tile{

    private String filename;

    public LockedDoorYellow(boolean isPassable) {
        super(isPassable, "file:Sprites/YellowLock.png");
        filename = "file:Sprites/YellowLock.png";
    }

    public void openDoor() {
        // Perform actions when the door is successfully opened
        System.out.println("Yellow door opened!");
    }

    public void blockPlayer() {
        // Perform actions when the player is blocked (no key or wrong key)
        System.out.println("You need the Yellow Key to open this door!");
    }

    //get file name
    public String getFileName() {
        return filename;
    }

    //to string
    public String toString() {
        return "LockedDoorYellow";
    }
}