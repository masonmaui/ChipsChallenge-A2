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
import javafx.scene.control.TextArea;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.scene.control.TextField;

import java.io.BufferedReader;
import java.io.FileReader;
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

    @FXML
    public void handleSubmitClick(){
        String user = this.user.getText();
        Profile profile = Profile.loadProfile(user);
        MasonMain game = new MasonMain(profile);
        profile.saveProfileToFile();
        game.start(new Stage());
    }

    public void createNameInputTextField(Stage primaryStage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Menu.class.getResource("UsernamePanel.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 500, 300);
        primaryStage.setTitle("Enter Username");
        primaryStage.setScene(scene);  // Set the scene for the correct stage
        primaryStage.show();
    }

    @FXML
    public void handleHighScoresClick() throws IOException {
        createHighScoreField();  // Pass the new Stage to the method
    }

    @FXML
    private Text highscores;

    public void createHighScoreField() throws IOException {
        StringBuilder scores = new StringBuilder();
        for (int i = 1; i<5; i++) {
            try (BufferedReader reader = new BufferedReader(new FileReader("highscores" + i + ".txt"))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    scores.append(line);
                }
                FXMLLoader fxmlLoader = new FXMLLoader(Menu.class.getResource("highscores.fxml"));
                Scene scene = new Scene(fxmlLoader.load(), 500, 300);
                Stage primaryStage = new Stage();
                primaryStage.setTitle("Highscores for level: " + i);
                primaryStage.setScene(scene);
                highscores.setText(String.valueOf(scores));
                primaryStage.show();
                scores = new StringBuilder();

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}

