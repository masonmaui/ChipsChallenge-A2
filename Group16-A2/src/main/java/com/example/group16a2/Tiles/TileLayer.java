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
        int x = lineScanner.nextInt();
        int y = lineScanner.nextInt();
        lineScanner.close();
        Tile[][] grid = new Tile[x][y];
        while (in.hasNextLine()) {
            String line2 = in.nextLine();
            Scanner lineScanner2 = new Scanner(line2);
            for (int i = 0; i < x; i++) {
                String tileType = lineScanner2.next();
                if (tileType.equals("P")) {
                    grid[lineCount][i] = new Path(false);
                } else if (tileType.equals("D")) {
                    grid[lineCount][i] = new Dirt(true);
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
        //output each element in the array
        for (int i = 0; i < tl.getTiles().length; i++) {
            for (int j = 0; j < tl.getTiles()[i].length; j++) {
                System.out.print(tl.getTiles()[i][j] + " ");
            }
            System.out.println();
        }

    }
}

