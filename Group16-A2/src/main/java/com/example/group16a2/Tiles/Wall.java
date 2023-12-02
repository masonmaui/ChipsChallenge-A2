package com.example.group16a2.Tiles;

public class Wall extends Tile {

        String fileName;
        public Wall(boolean isInteractable) {
            super(isInteractable);
            fileName = "wall.png";
        }

        //to string
        public String toString() {
            return "Wall";
        }
}
