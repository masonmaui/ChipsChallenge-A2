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

    private String name;
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
        } else if (name.equals("")){
            this.name = "test";
        }
        else {
            this.name = name;
        }
    }

    /**
     * Gets the name of the profile.
     * @return The name of the profile.
     */
    public String getName() {
        return name;
    }

    /**
     * Updates the highest level achieved by the profile.
     */
    public void updateHighestLevel() {
        if (highestLevel < currentLevel) {
            highestLevel = currentLevel;
        }
    }

    /**
     * Updates the current level of the profile by
     * incrementing it.
     */
    public void updateCurrentLevel() {
        currentLevel++;
        updateHighestLevel();
    }
    /**
     * Updates the current level of the profile by taking a parameter.
     * @param currentLevel the new level
     */
    public void updateCurrentLevel(int currentLevel) {
        this.currentLevel = currentLevel;
        updateHighestLevel();
    }


    /**
     * Creates a new high score file for the current level.
     * @throws IOException If an I/O error occurs during the file
     *                     creation process.
     */
    private void createHighScoresFile() {
        try {
            File myObj = new File("highscores"+currentLevel+".txt");
            if (myObj.createNewFile()) {
                System.out.println("File created: " + myObj.getName());
            } else {
                System.out.println("File already exists: " + currentLevel);
            }
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    /**
     * Submits a high score for the current player, updating
     * the high scores file for the current level.
     * @param score The score to be submitted
     */
    public void submitHighscore(int score){
        createHighScoresFile();
        boolean update = true;
        boolean matchFound = false;
        String profileName = this.getName();
        try {
            File inputFile = new File("highscores" + currentLevel + ".txt");
            BufferedReader reader = new BufferedReader(new FileReader(inputFile));
            String currentLine;
            while ((currentLine = reader.readLine()) != null) {
                // trim newline when comparing with the line that gets replaced
                String trimmedLine = currentLine.split(" ")[0];
                // stores the score to check if the new score is higher than last
                int score_from_line = Integer.parseInt(currentLine.trim().substring(16));
                matchFound = profileName.equals(trimmedLine);
                update = (score_from_line<=score && matchFound);
            }
            if (update) {
                FileWriter myWriter = new FileWriter("highscores" + currentLevel + ".txt", true);
                myWriter.write(this.toStringForSave() + score + "\n");
                myWriter.close();
            } else if (!matchFound) {
                FileWriter myWriter = new FileWriter("highscores" + currentLevel + ".txt", true);
                myWriter.write(this.toStringForSave() + score + "\n");
                myWriter.close();
            }
        } catch (IOException e) {
            System.out.println("An error occurred in writing highscore for: " + name + ".");
            e.printStackTrace();
        }
    }

    /**
     * Creates a profile file name "profiles.txt".
     */
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

    /**
     * Deletes profile entry from the highscore for the current level
     * if the score is higher.
     * @param profilename The name of the profile to be deleted.
     * @param score The profile will be deleted if its score is higher
     *              than the value.
     */
    public void deleteProfileFromFileHighscore(String profilename,int score) {
        try {
            createHighScoresFile();
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

    /**
     * Saves profile information to "profiles.txt".
     */

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

    /**
     * Deletes the profile entry from the profile txt file.
     * @param profilename The name of the profile to be deleted.
     */

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

    /**
     * Loads the profile with the specified name.
     * @param profilename The name of the profile to load or create.
     * @return the profile object that is loaded from the file.
     */
    public static Profile loadProfile(String profilename) {
        deleteProfileFromFileProfiles(profilename);
        return new Profile(profilename);
    }

    /**
     * Returns a string representation of the profile for saving.
     * @return A string representation of the profile for saving.
     */
    public String toStringForSave(){
        return (name + " ".repeat(Math.max(0, 16 - name.length())));
    }

    /**
     * Reads profile name from profile.txt file and returns them as
     * an ArrayList of strings.
     * @return An ArrayList of strings containing profile names read
     * from the "profiles.txt" files.
     */
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

    /**
     * Returns a string representation of the profile.
     * @param args The command line arguments.
     */
    public static void main(String[] args) {
        Profile marco = new Profile("Marco");
        marco.submitHighscore(25);
    }
}