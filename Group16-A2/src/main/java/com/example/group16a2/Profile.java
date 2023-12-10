package com.example.group16a2;

public class Profile {

    private String name;
    private int highScore;
    private int highestLevel;

    public Profile(String name){
     this.name = name;
    }

    public void updateHighScore (int score){
        if (highScore<score){
            highScore = score;
        }
    }

    public String getName() {
        return name;
    }

    public void updateHighestLevel(int levelComplete){
        if (highestLevel<levelComplete){
            highestLevel = levelComplete;
        }
    }

    public void saveProfileToFile(){
        //
    }

    public Profile findProfileInFile() {
        return null;
    }

    public static Profile loadProfile(String profilename){
        return new Profile (profilename);
    }
}