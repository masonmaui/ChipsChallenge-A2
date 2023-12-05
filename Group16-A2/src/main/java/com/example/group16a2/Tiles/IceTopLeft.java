package com.example.group16a2.Tiles;

public class IceTopLeft extends Tile{

            private String filename;

            public IceTopLeft(boolean isInteractable) {
                super(isInteractable, "iceTopLeft.png");
                filename = "iceTopLeft.png";
            }

            //get file name
            public String getFileName() {
                return filename;
            }

            //to string
            public String toString() {
                return "IceTopLeft";
            }
}
