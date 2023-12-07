package com.example.group16a2.Tiles;

public class LockedDoorGreen extends Tile{

        private String filename;

        public LockedDoorGreen(boolean isInteractable) {
            super(isInteractable, "file:Sprites/GreenLock.png");
            filename = "file:Sprites/GreenLock.png";
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
