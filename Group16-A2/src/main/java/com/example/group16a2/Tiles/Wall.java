package com.example.group16a2.Tiles;

public class Wall extends Tile {

        String fileName;
        public Wall(boolean isInteractable) {
            super(isInteractable , "wall.png");
            fileName = "wall.png";
        }

        //get file name
        public String getFileName() {
            return fileName;
        }

        //to string
        public String toString() {
            return "Wall";
        }
}
