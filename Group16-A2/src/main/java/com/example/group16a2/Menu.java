package com.example.group16a2;

import javafx.application.Application;;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.control.TextField;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;


public class Menu extends Application  {
    @FXML
    private TextField user;

    @Override
    public void start(Stage primaryStage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Menu.class.getResource("MenuLayout.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 500, 300);
        primaryStage.setTitle("Menu");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    @FXML
    public void startGame() throws IOException {
        createNameInputTextField(new Stage());
    }

    public static void main(String[] args) {
        Application.launch(args);
    }

    @FXML
    public void handleSubmitClick(){
        String user = this.user.getText();
        MasonMain game = new MasonMain(Profile.loadProfile(user));
        game.start(new Stage());
    }

    public void createNameInputTextField(Stage primaryStage) throws IOException{
        FXMLLoader fxmlLoader = new FXMLLoader(Menu.class.getResource("UsernamePanel.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 500, 300);
        primaryStage.setTitle("Menu");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}

