package com.example.group16a2;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Profile {

    private final String name;
    private int highestLevel = 1;
    private int currentLevel = 1;

    public Profile(String name) {
        if (name.length()>15) {
            this.name = name.substring(0, 15);
        }
        else {
            this.name = name;
        }
    }

    public String getName() {
        return name;
    }

    public void updateHighestLevel() {
        if (highestLevel < currentLevel) {
            highestLevel = currentLevel;
        }
    }

    public void updateCurrentLevel() {
        currentLevel++;
        updateHighestLevel();
    }

    private static void createProfilesFile() {
        try {
            File myObj = new File("profiles.txt");
            if (myObj.createNewFile()) {
                System.out.println("File created: " + myObj.getName());
            } else {
                System.out.println("File already exists.");
            }
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    public void saveProfileToFile() {
        createProfilesFile();
        try {
            FileWriter myWriter = new FileWriter("profiles.txt",true);
            myWriter.write(this.toStringForSave() + "\n");
            myWriter.close();
            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred in writing: " + name + ".");
            e.printStackTrace();
        }
    }

    public static Profile findProfileInFile(String profilename) {
        return null;
    }

    public static Profile loadProfile(String profilename) {
//        findProfileInFile(profilename);
        return new Profile(profilename);
    }

    public String toStringForSave(){
        return (name + " ".repeat(Math.max(0, 16 - name.length())) + highestLevel);
    }

    public static void readProfileFile(){
        //
    }

    @Override
    public String toString() {
        return (name + " " + highestLevel + " " + currentLevel);
    }

    public static void main(String[] args) {
        Profile profile = new Profile("mc");
        System.out.println(profile.toStringForSave());
    }
}