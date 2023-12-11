package com.example.group16a2;
import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.scene.control.TextField;

import java.io.*;

/**
 * Menu.java
 * This class represents the Menu application using JavaFX.
 * @author Marco Silva
 * @version 1.6
 */
public class Menu extends Application  {
    @FXML
    private TextField user;

    /**
     * Main entry point for the application.
     * @param primaryStage The primary stage for the application.
     * @throws IOException If an error occurs during loading the
     *                      FXML.
     */
    @Override
    public void start(Stage primaryStage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Menu.class.getResource("MenuLayout.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 500, 300);
        primaryStage.setTitle("Menu");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * Starts a new game by creating a new stage.
     * @throws IOException If an error occurs during loading the
     *                     FXML.
     */
    @FXML
    public void startGame() throws IOException {
        Stage gameStage = new Stage();  // Create a new Stage
        createNameInputTextField(gameStage);  // Pass the new Stage to the method
        gameStage.show();  // Show the new Stage
    }

    /**
     * Starts the application.
     * @param args The command line arguments.
     */
    public static void main(String[] args) {
        Application.launch(args);
    }

    /**
     * Handles the click event for the submit button.
     */
    @FXML
    public void handleSubmitClick(){
        String user = this.user.getText();
        Profile profile = Profile.loadProfile(user);
        Game game = new Game(profile);
        profile.saveProfileToFile();
        game.start(new Stage());
    }

    /**
     * Creates a new stage for entering the username.
     * @param primaryStage The primary stage for the application
     *                     where the username input will be set.
     * @throws IOException If an error occurs during loading the
     *                     FXML.
     */
    public void createNameInputTextField(Stage primaryStage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Menu.class.getResource("UsernamePanel.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 500, 300);
        primaryStage.setTitle("Enter Username");
        primaryStage.setScene(scene);  // Set the scene for the correct stage
        primaryStage.show();
    }

    /**
     * Handles the click event for the level 1 button.
     * @throws IOException If an error occurs during loading the
     *                     FXML.
     */
    @FXML
    public void Level1() throws IOException {
        Stage gameStage = new Stage();  // Create a new Stage
        createNameInputTextField(gameStage);  // Pass the new Stage to the method
        gameStage.show();  // Show the new Stage
    }


    /**
     * Handles the click event for the high scores button.
     * @throws IOException If an error occurs during loading the
     *                     FXML.
     */
    public void handleHighScoresClick() throws IOException {
        Stage highScoreStage = new Stage();
        createHighScoreField(highScoreStage);  // Pass the new Stage to the method
    }

    @FXML
    private Label label = new Label();

    /**
     * Initializes the high score screen.
     * @throws IOException If an error occurs during loading the
     */
    public void initialize() throws IOException {
        File highScoreFile = new File("highscores1.txt");
        BufferedReader reader = new BufferedReader(new FileReader(highScoreFile));
        StringBuilder scores = new StringBuilder("Level 1:" + "\n");
        String currentLine;
        for (int i = 2; i<6; i++) {
            while ((currentLine = reader.readLine()) != null) {
                System.out.println(currentLine);
                scores.append(currentLine + "\n");
            }
            reader.close();
            scores.append("Level " + i +":\n");
            highScoreFile = new File("highscores" + i + ".txt");
            reader = new BufferedReader(new FileReader(highScoreFile));
        }
        label.setText(String.valueOf(scores));
    }

    /**
     * Creates a new stage for entering the username.
     * @param primaryStage The primary stage for the application
     * @throws IOException If an error occurs during loading the
     */
    public void createHighScoreField(Stage primaryStage) throws IOException{
        FXMLLoader fxmlLoader = new FXMLLoader(Menu.class.getResource("HighScoreLayoutTest.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 271, 490);
        primaryStage.setTitle("Highscores:");
        primaryStage.setScene(scene);  // Set the scene for the correct stage
        primaryStage.show();
        primaryStage.show();
    }
}

