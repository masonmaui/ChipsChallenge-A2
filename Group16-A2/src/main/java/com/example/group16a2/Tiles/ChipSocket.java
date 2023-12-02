package com.example.group16a2.Tiles;

public class ChipSocket extends Tile{

        private String filename;

        public ChipSocket(boolean isInteractable) {
            super(isInteractable);
            filename = "chipsocket.png";
        }

        //to string
        public String toString() {
            return "ChipSocket";
        }
}
