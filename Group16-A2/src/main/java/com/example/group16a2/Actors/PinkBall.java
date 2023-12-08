package com.example.group16a2.Actors;

import com.example.group16a2.Tiles.Tile;

public class PinkBall extends Actor{
    private String pinkBall;
    private String filename;

    private String Direction;

    private int x;
    private int y;

    public PinkBall(int y, int x, String direction) {
        super(y, x, "file:Sprites/Ball.png");
        this.filename = "file:Sprites/Ball.png";
        if (direction.equals(("N")))
            this.Direction = "N";
        else if (direction.equals(("S")))
            this.Direction = "S";
        else if (direction.equals(("E")))
            this.Direction = "E";
        else if (direction.equals(("W")))
            this.Direction = "W";
        else
            this.Direction = "N";
        this.x = x;
        this.y = y;
    }

    //get x
    public int getX(){
        return x;
    }

    //get y
    public int getY(){
        return y;
    }

    public void bounce(Tile[][] tiles){
        if(Direction.equals("N")){
            if(isInBounds(x, y - 1, tiles)){
                if(tiles[y - 1][x].isPassable()){
                    y--;
                }
                else{
                    Direction = "S";
                }
            }
            else{
                Direction = "S";
            }
        }
        else if(Direction.equals("S")){
            if(isInBounds(x, y + 1, tiles)){
                if(tiles[y + 1][x].isPassable()){
                    y++;
                }
                else{
                    Direction = "N";
                }
            }
            else{
                Direction = "N";
            }
        }
        else if(Direction.equals("E")){
            if(isInBounds(x + 1, y, tiles)){
                if(tiles[y][x + 1].isPassable()){
                    x++;
                }
                else{
                    Direction = "W";
                }
            }
            else{
                Direction = "W";
            }
        }
        else if(Direction.equals("W")){
            if((isInBounds(x - 1, y, tiles)) && (tiles[y][x - 1].isPassable())){
                    x--;
                }
            }else{
                Direction = "E";
            }
    }

    //is in bounds
    public boolean isInBounds(int x, int y, Tile[][] tile){
        return (x >= 0 && x < tile[0].length && y >= 0 && y < tile.length);
    }

    //to string
    public String toString(){
        if(Direction.equals("N"))
            return "PinkBall N";
        else if(Direction.equals("S"))
            return "PinkBall S";
        else if(Direction.equals("E"))
            return "PinkBall E";
        else if(Direction.equals("W"))
            return "PinkBall W";
        else
            return "PinkBall N";
    }
}
