package com.example.group16a2.Actors;

import com.example.group16a2.Tiles.Tile;

public class Bug extends Actor{

    private String filename;
    private int x;
    private int y;

    public Bug(int y, int x){
        super(y, x, "file:Sprites/BugUp.png");
        this.filename = "file:Sprites/BugUp.png";
        this.x = x;
        this.y = y;
    }

    //get file name
    public String getFileName(){
        return filename;
    }

    //get x
    public int getX(){
        return x;
    }

    //get y
    public int getY(){
        return y;
    }

    //bug needs to follow an edge of passable tiles
    public void move(Tile[][] tile){
        if (isInBounds(x + 1, y, tile)){
            if (tile[y][x + 1].isPassableMonster()){
                x++;
                filename = "file:Sprites/BugRight.png";
            }
        }
        else if (isInBounds(x - 1, y, tile)){
            if (tile[y][x - 1].isPassableMonster()){
                x--;
                filename = "file:Sprites/BugLeft.png";
            }
        }
        else if (isInBounds(x, y + 1, tile)){
            if (tile[y + 1][x].isPassableMonster()){
                y++;
                filename = "file:Sprites/BugDown.png";
            }
        }
        else if (isInBounds(x, y - 1, tile)){
            if (tile[y - 1][x].isPassableMonster()){
                y--;
                filename = "file:Sprites/BugUp.png";
            }
        }
    }

    //is in bounds
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
