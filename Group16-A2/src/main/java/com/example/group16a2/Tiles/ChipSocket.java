package com.example.group16a2.Tiles;

public class ChipSocket extends Tile{

        private String filename;
        private int chipsRequired;

        public ChipSocket(boolean isPassable, int chipsRequired) {
            super(isPassable, "file:Sprites/ChipSocket.png");
            filename = "file:Sprites/ChipSocket.png";
            this.chipsRequired = chipsRequired;
        }

        //get file name
        public String getFileName() {
            return filename;
        }


        //to string
        public String toString() {
            return "ChipSocket" + chipsRequired;
        }
}
