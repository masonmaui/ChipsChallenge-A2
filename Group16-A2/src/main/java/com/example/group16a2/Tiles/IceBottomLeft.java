package com.example.group16a2.Tiles;

public class IceBottomLeft extends Tile{

            private String filename;

            public IceBottomLeft(boolean isInteractable) {
                super(isInteractable);
                filename = "iceBottomLeft.png";
            }

            //to string
            public String toString() {
                return "IceBottomLeft";
            }
}
