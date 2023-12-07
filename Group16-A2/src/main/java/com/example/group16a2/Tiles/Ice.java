package com.example.group16a2.Tiles;

public class Ice extends Tile{

        private String filename;

        public Ice(boolean isInteractable) {
            super(isInteractable, "file:Sprites/ice.png");
            filename = "file:Sprites/ice.png";
        }

        //get file name
        public String getFileName() {
            return filename;
        }

        //to string
        public String toString() {
            return "Ice";
        }
}
