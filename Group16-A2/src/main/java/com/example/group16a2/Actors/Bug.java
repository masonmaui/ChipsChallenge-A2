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

    /**
     * class constructor
     * @param y represents y co-ordinate of bug
     * @param x represents x co-ordinate of bug
     * @param wallToFollow represents whether bug will follow left edge or right edge
     */
    public Bug(int y, int x, String wallToFollow){
        super(y, x, "file:Sprites/BugUp.png");
        this.fileName = "file:Sprites/BugUp.png";
        this.x = x;
        this.y = y;
        this.wallToFollow = wallToFollow;
    }

    /**
     * return filename of image
     * @return image filename
     */
    //get file name
    public String getFileName(){
        return fileName;
    }

    /**
     * return x co-ordinate of bug
     * @return x co-ordiante
     */
    //get x
    public int getX(){
        return x;
    }

    /**
     * return y co-ordinate of bug
     * @return y co-ordinate
     */
    //get y
    public int getY(){
        return y;
    }

    /**
     * determines which edge bug is following and moves bug accordingly
     * @param tile represents the grid of tiles
     */
    //wall follow using left and right
    public void wallFollow(Tile[][] tile){
        if (wallToFollow.equals("L")) {
            if (isInBounds(x - 1, y, tile)) {
                if (!tile[y][x - 1].isPassableMonster()) {
                    this.fileName = "file:Sprites/BugUp.png";
                    moveUp(tile);
                }
                if(!tile[y][x + 1].isPassableMonster()) {
                    this.fileName = "file:Sprites/BugDown.png";
                    moveDown(tile);
                }
                if(!tile[y - 1][x].isPassableMonster()) {
                    this.fileName = "file:Sprites/BugRight.png";
                    moveRight(tile);
                }
                if(!tile[y + 1][x].isPassableMonster()) {
                    this.fileName = "file:Sprites/BugLeft.png";
                    moveLeft(tile);
                }
                if(!tile[y+1][x - 1].isPassableMonster()) {
                    this.fileName = "file:Sprites/BugLeft.png";
                    moveLeft(tile);
                }
                if(!tile[y+1][x + 1].isPassableMonster()) {
                    this.fileName = "file:Sprites/BugDown.png";
                    moveDown(tile);
                }
                if(!tile[y-1][x + 1].isPassableMonster()) {
                    this.fileName = "file:Sprites/BugRight.png";
                    moveRight(tile);
                }
                if(!tile[y-1][x - 1].isPassableMonster()) {
                    this.fileName = "file:Sprites/BugUp.png";
                    moveUp(tile);
                }
            }
        }else if (wallToFollow.equals("R")){
            if (isInBounds(x + 1, y, tile)) {
                if(!tile[y - 1][x].isPassableMonster()) {
                    this.fileName = "file:Sprites/BugLeft.png";
                    moveLeft(tile);
                }
                if (!tile[y][x + 1].isPassableMonster()) {
                    this.fileName = "file:Sprites/BugUp.png";
                    moveUp(tile);
                }
                if(!tile[y + 1][x].isPassableMonster()) {
                    this.fileName = "file:Sprites/BugRight.png";
                    moveRight(tile);
                }
                if(!tile[y][x - 1].isPassableMonster()) {
                    this.fileName = "file:Sprites/BugDown.png";
                    moveDown(tile);
                }
                if(!tile[y+1][x + 1].isPassableMonster()) {
                    this.fileName = "file:Sprites/BugRight.png";
                    moveRight(tile);
                }if(!tile[y+1][x - 1].isPassableMonster()) {
                    this.fileName = "file:Sprites/BugDown.png";
                    moveDown(tile);
                }
                if(!tile[y-1][x - 1].isPassableMonster()) {
                    this.fileName = "file:Sprites/BugLeft.png";
                    moveLeft(tile);
                }
                if(!tile[y-1][x + 1].isPassableMonster()) {
                    this.fileName = "file:Sprites/BugUp.png";
                    moveUp(tile);
                }
            }
        }
    }

    /**
     * moves bug to the right one tile
     * first checks whether bug can move to desired tile
     * @param tile represents a grid of tiles
     */
    //move right
    public void moveRight(Tile[][] tile){
        if (isInBounds(x + 1, y, tile)){
            if (tile[y][x + 1].isPassableMonster()){
                x++;
            }
        }
    }

    /**
     * moves bug to the left one tile
     * first checks whether bug can move to desired tile
     * @param tile represents a grid of tiles
     */
    //move left
    public void moveLeft(Tile[][] tile){
        if (isInBounds(x - 1, y, tile)){
            if (tile[y][x - 1].isPassableMonster()) {
                x--;
            }
        }
    }

    /**
     * moves bug up one tile
     * first checks whether bug can move to desired tile
     * @param tile represents the grid of tiles
     */
    //move up
    public void moveUp(Tile[][] tile){
        if (isInBounds(x, y - 1, tile)){
            if (tile[y - 1][x].isPassableMonster()) {
                y--;
            }
        }
    }

    /**
     * moves bug down one tile
     * first checks whether bug can move to desired tile
     * @param tile represents a grid of tiles
     */
    //move down
    public void moveDown(Tile[][] tile){
        if (isInBounds(x, y + 1, tile)){
            if (tile[y + 1][x].isPassableMonster()){
                y++;
            }
        }
    }

    /**
     * checks if the tile to be moved to is in bounds
     * @param x represents the x co-ordinate of the bug
     * @param y represents the x co-ordinate of the bug
     * @param tile represents the grid of tiles
     * @return true if tile to be moved to is in bounds, false otherwise
     */
    public boolean isInBounds(int x, int y, Tile[][] tile){
        if (x < 0 || x >= tile[0].length || y < 0 || y >= tile.length){
            return false;
        }
        return true;
    }

    /**
     * returns a string with the name of the class
     * @return name of the class as a string
     */
    //to string
    public String toString(){
        return "Bug";
    }
}
