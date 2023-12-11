package com.example.group16a2.Tiles;

/**
 * IceBottomLeft.java
 * Represents an ice tile that has a corner in the bottom left
 * @author Mason Emery
 * @version 1.6
 */
public class IceBottomLeft extends Tile{
            private String fileName;
            /**
             * Class constructor takes isPassable as parameter
             * @param isPassable represents whether tile can be moved past
            */
            public IceBottomLeft(boolean isPassable) {
                super(isPassable, "file:Sprites/IceBottomLeft.png");
                fileName = "file:Sprites/IceBottomLeft.png";
            }

            /**
            * get filename of image
            * @return filename of image
            */
            //get file name
            public String getFileName() {
                return fileName;
            }

            /**
             * Returns a string with name of class
             * @return name of class as string
            */
            //to string
            public String toString() {
                return "IceBottomLeft";
            }
}
