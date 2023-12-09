package com.example.group16a2;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class Menu extends Application  {


    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Options:");


        MenuItem menuItem1 = new MenuItem("Start game and input name");
        MenuItem menuItem2 = new MenuItem("View your max level");
        MenuItem menuItem3 = new MenuItem("View score table");

        menuItem1.setOnAction(this::processStartGameClick);

        MenuButton menuButton = new MenuButton("Options", null,
                menuItem1, menuItem2, menuItem3);

        HBox hbox = new HBox(menuButton);

        Scene scene = new Scene(hbox, 500, 500);
        primaryStage.setScene(scene);
        primaryStage.show();
        
    }

    private void processStartGameClick(ActionEvent actionEvent) {
        StartGame();
    }

    public void StartGame(){
        System.out.println("Starting game...");
        MasonMain game = new MasonMain();
        game.start(new Stage());
    }

    public static void main(String[] args) {
        Application.launch(args);
    }

}

