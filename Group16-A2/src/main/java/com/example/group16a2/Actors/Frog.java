package com.example.group16a2.Actors;

import com.example.group16a2.Tiles.Tile;

/**
 * Frog.java
 * Represents the frog actor in the game.
 * @author Mason Emery
 * @version 1.6
 *
 */

public class Frog extends Actor {

    private String filename;

    private int x;
    private int y;

    /**
     * Constructs with the specified coordinates.
     * @param y The initial y-coordinate of the frog.
     * @param x The initial x-coordinate of the frog.
     */

    public Frog(int y, int x){
        super(y, x, "file:Sprites/Frog.png");
        this.filename = "file:Sprites/Frog.png";
        this.x = x;
        this.y = y;
    }

    /**
     * Gets the x-coordinate of the frog.
     * @return The x-coordinate of the frog.
     */
    //get x
    public int getX(){
        return x;
    }

    /**
     * Gets the y-coordinate of the frog.
     * @return The y-coordinate of the frog.
     */

    //get y
    public int getY(){
        return y;
    }

    /**
     * Finds a path to the specified player and adjust the frog's position
     * accordingly.
     * @param player The player object to find a path to.
     * @param tiles Tiles that's representing the game.
     */
    //finds path to player
    public void findPath(Player player, Tile[][] tiles){
        int playerX = player.getX();
        int playerY = player.getY();
        int frogX = this.getX();
        int frogY = this.getY();
        int xDiff = frogX - playerX;
        int yDiff = frogY - playerY;
        if (Math.abs(xDiff) > Math.abs(yDiff)){
            if (xDiff > 0){
                moveLeft(tiles);
            } else {
                moveRight(tiles);
            }
        } else {
            if (yDiff > 0){
                moveUp(tiles);
            } else {
                moveDown(tiles);
            }
        }
    }

    /**
     * Moves the frog to the right if the tile on the right is
     * passable,otherwise the frog will move down if it's not passable.
     * @param tile Tile that's representing the chip challenge game.
     */

    //move right
    public void moveRight(Tile[][] tile){
        if (isInBounds(x + 1, y, tile)){
            if (tile[y][x + 1].isPassableMonster()){
                x++;
            }else{
                moveDown(tile);
                moveDown(tile);
            }
        }
    }

    /**
     * Moves the frog to the left if the tile on the left is
     * passable,otherwise the frog will move up if it's not passable.
     * @param tile Tile that's representing the chip challenge game.
     */

    //move left
    public void moveLeft(Tile[][] tile){
        if (isInBounds(x - 1, y, tile)){
            if (tile[y][x - 1].isPassableMonster()) {
                x--;
            }else{
                moveUp(tile);
                moveUp(tile);
            }
        }
    }

    /**
     * Moves the frog upward if the tile upward is passable,
     * otherwise the frog will move right if it's not passable.
     * @param tile Tile that's representing the chip challenge game.
     */
    //move up
    public void moveUp(Tile[][] tile){
        if (isInBounds(x, y - 1, tile)){
            if (tile[y - 1][x].isPassableMonster()) {
                y--;
            }else{
                moveRight(tile);
                moveRight(tile);
            }
        }
    }

    /**
     * Moves the frog downward if the tile downward is passable,
     * otherwise the frog will move left if it's not passable.
     * @param tile
     */
    //move down
    public void moveDown(Tile[][] tile){
        if (isInBounds(x, y + 1, tile)){
            if (tile[y + 1][x].isPassableMonster()){
                y++;
            }else{
                moveLeft(tile);
                moveLeft(tile);
            }
        }
    }

    //is in bounds
    public boolean isInBounds(int x, int y, Tile[][] tile){
        return (x >= 0 && x < tile[0].length && y >= 0 && y < tile.length);
    }



    //to string
    public String toString(){
        return "Frog";
    }
}
