package com.example.group16a2.Tiles;

public class LockedDoorGreen extends Tile{

        private String filename;

        public LockedDoorGreen(boolean isInteractable) {
            super(isInteractable, "lockedDoorGreen.png");
            filename = "lockedDoorGreen.png";
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
