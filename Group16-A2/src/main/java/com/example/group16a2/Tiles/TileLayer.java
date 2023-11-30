package com.example.group16a2.Tiles;
import java.io.*;
import java.util.Queue;
import java.util.Scanner;
public class TileLayer {

    private Tile[][] tiles;
    private int timeLimit;

    public TileLayer(Tile[][] tiles, int timeLimit) {
        this.tiles = tiles;
        this.timeLimit = timeLimit;
    }

    //get time limit
    public int getTimeLimit() {
        return timeLimit;
    }

}

