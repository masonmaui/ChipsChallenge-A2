package com.example.group16a2;

import java.io.*;
import java.util.Scanner;
import java.util.ArrayList;

/**
 * Profile.java
 * This class represents the player profile in the game.
 * @author Marco Silva
 * @version 1.6
 */
public class Profile {

    private final String name;
    private int highestLevel = 1;
    private int currentLevel = 1;

    /**
     * Constructs the profile with the given name.
     * @param name The name of the profile.
     * @throws IllegalArgumentException if provided name is null.
     */
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

    private void createHighScoresFile() {
        try {
            File myObj = new File("highscores"+currentLevel+".txt");
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

    public void submitHighscore(int score){
        createHighScoresFile();
        boolean update = true;
        String profilename = this.getName();
        try {
            File inputFile = new File("highscores" + currentLevel + ".txt");
            BufferedReader reader = new BufferedReader(new FileReader(inputFile));
            String currentLine;

            while ((currentLine = reader.readLine()) != null) {
                // trim newline when comparing with lineToRemove
                int score_from_line = Integer.parseInt((currentLine.trim()).substring(16));
                update = score_from_line<score;
            }
            if (update) {
                FileWriter myWriter = new FileWriter("highscores" + currentLevel + ".txt", true);
                myWriter.write(this.toStringForSave() + score + "\n");
                myWriter.close();
            }
        } catch (IOException e) {
            System.out.println("An error occurred in writing highscore for: " + name + ".");
            e.printStackTrace();
        }
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

    public void deleteProfileFromFileHighscore(String profilename,int score) {
        try {
            File inputFile = new File("highscores" + currentLevel + ".txt");
            File tempFile = new File("highscorehandle.txt");
            tempFile.createNewFile();

            BufferedReader reader = new BufferedReader(new FileReader(inputFile));
            BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile));

            String currentLine;

            while ((currentLine = reader.readLine()) != null) {
                // trim newline when comparing with lineToRemove
                String trimmedLine = (currentLine.trim()).split(" ")[0];
                int score_from_line = Integer.parseInt((currentLine.trim()).substring(16));
                if (trimmedLine.equals(profilename)&&(score > score_from_line)) continue;
                writer.write(currentLine + System.getProperty("line.separator"));
            }
            writer.close();
            reader.close();
            inputFile.delete();
            boolean successful = tempFile.renameTo(inputFile);
            System.out.println(successful);
        } catch (IOException e) {
            System.out.println("Error in profile edit");
            e.printStackTrace();
        }
    }

    public void saveProfileToFile() {
        createProfilesFile();
        try {
            FileWriter myWriter = new FileWriter("profiles.txt",true);
            myWriter.write(this.toStringForSave() + highestLevel + "\n");
            myWriter.close();
            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred in writing: " + name + ".");
            e.printStackTrace();
        }
    }



    public static void deleteProfileFromFileProfiles(String profilename) {
        try {
            File inputFile = new File("profiles.txt");
            File tempFile = new File("profilehandletemp.txt");
            tempFile.createNewFile();

            BufferedReader reader = new BufferedReader(new FileReader(inputFile));
            BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile));

            String currentLine;

            while ((currentLine = reader.readLine()) != null) {
                // trim newline when comparing with lineToRemove
                String trimmedLine = (currentLine.trim()).split(" ")[0];
                if (trimmedLine.equals(profilename)) continue;
                writer.write(currentLine + System.getProperty("line.separator"));
            }
            writer.close();
            reader.close();
            inputFile.delete();
            boolean successful = tempFile.renameTo(inputFile);
            System.out.println(successful);
        } catch (IOException e) {
            System.out.println("Error in profile edit");
            e.printStackTrace();
        }

    }

    public static Profile loadProfile(String profilename) {
        deleteProfileFromFileProfiles(profilename);
        return new Profile(profilename);
    }

    public String toStringForSave(){
        return (name + " ".repeat(Math.max(0, 16 - name.length())));
    }

    public static ArrayList<String> readProfileFile(){
        ArrayList<String> names = new ArrayList<>();
        try {
            File file = new File("profiles.txt");
            Scanner myReader = new Scanner(file);
            while (myReader.hasNextLine()) {
                String data = (myReader.nextLine()).split(" ")[0];
                names.add(data);
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        return names;
    }

    @Override
    public String toString() {
        return (name + " " + highestLevel + " " + currentLevel);
    }

    public static void main(String[] args) {
        Profile marco = new Profile("Marco");
        marco.submitHighscore(25);
    }
}