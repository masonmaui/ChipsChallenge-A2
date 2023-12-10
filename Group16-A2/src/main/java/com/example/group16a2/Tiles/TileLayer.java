package com.example.group16a2.Tiles;

import java.io.*;
import java.util.Scanner;

/**
 * TileLayer.java
 * This class represents the layers of tiles for a game
 * map.
 * @author Mason Emery
 * @version 1.6
 */

public class TileLayer {

    private Tile[][] tiles;
    private int timeLimit;

    String filename;

    private int x;
    private int y;

    /**
     * Constructs the tile layer object by reading tile information
     * from specified file.
     * @param filename The name of the file containing tile information.
     */
    public TileLayer(String filename) {
        this.filename = filename;
        tiles = readDataFile(filename);
    }

    /**
     * Gets the time limit for the game.
     * @return the timeLimit for the game.
     */
    //get time limit
    public int getTimeLimit() {
        return timeLimit;
    }

    /**
     * Gets the 2D array of tiles representing the game map.
     * @return the 2D array of tiles.
     */
    //get tile array
    public Tile[][] getTiles() {
        return tiles;
    }

    /**
     * Reads each line of the file.
     * @param in The scanner object for reading from the file.
     * @return grid representing the game map.
     */
    //file to read all data in
    public Tile[][] readEachLine(Scanner in) {
        int lineCount = 0;
        String line = in.nextLine();
        Scanner lineScanner = new Scanner(line);
        y = lineScanner.nextInt();
        x = lineScanner.nextInt();
        lineScanner.close();
        Tile[][] grid = new Tile[y][x];
        while (in.hasNextLine()) {
            String line2 = in.nextLine();
            Scanner lineScanner2 = new Scanner(line2);
            for (int i = 0; i < x; i++) {
                String tileType = lineScanner2.next();
                if (tileType.equals("P")) {
                    grid[lineCount][i] = new Path(true);
                } else if (tileType.equals("D")) {
                    grid[lineCount][i] = new Dirt(true);
                } else if (tileType.equals("#")) {
                    grid[lineCount][i] = new Wall(false);
                } else if (tileType.equals("E")) {
                    grid[lineCount][i] = new Exit(true);
                } else if (tileType.equals("B")) {
                    grid[lineCount][i] = new Button(true);
                } else if (tileType.equals("T")) {
                    grid[lineCount][i] = new Trap(true);
                } else if (tileType.equals("W")) {
                    grid[lineCount][i] = new Water(true);
                } else if (tileType.equals("CS1")) {
                    grid[lineCount][i] = new ChipSocket(true, 1);
                } else if (tileType.equals("CS2")) {
                    grid[lineCount][i] = new ChipSocket(true, 2);
                } else if (tileType.equals("CS3")) {
                    grid[lineCount][i] = new ChipSocket(true, 3);
                } else if (tileType.equals("RD")) {
                    grid[lineCount][i] = new LockedDoorRed(true);
                } else if (tileType.equals("GD")) {
                    grid[lineCount][i] = new LockedDoorGreen(true);
                } else if (tileType.equals("YD")) {
                    grid[lineCount][i] = new LockedDoorYellow(true);
                } else if (tileType.equals("BD")) {
                    grid[lineCount][i] = new LockedDoorBlue(true);
                } else if (tileType.equals("I")) {
                    grid[lineCount][i] = new Ice(true);
                } else if (tileType.equals("ITL")) {
                    grid[lineCount][i] = new IceTopLeft(true);
                } else if (tileType.equals("ITR")) {
                    grid[lineCount][i] = new IceTopRight(true);
                } else if (tileType.equals("IBL")) {
                    grid[lineCount][i] = new IceBottomLeft(true);
                } else if (tileType.equals("IBR")) {
                    grid[lineCount][i] = new IceBottomRight(true);
                }
            }
            lineCount++;
        }
        return grid;
    }

    public Tile[][] readDataFile(String filename) {
        Scanner in = null;
        try {
            in = new Scanner(new File(filename));
        } catch (FileNotFoundException e) {
            System.out.println("Could not find " + filename);
            System.exit(-1);
        }
        return readEachLine(in);

    }

    //get x
    public int getX() {
        return x;
    }

    //get y
    public int getY() {
        return y;
    }
}

