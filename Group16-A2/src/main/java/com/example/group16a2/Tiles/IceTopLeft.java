package com.example.group16a2.Tiles;

public class IceTopLeft extends Tile{

            private String filename;

            public IceTopLeft(boolean isInteractable) {
                super(isInteractable);
                filename = "iceTopLeft.png";
            }

            //to string
            public String toString() {
                return "IceTopLeft";
            }
}
