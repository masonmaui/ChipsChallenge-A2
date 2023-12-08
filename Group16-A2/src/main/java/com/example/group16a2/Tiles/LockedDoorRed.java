package com.example.group16a2.Tiles;

public class LockedDoorRed extends Tile{

        private String filename;

        public LockedDoorRed(boolean isPassable){
            super(isPassable, "file:Sprites/RedLock.png");
            filename = "file:Sprites/RedLock.png";
        }

        //get file name
        public String getFileName() {
            return filename;
        }

        //to string
        public String toString() {
            return "LockedDoorRed";
        }
}
