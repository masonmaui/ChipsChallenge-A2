package com.example.group16a2;

import com.example.group16a2.Actors.*;
import com.example.group16a2.Items.CollectableItems;
import com.example.group16a2.Items.ItemLayer;
import com.example.group16a2.Tiles.Tile;
import com.example.group16a2.Tiles.TileLayer;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.util.Duration;
import javafx.scene.input.KeyCode;
import java.util.ArrayList;

public class MasonMain extends Application {

    private static final int WINDOW_WIDTH = 800;
    private static final int WINDOW_HEIGHT = 500;

    private int CANVAS_WIDTH;
    private int CANVAS_HEIGHT;

    // The width and height (in pixels) of each cell that makes up the game.
    private static final int GRID_CELL_WIDTH = 32;
    private static final int GRID_CELL_HEIGHT = 32;

    private Canvas canvas;

    private Timeline tickTimeline;

    private Tile[][] tile;
    private CollectableItems[][] items;
    private ArrayList<Actor> actors;

    private Player player;
    private PinkBall pinkBall;
    private int tickCounter;
    private int timeLimit;

    public void start(Stage primaryStage) {

        //making layers
        //initialising the different layers of the game
        TileLayer tilelayer = new TileLayer("Levels/Level1TileLayer.txt");
        ItemLayer itemLayer = new ItemLayer("Levels/Level1ItemLayer.txt");
        ActorLayer actorLayer = new ActorLayer("Levels/Level1ActorLayer.txt");
        tile = tilelayer.getTiles();
        items = itemLayer.getItems();
        actors = actorLayer.getActorList();
        player = actorLayer.getPlayer();

        //canvas adapts to the size of the tile layer
        CANVAS_HEIGHT = tile.length * GRID_CELL_HEIGHT;
        CANVAS_WIDTH = tile[0].length * GRID_CELL_WIDTH;

        Pane root = buildGUI();

        // Create a scene from the GUI
        Scene scene = new Scene(root, WINDOW_WIDTH, WINDOW_HEIGHT);

        // Register an event handler for key presses.
        // This causes the processKeyEvent method to be called each time a key is pressed.
        scene.addEventFilter(KeyEvent.KEY_PRESSED, event -> processKeyEvent(event));

        // Register a tick method to be called periodically.
        // Make a new timeline with one keyframe that triggers the tick method every half a second.
        tickTimeline = new Timeline(new KeyFrame(Duration.millis(500), event -> tick()));
        // Loop the timeline forever
        tickTimeline.setCycleCount(Animation.INDEFINITE);
        // We start the timeline upon a button press.

        // Display the scene on the stage
        drawGame();
        primaryStage.setScene(scene);
        primaryStage.show();

        // Update inventory display when the game starts
        updateInventoryDisplay();
    }


    //draws tiles on the canvas
    public void drawGame() {

        Image temp;
        // Get the Graphic Context of the canvas. This is what we draw on.
        GraphicsContext gc = canvas.getGraphicsContext2D();

        // Clear canvas
        gc.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());

        // Set the background to gray.
        gc.setFill(Color.GRAY);
        gc.fillRect(0, 0, canvas.getWidth(), canvas.getHeight());

        // Draw the tiles from each layer individually
        for (int i = 0; i < tile.length; i++) {
            for (int j = 0; j < tile[i].length; j++) {
                temp = new Image(tile[i][j].getFileName());
                gc.drawImage(temp, j * GRID_CELL_WIDTH, i * GRID_CELL_HEIGHT);
            }
        }

        //draw the items from the item layer
        for (int i = 0; i < items.length; i++) {
            for (int j = 0; j < items[i].length; j++) {
                if (items[i][j] != null && !items[i][j].isCollected()) {
                    temp = new Image(items[i][j].getFilename());
                    gc.drawImage(temp, j * GRID_CELL_WIDTH, i * GRID_CELL_HEIGHT);
                }
            }
        }

        //output the actors from the actor layer
        for (Actor actor : actors) {
            temp = new Image(actor.getFileName());
            gc.drawImage(temp, actor.getX() * GRID_CELL_WIDTH, actor.getY() * GRID_CELL_HEIGHT);
        }

    }

    public void tick(){
        //call pink ball bounce
        for (Actor actor : actors) {
            if (actor instanceof PinkBall) {
                ((PinkBall) actor).bounce(tile);
            }

        }
        //move every 3 ticks
        if(tickCounter % 2 == 0) {
            for (Actor actor : actors) {
                if (actor instanceof Frog) {
                    ((Frog) actor).findPath(player, tile);
                }

            }
        }
        drawGame();

        System.out.println(player.getInventory());
        tickCounter++;

    }

    public void processKeyEvent(KeyEvent event) {
        // We change the behaviour depending on the actual key that was pressed.
        switch (event.getCode()) {
            case RIGHT:
                player.moveRight(tile);
                break;
            case LEFT:
                player.moveLeft(tile);
                break;
            case UP:
                player.moveUp(tile);
                break;
            case DOWN:
                player.moveDown(tile);
                break;
            default:
                // Do nothing for all other keys.
                break;
        }

        if (event.getCode() == KeyCode.RIGHT || event.getCode() == KeyCode.LEFT ||
                event.getCode() == KeyCode.UP || event.getCode() == KeyCode.DOWN) {
            collectItems();
        }

        // Redraw game as the player may have moved.
        drawGame();

        // Consume the event. This means we mark it as dealt with. This stops other GUI nodes (buttons etc) responding to it.
        event.consume();
    }

    //takes items from the item layer and adds them to the player inventory
    private void collectItems() {
        int playerRow = player.getY();
        int playerCol = player.getX();

        if (items[playerRow][playerCol] != null && !items[playerRow][playerCol].isCollected()) {
            items[playerRow][playerCol].Action(); // Optionally, perform actions when the item is consumed
            items[playerRow][playerCol].addToPlayerInventory(player);

            // Update inventory display
            updateInventoryDisplay();
        }
    }
    private void updateInventoryDisplay() {
        ListView<Image> inventoryListView = (ListView<Image>) ((BorderPane) canvas.getParent()).getRight();
        inventoryListView.getItems().clear();
        inventoryListView.getItems().addAll(player.getInventory().getImages());
    }

    public void resetPlayerLocation() {
    }

    public void movePlayerToCenter() {
    }

    private Pane buildGUI() {
        // Create top-level panel that will hold all GUI nodes.
        BorderPane root = new BorderPane();

        // Create the canvas that we will draw on.
        // We store this as a gloabl variable so other methods can access it.
        canvas = new Canvas(CANVAS_WIDTH, CANVAS_HEIGHT);
        root.setCenter(canvas);

        // Create a toolbar with some nice padding and spacing
        HBox toolbar = new HBox();
        toolbar.setSpacing(10);
        toolbar.setPadding(new Insets(10, 10, 10, 10));
        root.setTop(toolbar);

        // Reset Player Location Button
        Button resetPlayerLocationButton = new Button("Reset Player");
        toolbar.getChildren().add(resetPlayerLocationButton);

        resetPlayerLocationButton.setOnAction(e -> {
            // We keep this method short and use a method for the bulk of the work.
            resetPlayerLocation();
        });

        // Center Player Button
        Button centerPlayerLocationButton = new Button("Center Player");
        toolbar.getChildren().add(centerPlayerLocationButton);

        // Setup the behaviour of the button.
        centerPlayerLocationButton.setOnAction(e -> {
            // We keep this method short and use a method for the bulk of the work.
            movePlayerToCenter();
        });

        // Tick Timeline buttons
        Button startTickTimelineButton = new Button("Start Ticks");
        Button stopTickTimelineButton = new Button("Stop Ticks");
        // We add both buttons at the same time to the timeline (we could have done this in two steps).
        toolbar.getChildren().addAll(startTickTimelineButton, stopTickTimelineButton);
        // Stop button is disabled by default
        stopTickTimelineButton.setDisable(true);

        // Setup the behaviour of the buttons.
        startTickTimelineButton.setOnAction(e -> {
            // Start the tick timeline and enable/disable buttons as appropriate.
            startTickTimelineButton.setDisable(true);
            tickTimeline.play();
            stopTickTimelineButton.setDisable(false);
        });

        stopTickTimelineButton.setOnAction(e -> {
            // Stop the tick timeline and enable/disable buttons as appropriate.
            stopTickTimelineButton.setDisable(true);
            tickTimeline.stop();
            startTickTimelineButton.setDisable(false);
        });

        ListView<Image> inventoryListView = new ListView<>();
        root.setRight(inventoryListView);

        // Set a custom cell factory to display images
        inventoryListView.setCellFactory(param -> new ListCell<Image>() {
            private final ImageView imageView = new ImageView();

            @Override
            protected void updateItem(Image item, boolean empty) {
                super.updateItem(item, empty);

                if (empty || item == null) {
                    setGraphic(null);
                } else {
                    imageView.setImage(item);
                    imageView.setFitWidth(32); // Set the width of the image
                    imageView.setFitHeight(32); // Set the height of the image
                    setGraphic(imageView);
                }
            }
        });

        // Update inventory display when needed
        inventoryListView.getItems().addAll(player.getInventory().getImages());

        return root;
    }

    public static void main(String[] args) {
        launch(args);
    }
}