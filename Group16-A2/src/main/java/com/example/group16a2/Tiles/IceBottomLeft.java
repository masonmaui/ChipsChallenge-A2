package com.example.group16a2.Tiles;

public class IceBottomLeft extends Tile{

            private String filename;

            public IceBottomLeft(boolean isInteractable) {
                super(isInteractable, "file:Sprites/IceBottomLeft.png");
                filename = "file:Sprites/IceBottomLeft.png";
            }

            //get file name
            public String getFileName() {
                return filename;
            }

            //to string
            public String toString() {
                return "IceBottomLeft";
            }
}
