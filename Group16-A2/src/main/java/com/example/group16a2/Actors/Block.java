package com.example.group16a2.Actors;

import com.example.group16a2.Tiles.*;

import java.util.ArrayList;

public class Block extends Actor{
    private String block;
    private String filename;
    private int x;
    private int y;
    public Block(int y, int x){
        super(y, x, "file:Sprites/Block.png");
        this.filename = "file:Sprites/Block.png";
        this.x = x;
        this.y = y;
    }

    //get x and y
    public int getX(){
        return x;
    }

    public int getY(){
        return y;
    }

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

    //check block is on water
    public void isOnWater(Tile[][] tile,ArrayList<Actor> actors){
        if(tile[y][x] instanceof Water) {
            //if it is set water to be a path
            tile[y][x] = new Path(true);
            //remove block from actors using try catch
            actors.remove(this);
        }
    }

    //is in bounds
    public boolean isInBounds(int x, int y, Tile[][] tile){
        return x >= 0 && x < tile[0].length && y >= 0 && y < tile.length;
    }

    //to string
    public String toString(){
        return "Block";
    }
}
