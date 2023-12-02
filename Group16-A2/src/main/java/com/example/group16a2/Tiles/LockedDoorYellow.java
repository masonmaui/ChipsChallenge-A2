package com.example.group16a2.Tiles;

public class LockedDoorYellow extends Tile{

        private String filename;

        public LockedDoorYellow(boolean isInteractable) {
            super(isInteractable);
            filename = "lockedDoorYellow.png";
        }

        //to string
        public String toString() {
            return "LockedDoorYellow";
        }
}
