package com.example.group16a2.Tiles;

public class Wall extends Tile {

        String fileName;
        public Wall(boolean isInteractable) {
            super(isInteractable , "file:Sprites/Wall.png");
            fileName = "file:Sprites/Wall.png";
        }

        //get file name
        public String getFileName() {
            return fileName;
        }

        //is interactable
        public boolean isInteractable() {
            return true;
        }

        //interacted with


        //to string
        public String toString() {
            return "Wall";
        }
}
