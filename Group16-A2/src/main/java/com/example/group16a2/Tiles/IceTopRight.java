package com.example.group16a2.Tiles;

public class IceTopRight extends Tile{

            private String filename;

            public IceTopRight(boolean isInteractable) {
                super(isInteractable);
                filename = "iceTopRight.png";
            }

            //to string
            public String toString() {
                return "IceTopRight";
            }
}
