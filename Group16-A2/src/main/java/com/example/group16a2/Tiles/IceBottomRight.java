package com.example.group16a2.Tiles;

public class IceBottomRight extends Tile{

            private String filename;

            public IceBottomRight(boolean isInteractable) {
                super(isInteractable, "iceBottomRight.png");
                filename = "iceBottomRight.png";
            }

            //get file name
            public String getFileName() {
                return filename;
            }

            //to string
            public String toString() {
                return "IceBottomRight";
            }
}
