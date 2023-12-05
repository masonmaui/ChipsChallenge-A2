package com.example.group16a2.Tiles;

public class LockedDoorBlue extends Tile{

        private String filename;

        public LockedDoorBlue(boolean isInteractable) {
            super(isInteractable, "lockedDoorBlue.png");
            filename = "lockedDoorBlue.png";
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
