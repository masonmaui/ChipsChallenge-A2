package com.example.group16a2.Actors;

import com.example.group16a2.Tiles.*;

import java.util.ArrayList;

/**
 * Bug.java
 * This class implements the block actor in the chip challenge game.
 * @author Mason Emery
 * @version 1.6
 */
public class Block extends Actor{
    private String block;
    private String filename;
    private int x;
    private int y;    
    
    /**
     * class constructor
     * @param y represents y co-ordinate of the block
     * @param x represents x co-ordinate of the block
     */
    public Block(int y, int x){
        super(y, x, "file:Sprites/Block.png");
        this.filename = "file:Sprites/Block.png";
        this.x = x;
        this.y = y;
    }

    /**
     * return x co-ordinate of block
     * @return x co-ordiante
     */
    //get x and y
    public int getX(){
        return x;
    }

    /**
     * return y co-ordinate of block
     * @return y co-ordiante
     */
    public int getY(){
        return y;
    }

    /**
     * checks if the block can move onto the tile above it
     * depending on the tile the block will react in different ways
     * @param tiles represents the grid of tiles
     */
    //moving functions for block
    public void moveUp(Tile[][] tiles){
        if (isInBounds(x, y - 1, tiles)) {
            if(tiles[y - 1][x].isPassable()){
                if (tiles[y - 1][x] instanceof Ice){
                    if (tiles[y - 2][x] instanceof Wall) {
                        moveDown(tiles);
                    }else {
                        y--;
                        moveUp(tiles);
                    }
                }else if (tiles[y - 1][x] instanceof IceTopRight){
                    if (tiles[y - 1][x] instanceof Wall) {
                        moveRight(tiles);
                    }else {
                        y--;
                        moveLeft(tiles);
                    }
                }
                else if (tiles[y - 1][x] instanceof IceTopLeft){
                    if (tiles[y - 1][x] instanceof Wall) {
                        moveLeft(tiles);
                    }else {
                        y--;
                        moveRight(tiles);
                    }
                }
                else if (tiles[y - 1][x] instanceof IceBottomLeft){
                }
                else if (tiles[y - 1][x] instanceof IceBottomRight) {
                }else {
                    y--;
                }
            }
        }
    }

    /**
     * checks if the block can move onto the tile below it
     * depending on the tile the block will react in different ways
     * @param tiles represents the grid of tiles
     */
    public void moveDown(Tile[][] tiles){
        if (isInBounds(x, y + 1, tiles)) {
            if(tiles[y + 1][x].isPassable()){
                if (tiles[y + 1][x] instanceof Ice){
                    if(tiles[y + 2][x] instanceof Wall) {
                        moveUp(tiles);
                    }else {
                        y++;
                        moveDown(tiles);
                    }
                }else if (tiles[y + 1][x] instanceof IceTopRight){
                }
                else if (tiles[y + 1][x] instanceof IceTopLeft){
                }
                else if (tiles[y + 1][x] instanceof IceBottomLeft){
                    if (tiles[y + 1][x] instanceof Wall) {
                        moveLeft(tiles);
                    }else {
                        y++;
                        moveRight(tiles);
                    }
                }
                else if (tiles[y + 1][x] instanceof IceBottomRight){
                    if(tiles[y + 1][x] instanceof Wall){
                        moveRight(tiles);
                    }else {
                        y++;
                        moveLeft(tiles);
                    }
                }else {
                    y++;
                }
            }
        }
    }

    /**
     * checks if the block can move onto the tile to the left of it
     * depending on the tile the block will react in different ways
     * @param tiles represents the grid of tiles
     */
    public void moveLeft(Tile[][] tiles){
        if (isInBounds(x - 1, y, tiles)) {
            if(tiles[y][x - 1].isPassable()){
                if (tiles[y][x - 1] instanceof Ice) {
                    if (tiles[y][x - 2] instanceof Wall) {
                        moveRight(tiles);
                    }else {
                        x--;
                        moveLeft(tiles);
                    }
                }else if (tiles[y][x - 1] instanceof IceTopRight){
                }
                else if (tiles[y][x - 1] instanceof IceTopLeft){
                    if (tiles[y][x - 1] instanceof Wall) {
                        moveUp(tiles);
                    }else {
                        x--;
                        moveDown(tiles);
                    }
                }
                else if (tiles[y][x - 1] instanceof IceBottomLeft){
                    if(tiles[y][x - 1] instanceof Wall) {
                        moveDown(tiles);
                    }else {
                        x--;
                        moveUp(tiles);
                    }
                }
                else if (tiles[y][x - 1] instanceof IceBottomRight){
                }else {
                    x--;
                }
            }
        }
    }

    /**
     * checks if the block can move onto the tile to the right of it
     * depending on the tile the block will react in different ways
     * @param tiles represents the grid of tiles
     */
    public void moveRight(Tile[][] tiles) {
        if (isInBounds(x + 1, y, tiles)) {
            if(tiles[y][x + 1].isPassable()){
                if (tiles[y][x + 1] instanceof Ice){
                    if (tiles[y][x + 1] instanceof Wall) {
                        moveLeft(tiles);
                    }else {
                        x++;
                        moveRight(tiles);
                    }
                }else if (tiles[y][x + 1] instanceof IceTopRight){
                    if (tiles[y][x + 1] instanceof Wall) {
                        moveUp(tiles);
                    }else {
                        x++;
                        moveDown(tiles);
                    }
                }
                else if (tiles[y][x + 1] instanceof IceTopLeft){

                }
                else if (tiles[y][x + 1] instanceof IceBottomLeft){
                }
                else if (tiles[y][x + 1] instanceof IceBottomRight){
                    if (tiles[y][x + 1] instanceof Wall) {
                        moveDown(tiles);
                    }else {
                        x++;
                        moveUp(tiles);
                    }
                }else {
                    x++;
                }
            }
        }
    }

    /**
     * checks if the block is on water then if so replaces the water tile with a path tile 
     * @param tile represents the grid of tiles
     * @param actors represents the grid of actors
     */
    
    //check block is on water
    public void isOnWater(Tile[][] tile,ArrayList<Actor> actors){
        if(tile[y][x] instanceof Water) {
            //if it is set water to be a path
            tile[y][x] = new Path(true);
            //remove block from actors using try catch
            actors.remove(this);
        }
    }

    /**
     * checks if the block is within the bounds of the game grid   
     * @param x represents x co-ordinate of the block      
     * @param y represents y co-ordinate of the block
     * @param tile represents the grid of tiles
     * @return true if the block is within the bounds of the game grid
     */
    public boolean isInBounds(int x, int y, Tile[][] tile){
        return x >= 0 && x < tile[0].length && y >= 0 && y < tile.length;
    }

    /**
     * checks if the tile has been pushed over a button or a trap   
     * @param tile represents the grid of tiles
     */
    //is on button
    public void isOnButton(Tile[][] tile){
        if(tile[y][x] instanceof Button){
            //if it is set button to be activated
            ((Button) tile[y][x]).setActivated(true);
            //print out the buttons ID
            //loop through all tiles
            for(int i = 0; i < tile.length; i++){
                for(int j = 0; j < tile[0].length; j++){
                    //if tile is a trap
                    if(tile[i][j] instanceof Trap){
                        //if the trap has the same ID as the button
                        if(((Trap) tile[i][j]).getID().equals(((Button) tile[y][x]).getID())){
                            //set trap to be passable using set activated
                            ((Trap) tile[i][j]).setActivated(false);
                        }
                    }
                }
            }
        }
    }

    /**
     * returns a string with the name of the class
     * @return name of the class as a string
     */
    //to string
    public String toString(){
        return "Block";
    }
}
