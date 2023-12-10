package com.example.group16a2.Actors;

import com.example.group16a2.Items.*;
import com.example.group16a2.Tiles.*;
import com.example.group16a2.Tiles.ChipSocket;

import java.util.ArrayList;

public class Player extends Actor{
    private PlayerInventory inventory;
    private int x;
    private int y;

    public Player(int y, int x) {
        super(y, x, "file:Sprites/Actor.png");
        this.x = x;
        this.y = y;
        this.inventory = new PlayerInventory();
    }
    public PlayerInventory getInventory() {
        return inventory;
    }

    //overide super getx and gety

    /**
     * gets x co-ordinate of player
     * @return x x co-ordinate of player
     */
    public int getX(){
        return x;
    }
    /**
     * gets y co-ordinate of player
     * @return y y co-ordinate of player
     */
    public int getY(){
        return y;
    }

    //move right

    /**
     * move player one tile to the right
     * @param tile represents the grid of tiles
     */
    public void moveRight(Tile[][] tile){
        if (isInBounds(x + 1, y, tile)){
            if (tile[y][x + 1].isPassable()){
                if (isDirt(tile)){
                    //change tile in that position to be path
                    tile[y][x] = new Path(true);
                }
                else if (isLockedDoorBlue(tile)){
                    //change tile in that position to be path
                    tile[y][x] = new Path(true);
                }
                else if (isLockedDoorRed(tile)){
                    //change tile in that position to be path
                    tile[y][x] = new Path(true);
                }
                else if (isLockedDoorGreen(tile)){
                    //change tile in that position to be path
                    tile[y][x] = new Path(true);
                }
                else if (isLockedDoorYellow(tile)){
                    //change tile in that position to be path
                    tile[y][x] = new Path(true);
                }
                else if (isChipSocket(tile)){
                    //change tile in that position to be path
                    tile[y][x] = new Path(true);
                }else if (tile[y][x + 1] instanceof Ice){
                    //change tile in that position to be path
                    x++;
                }
                x++;
            }
        }
    }

    //move left
    /**
     * move player one tile to the left
     * @param tile represents the grid of tiles
     */
    public void moveLeft(Tile[][] tile){
        if (isInBounds(x - 1, y, tile)){
            if (tile[y][x - 1].isPassable()){
                if (isDirt(tile)){
                    //change tile in that position to be path
                    tile[y][x] = new Path(true);
                    x--;
                }
                else if (isLockedDoorBlue(tile)){
                    //change tile in that position to be path
                    tile[y][x] = new Path(true);
                    x--;
                }
                else if (isLockedDoorRed(tile)){
                    //change tile in that position to be path
                    tile[y][x] = new Path(true);
                    x--;
                }
                else if (isLockedDoorGreen(tile)){
                    //change tile in that position to be path
                    tile[y][x] = new Path(true);
                    x--;
                }
                else if (isLockedDoorYellow(tile)){
                    //change tile in that position to be path
                    tile[y][x] = new Path(true);
                    x--;
                }
                else if (isChipSocket(tile)) {
                    //change tile in that position to be path
                    tile[y][x] = new Path(true);
                    x--;
                }else{
                    x--;
                }
            }
        }
    }

    //move up
    /**
     * move player one tile up
     * @param tile represents the grid of tiles
     */
    public void moveUp(Tile[][] tile){
        if (isInBounds(x, y - 1, tile)){
            if (tile[y - 1][x].isPassable()){
                if (isDirt(tile)){
                    //change tile in that position to be path
                    tile[y][x] = new Path(true);
                }else if (isLockedDoorBlue(tile)){
                    //change tile in that position to be path
                    tile[y][x] = new Path(true);
                }else if (isLockedDoorRed(tile)){
                    //change tile in that position to be path
                    tile[y][x] = new Path(true);
                }else if (isLockedDoorGreen(tile)){
                    //change tile in that position to be path
                    tile[y][x] = new Path(true);
                }else if (isLockedDoorYellow(tile)){
                    //change tile in that position to be path
                    tile[y][x] = new Path(true);
                }else if (isChipSocket(tile)){
                    //change tile in that position to be path
                    tile[y][x] = new Path(true);
                }else if (tile[y - 1][x] instanceof Ice){
                    y--;
                }
                y--;
            }
        }
    }

    //move down
    /**
     * move player one tile down
     * @param tile represents the grid of tiles
     */
    public void moveDown(Tile[][] tile){
        if (isInBounds(x, y + 1, tile)){
            if (tile[y + 1][x].isPassable()){
                if (isDirt(tile)){
                    //change tile in that position to be path
                    tile[y][x] = new Path(true);
                    y++;
                }else if (isLockedDoorBlue(tile)){
                    //change tile in that position to be path
                    tile[y][x] = new Path(true);
                    y++;
                }else if (isLockedDoorRed(tile)){
                    //change tile in that position to be path
                    tile[y][x] = new Path(true);
                    y++;
                }else if (isLockedDoorGreen(tile)){
                    //change tile in that position to be path
                    tile[y][x] = new Path(true);
                    y++;
                }else if (isLockedDoorYellow(tile)){
                    //change tile in that position to be path
                    tile[y][x] = new Path(true);
                    y++;
                }else if (isChipSocket(tile)){
                    //change tile in that position to be path
                    tile[y][x] = new Path(true);
                    y++;
                }else if (tile[y + 1][x] instanceof Ice){
                    y++;
                    moveDown(tile);
                }else {
                    y++;
                }
            }
        }
    }

    /**
     * Determines if player is on the same tile as a door or chip socket
     * @param tile represents the grid of tiles
     */
    public void handlePlayerInteraction(Tile tile) {
        if (tile instanceof LockedDoorBlue) {
            handleLockedDoorBlueInteraction((LockedDoorBlue) tile);
        } else if (tile instanceof LockedDoorRed) {
            handleLockedDoorRedInteraction((LockedDoorRed) tile);
        } else if (tile instanceof LockedDoorGreen) {
            handleLockedDoorGreenInteraction((LockedDoorGreen) tile);
        } else if (tile instanceof LockedDoorYellow) {
            handleLockedDoorYellowInteraction((LockedDoorYellow) tile);
        } else if (tile instanceof ChipSocket) {
            handleChipSocketInteraction((ChipSocket) tile);
        }
    }

    /**
     * Determines if there is a blue key in inventory
     * @param lockedDoorBlue represents an instance of LockedDoorBlue
     */
    public void handleLockedDoorBlueInteraction(LockedDoorBlue lockedDoorBlue) {
        if (inventoryContainsBlueKey()) {
            BlueKey blueKey = inventory.findAndRemoveBlueKey();
        }
    }
    /**
     * Determines if there is a red key in inventory
     * @param lockedDoorRed represents an instance of LockedDoorBlue
     */
    private void handleLockedDoorRedInteraction(LockedDoorRed lockedDoorRed) {
        if (inventoryContainsRedKey()) {
            RedKey redKey = inventory.findAndRemoveRedKey();
        }
    }
    /**
     * Determines if there is a green key in inventory
     * @param lockedDoorGreen represents an instance of LockedDoorBlue
     */
    private void handleLockedDoorGreenInteraction(LockedDoorGreen lockedDoorGreen) {
        if (inventoryContainsGreenKey()) {
            GreenKey greenKey = inventory.findAndRemoveGreenKey();
        }
    }
    /**
     * Determines if there is a yellow key in inventory
     * @param lockedDoorYellow represents an instance of LockedDoorBlue
     */
    private void handleLockedDoorYellowInteraction(LockedDoorYellow lockedDoorYellow) {
        if (inventoryContainsYellowKey()) {
            YellowKey yellowKey = inventory.findAndRemoveYellowKey();
        }
    }

    /**
     * Determines if there is a chip in inventory
     * @param chipSocket represents an instance of chip socket
     */
    public void handleChipSocketInteraction(ChipSocket chipSocket) {
        if (inventoryContainsChip()) {
            Chip chip = inventory.findAndRemoveChip();
        }
    }

    public boolean inventoryContainsBlueKey() {
        return inventory.containsBlueKey();
    }

    public boolean inventoryContainsRedKey() {
        return inventory.containsRedKey();
    }

    public boolean inventoryContainsGreenKey() {
        return inventory.containsGreenKey();
    }

    public boolean inventoryContainsYellowKey() {
        return inventory.containsYellowKey();
    }

    public boolean inventoryContainsChip() {
        return inventory.containsChip();
    }

    //is in bounds
    public boolean isInBounds(int x, int y, Tile[][] tile){
        return (x >= 0 && x < tile[0].length && y >= 0 && y < tile.length);
    }

    //check if player is in same tile as frog or ball or bug
    public boolean isKilled(ArrayList<Actor> actors, Tile[][] tile){
        for (Actor actor : actors){
            if (actor instanceof Frog){
                if (actor.getX() == this.getX() && actor.getY() == this.getY()){
                    return true;
                }
            }else if (actor instanceof PinkBall){
                if (actor.getX() == this.getX() && actor.getY() == this.getY()){
                    return true;
                }
            }else if (actor instanceof Bug){
                if (actor.getX() == this.getX() && actor.getY() == this.getY()){
                    return true;
                }
            }else if (tile[y][x] instanceof Water){
                return true;
            }
        }
        return false;
    }

    //check if won
    public boolean isWon(Tile[][] tile){
        return tile[y][x] instanceof Exit;
    }

    //check if next tile is dirt
    public boolean isDirt(Tile[][] tile){
        return tile[y][x] instanceof Dirt;
    }

    public boolean isLockedDoorBlue(Tile[][] tile){
        return tile[y][x] instanceof LockedDoorBlue;
    }

    public boolean isLockedDoorYellow(Tile[][] tile){
        return tile[y][x] instanceof LockedDoorYellow;
    }

    public boolean isLockedDoorRed(Tile[][] tile){
        return tile[y][x] instanceof LockedDoorRed;
    }

    public boolean isLockedDoorGreen(Tile[][] tile){
        return tile[y][x] instanceof LockedDoorGreen;
    }

    public boolean isChipSocket(Tile[][] tile){
        return tile[y][x] instanceof ChipSocket;
    }

    //to string
    public String toString(){
        return "Player";
    }
}
