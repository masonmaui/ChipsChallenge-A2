package com.example.group16a2;

import com.example.group16a2.Actors.*;
import com.example.group16a2.Items.CollectableItems;
import com.example.group16a2.Items.InventoryUpdateListener;
import com.example.group16a2.Tiles.*;
import com.example.group16a2.Items.ItemLayer;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.util.Duration;
import javafx.scene.input.KeyCode;
import java.util.ArrayList;


public class MasonMain extends Application implements InventoryUpdateListener {

    private final Profile profile;

    private static final int WINDOW_WIDTH = 1200;
    private static final int WINDOW_HEIGHT = 800;

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
    private int level = 5;

    public MasonMain() {
        this.profile = null;
    }
    public MasonMain(Profile profile){
        this.profile = profile;
    }
    public void start(Stage primaryStage) {

        //making layers
        //initialising the different layers of the game
        TileLayer tilelayer = new TileLayer("Levels/Level" + level +"TileLayer.txt");
        ItemLayer itemLayer = new ItemLayer("Levels/Level" + level + "ItemLayer.txt");
        ActorLayer actorLayer = new ActorLayer("Levels/Level" + level + "ActorLayer.txt");
        tile = tilelayer.getTiles();
        items = itemLayer.getItems();
        actors = actorLayer.getActorList();
        player = actorLayer.getPlayer();

        //canvas adapts to the size of the tile layer
        CANVAS_HEIGHT = tile.length * GRID_CELL_HEIGHT;
        CANVAS_WIDTH = tile[0].length * GRID_CELL_WIDTH;

        //set time limit
        timeLimit = 75;

        Pane root = buildGUI();

        // Create a scene from the GUI
        Scene scene = new Scene(root, WINDOW_WIDTH, WINDOW_HEIGHT);

        // Register an event handler for key presses.
        // This causes the processKeyEvent method to be called each time a key is pressed.
        scene.addEventFilter(KeyEvent.KEY_PRESSED, this::processKeyEvent);

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

        //Updates as soon as an item is collected or deleted
        player.getInventory().setUpdateListener(this);
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

        //ser time limit clock on the bottom left using a label
        Label timeLabel = new Label("Time: " + timeLimit);
        ((BorderPane) canvas.getParent()).setBottom(timeLabel);

        //these added here for faster response times
        //check if player is killed
        if (player.isKilled(actors,tile) || timeLimit == 0){
            endgame();
        }
        //check if player is on exit
        if(player.isWon(tile)){
            endgameWon();
            profile.updateCurrentLevel();
            profile.saveProfileToFile();
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

        if (tickCounter % 3 == 0) {
            for (Actor actor : actors) {
                if (actor instanceof Bug) {
                    ((Bug) actor).wallFollow(tile);
                }
            }
        }
        ArrayList<Actor> actorsCopy = new ArrayList<>(actors);
        //foreach block check if it is on water
        for (Actor actor : actorsCopy) {
            if (actor instanceof Block) {
                ((Block) actor).isOnWater(tile,actors);
            }
        }
        //decrement time limit
        timeLimit--;

        drawGame();

        tickCounter++;

    }

    public void processKeyEvent(KeyEvent event) {
        // We change the behaviour depending on the actual key that was pressed.
        switch (event.getCode()) {
            case RIGHT:
                if (canMove(player.getX() + 1, player.getY())) {
                    player.moveRight(tile);
                }
                player.checkBlock(actors, "right");
                break;
            case LEFT:
                if (canMove(player.getX() - 1, player.getY())) {
                    player.moveLeft(tile);
                }
                player.checkBlock(actors, "left");
                break;
            case UP:
                if (canMove(player.getX(), player.getY() - 1)) {
                    player.moveUp(tile);
                }
                player.checkBlock(actors, "up");
                break;
            case DOWN:
                if (canMove(player.getX(), player.getY() + 1)) {
                    player.moveDown(tile);
                }
                player.checkBlock(actors, "down");
                break;
            default:
                break;
        }

        //collect items is here so it is a seamless transition
        if (event.getCode() == KeyCode.RIGHT || event.getCode() == KeyCode.LEFT ||
                event.getCode() == KeyCode.UP || event.getCode() == KeyCode.DOWN) {
            collectItems();
        }


        // Check if the player has moved and update the game state
        updateGameState(event);

        // Consume the event. This means we mark it as dealt with. This stops other GUI nodes (buttons etc.) responding to it.
        event.consume();
    }

    //used to check if player can move to a certain tile if its locked
    private boolean canMove(int targetX, int targetY) {
        // Check if the target position is within bounds
        if (targetX < 0 || targetX >= tile[0].length || targetY < 0 || targetY >= tile.length) {
            return false;
        }

        // Check the tile type at the target position
        Tile targetTile = tile[targetY][targetX];

        // Check if the player has the key in their inventory
        boolean hasBlueKey = player.getInventory().containsBlueKey();
        boolean hasRedKey = player.getInventory().containsRedKey();
        boolean hasGreenKey = player.getInventory().containsGreenKey();
        boolean hasYellowKey = player.getInventory().containsYellowKey();
        boolean hasChip = player.getInventory().containsChip();

        // Check if the target tile is a LockedDoorBlue and the player doesn't have the blue key
        if (targetTile instanceof LockedDoorBlue && !hasBlueKey) {
            return false;
        }

        if (targetTile instanceof LockedDoorRed && !hasRedKey) {
            return false;
        }

        if (targetTile instanceof LockedDoorGreen && !hasGreenKey) {
            return false;
        }

        if (targetTile instanceof LockedDoorYellow && !hasYellowKey) {
            return false;
        }

        if (targetTile instanceof ChipSocket) {
            ChipSocket chipSocket = (ChipSocket) targetTile;
            int requiredChips = chipSocket.getChipsRequired();

            if (!hasChip || player.getInventory().getChipCount() < requiredChips) {
                return false;
            }
        }
        return true;
    }

    // Update the code where you call handleLockedDoorBlueInteraction in MasonMain
    private void updateGameState(KeyEvent event) {
        Tile currentTile = tile[player.getY()][player.getX()];

        // Check the current tile and handle player interaction
        player.handlePlayerInteraction(currentTile);

        if (event.getCode() == KeyCode.RIGHT || event.getCode() == KeyCode.LEFT ||
                event.getCode() == KeyCode.UP || event.getCode() == KeyCode.DOWN) {
            collectItems();
        }

        // Redraw the game as the player may have moved.
        drawGame();
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

    @Override
    public void onInventoryUpdate() {
        // Update the inventory display when notified about the inventory change
        updateInventoryDisplay();
    }

    private void updateInventoryDisplay() {
        BorderPane borderPane = (BorderPane) canvas.getParent();
        VBox inventoryVBox = (VBox) borderPane.getRight();

        // Clear existing children
        inventoryVBox.getChildren().clear();

        // Add a title to the VBox
        Label titleLabel = new Label("Inventory");
        titleLabel.setStyle("-fx-font-weight: bold;"); // Optional: Set the font weight

        // Center the title horizontally
        VBox.setMargin(titleLabel, new Insets(10, 0, 10, 0)); // Optional: Set top and bottom margins
        inventoryVBox.setAlignment(Pos.CENTER);
        inventoryVBox.getChildren().addAll(titleLabel);

        // Create a GridPane for the items
        GridPane itemsGrid = new GridPane();
        itemsGrid.setHgap(0); // Adjust the horizontal gap as needed
        itemsGrid.setVgap(0); // Adjust the vertical gap as needed

        int col = 0;
        int row = 0;

        for (Image image : player.getInventory().getImages()) {
            ImageView imageView = new ImageView(image);
            imageView.setFitWidth(32); // Set the width of the image
            imageView.setFitHeight(32); // Set the height of the image

            itemsGrid.add(imageView, col, row); // Add the ImageView to the GridPane

            col++;
            if (col >= 3) {
                col = 0;
                row++;
            }
        }

        // Add the itemsGrid to the VBox
        inventoryVBox.getChildren().add(itemsGrid);

        // Set the background color of the VBox to gray
        inventoryVBox.setStyle("-fx-background-color: grey; -fx-border-color: grey; -fx-border-width: 2px;");

        // Set the size of the VBox (adjust as needed)
        inventoryVBox.setMaxHeight(120);
        inventoryVBox.setMinWidth(96);

        // Set the alignment of the VBox to Pos.CENTER_RIGHT
        borderPane.setRight(inventoryVBox);
        BorderPane.setAlignment(inventoryVBox, Pos.CENTER_RIGHT);
    }

    public void resetPlayerLocation() {
    }

    public void movePlayerToCenter() {
    }

    //ends game
    public void endgame(){
        //stop ticks
        tickTimeline.stop();
        //create new stage
        Stage endStage = new Stage();
        //create new border pane
        BorderPane endPane = new BorderPane();
        //create new label
        Label endLabel = new Label("Game Over!");
        //set label to center
        endPane.setCenter(endLabel);
        //create new scene
        Scene endScene = new Scene(endPane, 200, 200);
        //set scene to stage
        endStage.setScene(endScene);
        //show stage
        endStage.show();
    }

    //ends game
    public void endgameWon(){
        //stop ticks
        tickTimeline.stop();

        //increment level
        level++;

        //close old game screen
        Stage stage = (Stage) canvas.getScene().getWindow();
        stage.close();

        //reset game
        resetGame();

    }

    //resets game calls start again
    public void resetGame(){
        Stage stage = new Stage();
        start(stage);
    }


    private Pane buildGUI() {
        // Create top-level panel that will hold all GUI nodes.
        BorderPane root = new BorderPane();

        // Create the canvas that we will draw on.
        // We store this as a global variable so other methods can access it.
        canvas = new Canvas(CANVAS_WIDTH, CANVAS_HEIGHT);
        canvas.setStyle("-fx-border-color: Black; -fx-border-width: 9;");

        //root is entire screen
        root.setCenter(canvas);
        root.setStyle("-fx-border-color: Black; -fx-border-width: 4; -fx-background-color: " +
                "linear-gradient(from 0% 0% to 100% 200%, repeat, white 5%, aqua 75%);");


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

        // Set up the behavior of the button.
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

        // Set up the behavior of the buttons.
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

        //show level number on screen
        Label levelLabel = new Label("Level: " + level);
        toolbar.getChildren().add(levelLabel);


        // Create a GridPane for the inventory display
        GridPane inventoryGrid = new GridPane();
        inventoryGrid.setHgap(0);
        inventoryGrid.setVgap(0);
        inventoryGrid.setPadding(new Insets(5));

        // Set a custom cell factory to display images
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                ImageView imageView = new ImageView();
                imageView.setFitWidth(32); // Set the width of the image
                imageView.setFitHeight(32); // Set the height of the image
                inventoryGrid.add(imageView, j, i);
            }
        }

        // Create a toolbar with some nice padding and spacing
        VBox inventory = new VBox();
        inventory.setSpacing(10);
        inventory.setPadding(new Insets(10));
        root.setRight(inventory);

        inventory.getChildren().add(inventoryGrid);

        inventoryGrid.setStyle("-fx-border-color: black; -fx-border-width: 2px;");

        return root;
    }

    public static void main(String[] args) {
        launch(args);
    }
}
