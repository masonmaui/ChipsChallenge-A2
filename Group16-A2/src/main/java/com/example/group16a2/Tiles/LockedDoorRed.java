package com.example.group16a2.Tiles;

public class LockedDoorRed extends Tile{

        private String filename;

        public LockedDoorRed(boolean isInteractable) {
            super(isInteractable);
            filename = "lockedDoorRed.png";
        }

        //to string
        public String toString() {
            return "LockedDoorRed";
        }
}
