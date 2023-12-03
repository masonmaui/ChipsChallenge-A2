package com.example.group16a2;

import com.example.group16a2.Tiles.TileLayer;

public class Game {
    //When a new game controller is made it will need to read the corrosponding layers' instances.
    private TileLayer   TileLayer;
    private ItemLayer   ItemLayer;
    private Actor       ActorLayer;
    private int currentlevel;

    //When actor layer is made replace actor with ActorLayer
    public Game(TileLayer TileLayer, ItemLayer ItemLayer, Actor ActorLayer, int currentlevel){
        this.TileLayer  =   TileLayer;
        this.ItemLayer  =   ItemLayer;
        this.ActorLayer =   ActorLayer;
        this.currentlevel = currentlevel;
    }

    public void CheckForAnyCollisions(){
        if (this.checkBugCollisions()){
            this.GameOver();
        }
    }

    public Boolean checkBugCollisions(){
        //for each bug in actor class
        //if bug.getGeposition == player.getPosition then true, else:
        return false;
    }

    public void GameOver(){
        //This will interact with menu to display the new game.
        //new Game(load next tiles, this.currentLevel+1)
    }
}
