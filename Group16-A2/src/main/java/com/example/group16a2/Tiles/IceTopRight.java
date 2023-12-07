package com.example.group16a2.Tiles;

public class IceTopRight extends Tile{

            private String filename;

            public IceTopRight(boolean isInteractable) {
                super(isInteractable, "file:Sprites/IceTopRight.png");
                this.filename = "file:Sprites/IceTopRight.png";
            }

            //get file name
            public String getFileName() {
                return filename;
            }

            //to string
            public String toString() {
                return "IceTopRight";
            }
}
