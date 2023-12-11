package com.example.group16a2.Tiles;

/**
 * IceTopLeft.java
 * Represents an ice tile that has a corner in the top left
 * @author Mason Emery
 * @version 1.6
 */
public class IceTopLeft extends Tile{

            private String fileName;

            /**
            * Class constructor takes isPassable as parameter
            * @param isPassable represents whether tile can be moved past
            */
            public IceTopLeft(boolean isPassable) {
                super(isPassable, "file:Sprites/IceTopLeft.png");
                fileName = "file:Sprites/IceTopLeft.png";
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
                return "IceTopLeft";
            }
}
