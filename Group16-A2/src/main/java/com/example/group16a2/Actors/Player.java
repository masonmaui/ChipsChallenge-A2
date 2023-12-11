package com.example.group16a2.Actors;

import com.example.group16a2.Items.*;
import com.example.group16a2.Tiles.*;
import com.example.group16a2.Tiles.ChipSocket;

import java.util.ArrayList;
/**
 *
 * Player.java
 * Represents the player
 * Handles player movement
 * Handles interactions with other actors and items
 * @author Mason Emery
 * @author James Buckley
 * @version 1.6
 */
public class Player extends Actor{
    private PlayerInventory inventory;
    private int x;
    private int y;

    /**
     * class constructor
     * @param y represents y co-ordinate of player
     * @param x represents x co-ordinate of player
     */
    public Player(int y, int x) {
        super(y, x, "file:Sprites/Actor.png");
        this.x = x;
        this.y = y;
        this.inventory = new PlayerInventory();
    }

    /**
     * gets inventory
     * @return an instance of playerInventory
     */

    public PlayerInventory getInventory() {
        return inventory;
    }

    /**
     * gets x co-ordinate of player
     * @return x x co-ordinate of player
     */
    //overide super getx and gety
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

    /**
     * moves player one tile to the right
     * @param tile represents the grid of tiles
     */
    //move right
    public void moveRight(Tile[][] tile){
        if (isInBounds(x + 1, y, tile)){
            if (tile[y][x + 1].isPassable()){
                if (isDirt(tile)){
                    //change tile in that position to be path
                    tile[y][x] = new Path(true);
                    x++;
                }else if (isLockedDoorBlue(tile)){
                    //change tile in that position to be path
                    tile[y][x] = new Path(true);
                    x++;
                }else if (isLockedDoorRed(tile)){
                    //change tile in that position to be path
                    tile[y][x] = new Path(true);
                    x++;
                }else if (isLockedDoorGreen(tile)){
                    //change tile in that position to be path
                    tile[y][x] = new Path(true);
                    x++;
                }else if (isLockedDoorYellow(tile)){
                    //change tile in that position to be path
                    tile[y][x] = new Path(true);
                    x++;
                }else if (isChipSocket(tile)){
                    //change tile in that position to be path
                    tile[y][x] = new Path(true);
                    x++;
                }else if (tile[y][x + 1] instanceof Ice){
                    if (tile[y][x + 1] instanceof Wall) {
                        moveLeft(tile);
                    }else {
                        x++;
                        moveRight(tile);
                    }
                }else if (tile[y][x + 1] instanceof IceTopRight){
                    if (tile[y][x + 1] instanceof Wall) {
                        moveUp(tile);
                    }else {
                        x++;
                        moveDown(tile);
                    }
                }
                else if (tile[y][x + 1] instanceof IceTopLeft){

                }
                else if (tile[y][x + 1] instanceof IceBottomLeft){
                }
                else if (tile[y][x + 1] instanceof IceBottomRight){
                    if (tile[y][x + 1] instanceof Wall) {
                        moveDown(tile);
                    }else {
                        x++;
                        moveUp(tile);
                    }
                }else {
                    x++;
                }
            }
        }
    }

    /**
     * moves player one tile to the left
     * @param tile represents the grid of tiles
     */
    //move left
    public void moveLeft(Tile[][] tile){
        if (isInBounds(x - 1, y, tile)){
            if (tile[y][x - 1].isPassable()){
                if (isDirt(tile)){
                    //change tile in that position to be path
                    tile[y][x] = new Path(true);
                    x--;
                }else if (isLockedDoorBlue(tile)){
                    //change tile in that position to be path
                    tile[y][x] = new Path(true);
                    y--;
                }else if (isLockedDoorRed(tile)){
                    //change tile in that position to be path
                    tile[y][x] = new Path(true);
                    x--;
                }else if (isLockedDoorGreen(tile)){
                    //change tile in that position to be path
                    tile[y][x] = new Path(true);
                    x--;
                }else if (isLockedDoorYellow(tile)){
                    //change tile in that position to be path
                    tile[y][x] = new Path(true);
                    x--;
                }else if (isChipSocket(tile)){
                    //change tile in that position to be path
                    tile[y][x] = new Path(true);
                    x--;
                }else if (tile[y][x - 1] instanceof Ice) {
                    if (tile[y][x - 2] instanceof Wall) {
                        moveRight(tile);
                    }else {
                        x--;
                        moveLeft(tile);
                    }
                }else if (tile[y][x - 1] instanceof IceTopRight){
                }
                else if (tile[y][x - 1] instanceof IceTopLeft){
                    if (tile[y][x - 1] instanceof Wall) {
                        moveUp(tile);
                    }else {
                        x--;
                        moveDown(tile);
                    }
                }
                else if (tile[y][x - 1] instanceof IceBottomLeft){
                    if(tile[y][x - 1] instanceof Wall) {
                        moveDown(tile);
                    }else {
                        x--;
                        moveUp(tile);
                    }
                }
                else if (tile[y][x - 1] instanceof IceBottomRight){
                }else {
                    x--;
                }
            }
        }
    }

    /**
     * moves player one tile up
     * @param tile represents the grid of tiles
     */
    public void moveUp(Tile[][] tile){
        if (isInBounds(x, y - 1, tile)){
            if (tile[y - 1][x].isPassable()){
                if (isDirt(tile)){
                    //change tile in that position to be path
                    tile[y][x] = new Path(true);
                    y--;
                }else if (isLockedDoorBlue(tile)){
                    //change tile in that position to be path
                    tile[y][x] = new Path(true);
                    y--;
                }else if (isLockedDoorRed(tile)){
                    //change tile in that position to be path
                    tile[y][x] = new Path(true);
                    y--;
                }else if (isLockedDoorGreen(tile)){
                    //change tile in that position to be path
                    tile[y][x] = new Path(true);
                    y--;
                }else if (isLockedDoorYellow(tile)){
                    //change tile in that position to be path
                    tile[y][x] = new Path(true);
                    y--;
                }else if (isChipSocket(tile)){
                    //change tile in that position to be path
                    tile[y][x] = new Path(true);
                    y--;
                }else if (tile[y - 1][x] instanceof Ice){
                    if (tile[y - 2][x] instanceof Wall) {
                        moveDown(tile);
                    }else {
                        y--;
                        moveUp(tile);
                    }
                }else if (tile[y - 1][x] instanceof IceTopRight){
                    if (tile[y - 1][x] instanceof Wall) {
                        moveRight(tile);
                    }else {
                        y--;
                        moveLeft(tile);
                    }
                }
                else if (tile[y - 1][x] instanceof IceTopLeft){
                    if (tile[y - 1][x] instanceof Wall) {
                        moveLeft(tile);
                    }else {
                        y--;
                        moveRight(tile);
                    }
                }
                else if (tile[y - 1][x] instanceof IceBottomLeft){
                }
                else if (tile[y - 1][x] instanceof IceBottomRight) {
                }else {
                    y--;
                }
            }
        }
    }

    /**
     * move player one tile down
     * @param tile represents the grid of tiles
     */
    //move down
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
                    if(tile[y + 2][x] instanceof Wall) {
                        moveUp(tile);
                    }else {
                        y++;
                        moveDown(tile);
                    }
                }else if (tile[y + 1][x] instanceof IceTopRight){
                }
                else if (tile[y + 1][x] instanceof IceTopLeft){
                }
                else if (tile[y + 1][x] instanceof IceBottomLeft){
                    if (tile[y + 1][x] instanceof Wall) {
                        moveLeft(tile);
                    }else {
                        y++;
                        moveRight(tile);
                    }
                }
                else if (tile[y + 1][x] instanceof IceBottomRight){
                    if(tile[y + 1][x] instanceof Wall){
                        moveRight(tile);
                    }else {
                        y++;
                        moveLeft(tile);
                    }
                }else {
                    y++;
                }
            }
        }
    }

    /**
     * checks if player is on the same tile as a door or chip socket
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
            ChipSocket chipSocket = (ChipSocket) tile;
            if (chipSocket.getChipsRequired() == 1) {
                handleChipSocketInteraction(chipSocket);

            } else if (chipSocket.getChipsRequired() == 2) {
                handleChipSocketInteraction(chipSocket);
                handleChipSocketInteraction(chipSocket);

            } else if (chipSocket.getChipsRequired() == 3) {
                handleChipSocketInteraction(chipSocket);
                handleChipSocketInteraction(chipSocket);
                handleChipSocketInteraction(chipSocket);
            }
        }
    }

    public void handleLockedDoorBlueInteraction(LockedDoorBlue lockedDoorBlue) {
        if (inventoryContainsBlueKey()) {
            BlueKey blueKey = inventory.findAndRemoveBlueKey();
        }
    }

    private void handleLockedDoorRedInteraction(LockedDoorRed lockedDoorRed) {
        if (inventoryContainsRedKey()) {
            RedKey redKey = inventory.findAndRemoveRedKey();
        }
    }

    private void handleLockedDoorGreenInteraction(LockedDoorGreen lockedDoorGreen) {
        if (inventoryContainsGreenKey()) {
            GreenKey greenKey = inventory.findAndRemoveGreenKey();
        }
    }

    private void handleLockedDoorYellowInteraction(LockedDoorYellow lockedDoorYellow) {
        if (inventoryContainsYellowKey()) {
            YellowKey yellowKey = inventory.findAndRemoveYellowKey();
        }
    }

    public void handleChipSocketInteraction(ChipSocket chipSocket) {
        if (inventoryContainsChip()) {
            Chip chip = inventory.findAndRemoveChip();
        }
    }

    /**
     * checks if inventory contains a blue key
     * @return true if inventory contains blue key
     */
    public boolean inventoryContainsBlueKey() {
        return inventory.containsBlueKey();
    }
    /**
     * checks if inventory contains a red key
     * @return true if inventory contains red key
     */
    public boolean inventoryContainsRedKey() {
        return inventory.containsRedKey();
    }
    /**
     * checks if inventory contains a green key
     * @return true if inventory contains green key
     */
    public boolean inventoryContainsGreenKey() {
        return inventory.containsGreenKey();
    }
    /**
     * checks if inventory contains a yellow key
     * @return true if inventory contains yellow key
     */
    public boolean inventoryContainsYellowKey() {
        return inventory.containsYellowKey();
    }
    /**
     * checks if inventory contains a computer chip
     * @return true if inventory contains computer chip
     */
    public boolean inventoryContainsChip() {
        return inventory.containsChip();
    }

    //is in bounds

    /**
     * checks if tile to be moved to is in bounds
     * @param x represents the x co-ordinate of the player
     * @param y represents the y co-ordinate of the player
     * @param tile represents the grid of tiles
     * @return true if tile to be moved to is in bounds, false otherwise
     */
    public boolean isInBounds(int x, int y, Tile[][] tile){
        return (x >= 0 && x < tile[0].length && y >= 0 && y < tile.length);
    }

    /**
     * Checks if player is on same tile as a monster or water
     * @param actors represents a list of actors
     * @param tile represents the grid of tiles
     * @return true if player is on same tile as monster/water, false otherwise
     */
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

    /**
     * checks if game has been won
     * @param tile represents a grid of tiles
     * @return true if player is on exit, false otherwise
     */
    //check if won
    public boolean isWon(Tile[][] tile){
        return tile[y][x] instanceof Exit;
    }

    /**
     * checks if tile is dirt
     * @param tile represents a grid of tiles
     * @return true if tile is dirt, false otherwise
     */
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

    public void checkBlock(ArrayList<Actor>actors, String direction, Tile[][] tile){
        for (Actor actor : actors){
            if (actor instanceof Block){
                if (direction.equals("right")){
                    if (actor.getX() == this.getX() && actor.getY() == this.getY()){
                        ((Block) actor).moveRight(tile);
                    }
                }else if (direction.equals("left")){
                    if (actor.getX() == this.getX() && actor.getY() == this.getY()){
                        ((Block) actor).moveLeft(tile);
                    }
                }else if (direction.equals("up")){
                    if (actor.getX() == this.getX() && actor.getY() == this.getY()){
                        ((Block) actor).moveUp(tile);
                    }
                }else if (direction.equals("down")){
                    if (actor.getX() == this.getX() && actor.getY() == this.getY()){
                        ((Block) actor).moveDown(tile);
                    }
                }
            }
        }

    }

    //to string

    /**
     * Returns a string representing the class
     * @return a string giving name of class
     */
    public String toString(){
        return "Player";
    }
}
