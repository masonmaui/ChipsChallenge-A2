package com.example.group16a2.Tiles;

public class LockedDoorYellow extends Tile{

        private String filename;

        public LockedDoorYellow(boolean isInteractable) {
            super(isInteractable, "file:Sprites/YellowLock.png");
            filename = "file:Sprites/YellowLock.png";
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
