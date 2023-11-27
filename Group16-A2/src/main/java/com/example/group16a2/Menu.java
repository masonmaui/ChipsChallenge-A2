package com.example.group16a2;

public class Menu {
    private boolean isVisible;
    private boolean isGameWon;
    private boolean isGameLost;
    private String [][] currentGrid;
    private int currentLevel;
    //private Profile  activeProfile;

    //constructor
    public Menu() {
        isVisible = false;
        isGameWon = false;
        isGameLost = false;
        currentLevel = 1;
        //activeProfile = new Profile();
    }

    //Displaying menu
    public void showMenu() {
        isVisible = true;
        System.out.println("Menu displayed");
    }

    //Hiding the menu
    public void hideMenu() {
        isVisible = false;
        System.out.println("Menu hidden");
    }

    public void exitGame() {
        System.out.println("Exiting game");
    }

    public void pauseGame() {
        System.out.println("Paused");
    }

    public void resumeGame() {
        System.out.println("Resume Game");
    }

    public void beginNextLevel(boolean isGameWon, int currentLevel) {
        System.out.println("Beginning next level");
    }

    public void replayLevel(boolean isGameLost, int currentLevel) {
        System.out.println("Replaying level");
    }

    public boolean isGameWon () {
        return isGameWon;

    }

    public boolean isGameLost() {
        return isGameLost;

    }


    //public void handleUserInput(String userInput) {
    //    System.out.println("User input: " + userInput);
    //}


}
