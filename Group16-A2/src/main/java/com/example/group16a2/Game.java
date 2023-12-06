package com.example.group16a2;

import com.example.group16a2.Actors.*;
import com.example.group16a2.Items.Chip;
import com.example.group16a2.Items.CollectableItems;
import com.example.group16a2.Items.ItemLayer;
import com.example.group16a2.Items.Key;
import com.example.group16a2.Tiles.*;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Game extends Application {

    private TileLayer tileLayer;
    private ItemLayer itemLayer;
    private ActorLayer actorLayer;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        tileLayer = new TileLayer("Levels/Level1TileLayer.txt");
        itemLayer = new ItemLayer("Levels/Level1ItemLayer.txt");
        actorLayer = new ActorLayer("Levels/Level1ActorLayer.txt");

        GridPane gridPane = createGridPane();
        Scene scene = new Scene(gridPane);

        primaryStage.setTitle("Tile Game");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private GridPane createGridPane() {
        GridPane gridPane = new GridPane();

        for (int i = 0; i < tileLayer.getTiles().length; i++) {
            for (int j = 0; j < tileLayer.getTiles()[i].length; j++) {
                Image tileImage = getTileImage(tileLayer.getTiles()[i][j]);
                ImageView imageView = new ImageView(tileImage);
                gridPane.add(imageView, j, i);
            }
        }

        for (int i = 0; i < itemLayer.getItems().length; i++) {
            for (int j = 0; j < itemLayer.getItems()[i].length; j++) {
                Image itemImage = getItemImage(itemLayer.getItems()[i][j]);
                ImageView imageView = new ImageView(itemImage);
                gridPane.add(imageView, j, i);
            }
        }

        for (int i = 0; i < actorLayer.getActors().length; i++) {
            for (int j = 0; j < actorLayer.getActors()[i].length; j++) {
                Image actorImage = getActorImage(actorLayer.getActors()[i][j]);
                ImageView imageView = new ImageView(actorImage);
                gridPane.add(imageView, j, i);
            }
        }
        return gridPane;
    }

    private Image getTileImage(Tile tile) {
        if (tile instanceof Button) {
            return new Image("file:Sprites/Button.png");
        }
        else if (tile instanceof ChipSocket) {
            return new Image("file:Sprites/ChipSocket.png");
        }
        else if (tile instanceof Dirt) {
            return new Image("file:Sprites/Dirt.png");
        }
        else if (tile instanceof Exit) {
            return new Image("file:Sprites/Ice.png");
        }
        else if (tile instanceof Ice) {
            return new Image("file:Sprites/Dirt.png");
        }
        else if (tile instanceof IceBottomLeft) {
            return new Image("file:Sprites/IceBottomLeft.png");
        }
        else if (tile instanceof IceBottomRight) {
            return new Image("file:Sprites/IceBottomRight.png");
        }
        else if (tile instanceof IceTopLeft) {
            return new Image("file:Sprites/IceTopLeft.png");
        }
        else if (tile instanceof IceTopRight) {
            return new Image("file:Sprites/IceTopRight.png");
        }
        else if (tile instanceof LockedDoorBlue) {
            return new Image("file:Sprites/BlueLock.png");
        }
        else if (tile instanceof LockedDoorGreen) {
            return new Image("file:Sprites/GreenLock.png");
        }
        else if (tile instanceof LockedDoorRed) {
            return new Image("file:Sprites/RedLock.png");
        }
        else if (tile instanceof LockedDoorYellow) {
            return new Image("file:Sprites/YellowLock.png");
        }
        else if (tile instanceof Path) {
            return new Image("file:Sprites/Path.png");
        }
        else if (tile instanceof Trap) {
            return new Image("file:Sprites/Trap.png");
        }
        else if (tile instanceof Wall) {
            return new Image("file:Sprites/Wall.png");
        }
        else if (tile instanceof Water) {
            return new Image("file:Sprites/Water.png");
        }
        else {
            return null;
        }
    }

    private Image getItemImage(CollectableItems items) {
        if (items instanceof Key) {
            Key key = (Key) items;
            return getKeyImage(key.getType());
        }
        if (items instanceof Chip) {
            return new Image("file:Sprites/Chip.png");
        } else {
            return null;
        }
    }

    private Image getActorImage(Actor actor) {
        if (actor instanceof Player) {
            return new Image("file:Sprites/Actor.png");
        }
        else if (actor instanceof Block) {
            return new Image("file:Sprites/Block.png");
        }
        //Bugs have different direction need to change images to switch directions
        else if (actor instanceof Bug) {
            return new Image("file:Sprites/BugDown.png");
        }
        else if (actor instanceof Frog) {
            return new Image("file:Sprites/Frog.png");
        }
        //Ball has different starting movements need to change for different directions
        else if (actor instanceof PinkBall) {
            return new Image("file:Sprites/Ball.png");
        }
        else {
            return null;
        }
    }
    private Image getKeyImage(String color) {
        switch (color) {
            case "r":
                return new Image("file:Sprites/RedKey.png");
            case "b":
                return new Image("file:Sprites/BlueKey.png");
            case "y":
                return new Image("file:Sprites/YellowKey.png");
            case "g":
                return new Image("file:Sprites/GreenKey.png");
            default:
                return null;
        }
    }
}