package com.example.group16a2.Actors;

import com.example.group16a2.Tiles.Tile;

/**
 * Bug.java
 * This class implements the bug actor in the chip challenge game.
 * @author Mason Emery
 * @version 1.6
 */

public class Bug extends Actor{

    private String fileName;
    private int x;
    private int y;

    private String wallToFollow;

    public Bug(int y, int x, String wallToFollow){
        super(y, x, "file:Sprites/BugUp.png");
        this.fileName = "file:Sprites/BugUp.png";
        this.x = x;
        this.y = y;
        this.wallToFollow = wallToFollow;
    }

    //get file name
    public String getFileName(){
        return fileName;
    }

    //get x
    public int getX(){
        return x;
    }

    //get y
    public int getY(){
        return y;
    }

    //wall follow using left and right
    public void wallFollow(Tile[][] tile){
        if (wallToFollow.equals("L")) {
            if (isInBounds(x - 1, y, tile)) {
                if (!tile[y][x - 1].isPassableMonster()) {
                    moveUp(tile);
                }else if(!tile[y][x + 1].isPassableMonster()) {
                    moveDown(tile);
                }else if(!tile[y - 1][x].isPassableMonster()) {
                    moveRight(tile);
                }else if(!tile[y + 1][x].isPassableMonster()) {
                    moveLeft(tile);
                }else if(!tile[y+1][x - 1].isPassableMonster()) {
                    moveLeft(tile);
                }else if(!tile[y+1][x + 1].isPassableMonster()) {
                    moveDown(tile);
                }else if(!tile[y-1][x + 1].isPassableMonster()) {
                    moveRight(tile);
                }else if(!tile[y-1][x - 1].isPassableMonster()) {
                    moveUp(tile);
                }
            }
        }else if (wallToFollow.equals("R")){
            if (isInBounds(x + 1, y, tile)) {
                if (!tile[y][x + 1].isPassableMonster()) {
                    moveUp(tile);
                }else if(!tile[y + 1][x].isPassableMonster()) {
                    moveRight(tile);
                }else if(!tile[y][x - 1].isPassableMonster()) {
                    moveDown(tile);
                }else if(!tile[y - 1][x].isPassableMonster()) {
                    moveLeft(tile);
                }else if(!tile[y+1][x + 1].isPassableMonster()) {
                    moveRight(tile);
                }else if(!tile[y+1][x - 1].isPassableMonster()) {
                    moveDown(tile);
                }else if(!tile[y-1][x - 1].isPassableMonster()) {
                    moveLeft(tile);
                }else if(!tile[y-1][x + 1].isPassableMonster()) {
                    moveUp(tile);
                }
            }
        }
    }

    //move right
    public void moveRight(Tile[][] tile){
        if (isInBounds(x + 1, y, tile)){
            if (tile[y][x + 1].isPassableMonster()){
                x++;
            }
        }
    }

    //move left
    public void moveLeft(Tile[][] tile){
        if (isInBounds(x - 1, y, tile)){
            if (tile[y][x - 1].isPassableMonster()) {
                x--;
            }
        }
    }

    //move up
    public void moveUp(Tile[][] tile){
        if (isInBounds(x, y - 1, tile)){
            if (tile[y - 1][x].isPassableMonster()) {
                y--;
            }
        }
    }

    //move down
    public void moveDown(Tile[][] tile){
        if (isInBounds(x, y + 1, tile)){
            if (tile[y + 1][x].isPassableMonster()){
                y++;
            }
        }
    }
    public boolean isInBounds(int x, int y, Tile[][] tile){
        if (x < 0 || x >= tile[0].length || y < 0 || y >= tile.length){
            return false;
        }
        return true;
    }

    //to string
    public String toString(){
        return "Bug";
    }
}
