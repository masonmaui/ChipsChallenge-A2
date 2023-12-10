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
    public int getX(){
        return x;
    }

    public int getY(){
        return y;
    }

    //move right
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
                }
                x++;
            }
        }
    }

    //move left
    public void moveLeft(Tile[][] tile){
        if (isInBounds(x - 1, y, tile)){
            if (tile[y][x - 1].isPassable()){
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
                }
                x--;
            }
        }
    }

    //move up
    public void moveUp(Tile[][] tile){
        if (isInBounds(x, y - 1, tile)){
            if (tile[y - 1][x].isPassable()){
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
                }
                y--;
            }
        }
    }

    //move down
    public void moveDown(Tile[][] tile){
        if (isInBounds(x, y + 1, tile)){
            if (tile[y + 1][x].isPassable()){
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
                }
                y++;
            }
        }
    }

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
    public boolean isKilled(ArrayList<Actor> actors){
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
