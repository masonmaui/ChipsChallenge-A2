package com.example.group16a2.Tiles;

public class LockedDoorBlue extends Tile{

    private String filename;

    public LockedDoorBlue(boolean isPassable) {
        super(isPassable, "file:Sprites/BlueLock.png");
        filename = "file:Sprites/BlueLock.png";
    }

    public void openDoor() {
        // Perform actions when the door is successfully opened
        System.out.println("Blue door opened!");
        // Add any other logic you need
    }

    public void blockPlayer() {
        // Perform actions when the player is blocked (no key or wrong key)
        System.out.println("You need the blue key to open this door!");
    }

    //get file name
    public String getFileName() {
        return filename;
    }

    //to string
    public String toString() {
        return "LockedDoorBlue";
    }
}

