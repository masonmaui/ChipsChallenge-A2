package com.example.group16a2.Tiles;

public class ChipSocket extends Tile{

        private String filename;
        private int chipsRequired;

        public ChipSocket(boolean isInteractable, int chipsRequired) {
            super(isInteractable, "chipsocket.png");
            filename = "chipsocket.png";
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
