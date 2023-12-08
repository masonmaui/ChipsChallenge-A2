package com.example.group16a2.Tiles;

public class IceBottomRight extends Tile{

            private String filename;

            public IceBottomRight(boolean isPassable) {
                super(isPassable, "file:Sprites/IceBottomRight.png");
                filename = "file:Sprites/IceBottomRight.png";
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
