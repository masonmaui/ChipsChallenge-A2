package com.example.group16a2.Tiles;

public class Ice extends Tile{

        private String filename;

        public Ice(boolean isInteractable) {
            super(isInteractable);
            filename = "ice.png";
        }

        //to string
        public String toString() {
            return "Ice";
        }
}
