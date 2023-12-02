package com.example.group16a2.Tiles;

public class LockedDoorBlue extends Tile{

        private String filename;

        public LockedDoorBlue(boolean isInteractable) {
            super(isInteractable);
            filename = "lockedDoorBlue.png";
        }

        //to string
        public String toString() {
            return "LockedDoorBlue";
        }
}
