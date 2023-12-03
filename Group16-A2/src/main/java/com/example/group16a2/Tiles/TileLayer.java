package com.example.group16a2.Tiles;

import java.io.*;
import java.util.Scanner;

public class TileLayer {

    private Tile[][] tiles;
    private int timeLimit;

    String filename;

    public TileLayer(String filename) {
        this.filename = filename;
        tiles = readDataFile(filename);
    }

    //get time limit
    public int getTimeLimit() {
        return timeLimit;
    }

    //get tile array
    public Tile[][] getTiles() {
        return tiles;
    }

    //file to read all data in
    public Tile[][] readEachLine(Scanner in) {
        int lineCount = 0;
        String line = in.nextLine();
        Scanner lineScanner = new Scanner(line);
        int y = lineScanner.nextInt();
        int x = lineScanner.nextInt();
        lineScanner.close();
        Tile[][] grid = new Tile[y][x];
        while (in.hasNextLine()) {
            String line2 = in.nextLine();
            Scanner lineScanner2 = new Scanner(line2);
            for (int i = 0; i < x; i++) {
                String tileType = lineScanner2.next();
                if (tileType.equals("P")) {
                    grid[lineCount][i] = new Path(false);
                } else if (tileType.equals("D")) {
                    grid[lineCount][i] = new Dirt(true);
                } else if (tileType.equals("#")){
                    grid[lineCount][i] = new Wall(true);
                } else if (tileType.equals("E")){
                    grid[lineCount][i] = new Exit(true);
                }else if (tileType.equals("B")){
                    grid[lineCount][i] = new Button(true);
                }else if(tileType.equals("T")) {
                    grid[lineCount][i] = new Trap(true);
                }else if(tileType.equals("W")){
                    grid[lineCount][i] = new Water(true);
                }else if(tileType.equals("CS1")){
                    grid[lineCount][i] = new ChipSocket(true, 1);
                }else if(tileType.equals("CS2")) {
                    grid[lineCount][i] = new ChipSocket(true, 2);
                }else if(tileType.equals("CS3")) {
                    grid[lineCount][i] = new ChipSocket(true, 3);
                }else if(tileType.equals("RD")) {
                    grid[lineCount][i] = new LockedDoorRed(true);
                }else if(tileType.equals("GD")) {
                    grid[lineCount][i] = new LockedDoorGreen(true);
                }else if(tileType.equals("YD")) {
                    grid[lineCount][i] = new LockedDoorYellow(true);
                }else if(tileType.equals("BD")) {
                    grid[lineCount][i] = new LockedDoorBlue(true);
                }else if(tileType.equals("I")) {
                    grid[lineCount][i] = new Ice(true);
                }else if(tileType.equals("ITL")) {
                    grid[lineCount][i] = new IceTopLeft(true);
                }else if(tileType.equals("ITR")) {
                    grid[lineCount][i] = new IceTopRight(true);
                }else if(tileType.equals("IBL")) {
                    grid[lineCount][i] = new IceBottomLeft(true);
                }else if(tileType.equals("IBR")) {
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

    public static void main(String[] args) {
        TileLayer tl = new TileLayer("Levels/Level1TileLayer.txt");
        for (int i = 0; i < tl.getTiles().length; i++) {
            for (int j = 0; j < tl.getTiles()[i].length; j++) {
                System.out.print(tl.getTiles()[i][j] + " ");
            }
            System.out.println();
        }
    }
}
