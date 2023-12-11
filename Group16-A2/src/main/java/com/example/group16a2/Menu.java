package com.example.group16a2;

/**
 * Menu.java
 * This class represents the Menu application using JavaFX.
 * @author Marco Silva
 * @version 1.6
 */

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.control.TextField;
import java.io.IOException;


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

    @FXML
    public void Level1() throws IOException {
        Stage gameStage = new Stage();  // Create a new Stage
        createNameInputTextField(gameStage);  // Pass the new Stage to the method
        gameStage.show();  // Show the new Stage
    }

//    @FXML
//    public void handleHighScoresClick() throws IOException {
//        createHighScoreField();  // Pass the new Stage to the method
//    }

}

