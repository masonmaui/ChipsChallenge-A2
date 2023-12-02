package com.example.group16a2.Tiles;

public class IceBottomRight extends Tile{

            private String filename;

            public IceBottomRight(boolean isInteractable) {
                super(isInteractable);
                filename = "iceBottomRight.png";
            }

            //to string
            public String toString() {
                return "IceBottomRight";
            }
}
