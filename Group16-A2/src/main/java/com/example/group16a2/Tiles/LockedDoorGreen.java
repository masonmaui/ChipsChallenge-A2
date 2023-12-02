package com.example.group16a2.Tiles;

public class LockedDoorGreen extends Tile{

        private String filename;

        public LockedDoorGreen(boolean isInteractable) {
            super(isInteractable);
            filename = "lockedDoorGreen.png";
        }

        //to string
        public String toString() {
            return "LockedDoorGreen";
        }
}
