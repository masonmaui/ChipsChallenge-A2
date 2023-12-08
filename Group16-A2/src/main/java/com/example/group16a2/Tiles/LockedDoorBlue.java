package com.example.group16a2.Tiles;

public class LockedDoorBlue extends Tile{

        private String filename;

        public LockedDoorBlue(boolean isPassable) {
            super(isPassable, "file:Sprites/BlueLock.png");
            filename = "file:Sprites/BlueLock.png";
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
