package com.example.group16a2.Actors;

import com.example.group16a2.Items.PlayerInventory;
import com.example.group16a2.MasonMain;
import com.example.group16a2.Tiles.*;

import java.util.ArrayList;

public class Player extends Actor{
    private String player;
    private PlayerInventory inventory;
    private int[] inv;
    private String filename;
    private int x;
    private int y;

    public Player(int y, int x){
        super(y, x, "file:Sprites/PlayerTrans.png");
        this.filename = "file:Sprites/PlayerTrans.png";
        //grab values from super
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
                y++;
            }
        }
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

    //to string
    public String toString(){
        return "Player";
    }
}
