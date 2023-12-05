package com.example.group16a2.Tiles;

public class Ice extends Tile{

        private String filename;

        public Ice(boolean isInteractable) {
            super(isInteractable, "ice.png");
            filename = "ice.png";
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
