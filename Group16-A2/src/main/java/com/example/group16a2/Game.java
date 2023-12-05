package com.example.group16a2;

import com.example.group16a2.Tiles.Tile;
import com.example.group16a2.Tiles.TileLayer;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;

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

    public Game(TileLayer Tilelayer){
        this.TileLayer = TileLayer;
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

    //read in tiles to make game on screen
    public void showScreen (Stage stage){
        GridPane grid = new GridPane();
        Tile[][] tiles = this.TileLayer.getTiles(); // Assuming you have a method to get the tiles

        for (int i = 0; i < tiles.length; i++) {
            for (int j = 0; j < tiles[i].length; j++) {
                Image image = new Image(tiles[i][j].getFileName()); // Assuming getFilepath() returns the image file path
                ImageView imageView = new ImageView(image);
                grid.add(imageView, j, i);
            }
        }

        Scene scene = new Scene(grid);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {

    }
}
