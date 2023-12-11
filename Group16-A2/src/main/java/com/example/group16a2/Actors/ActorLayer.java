package com.example.group16a2.Actors;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 * ActorLayer.java
 * This class represents the layer of the actor like the monsters,
 * blocks and the player in a 2D grid.
 * The layer can get information about the actors, their positions, and more.
 * @author Mason Emery
 * @version 1.6
 */
public class ActorLayer {
    private Actor[] monsters;
    private Actor[] blocks;
    private int[] layerSize;
    private Player playerActor;

    private Actor[][] actors;
    private ArrayList<Actor> actorList;
    private int x;
    private int y;

    /**
     * Creating the actor layer by reading data from a file.
     * @param filename The file path containing actor data.
     */
    public ActorLayer(String filename) {
        actorList = readDataFile(filename);
    }

    /**
     * Gets the list of actors in the layer.
     * @return the actorList the array list contains all the actors in the layer.
     */
    public ArrayList<Actor> getActorList() {
        return actorList;
    }


    /**
     * Gets the player from the actor list.
     * @return null if no actor is present.
     */
    public Player getPlayer() {
        //from arraylist
        for (Actor actor : actorList) {
            if (actor instanceof Player) {
                return (Player) actor;
            }
        }
        return null;
    }

    /**
     *
     * Reads each line from the Scanner and constructs a list of actors
     * based on the information in the lines.
     *
     * @param in the Scanner provides the input stream to read from.
     * @return actorList the array list containing actors created from
     * the input lines.
     */
    public ArrayList<Actor> readEachLine(Scanner in) {
        int lineCount = 0;
        String line = in.nextLine();
        Scanner lineScanner = new Scanner(line);
        y = lineScanner.nextInt();
        x = lineScanner.nextInt();
        lineScanner.close();
        ArrayList<Actor> actorList = new ArrayList<>();
        while (in.hasNextLine()) {
            String line2 = in.nextLine();
            Scanner lineScanner2 = new Scanner(line2);
            for (int i = 0; i < x; i++) {
                String actorType = lineScanner2.next();
                if (actorType.equals("-")) {
                    continue;
                }
                else if(actorType.equals("B")) {
                    actorList.add(new Block(lineCount, i));
                }else if(actorType.equals("PBN")) {
                    actorList.add(new PinkBall(lineCount, i, "N"));
                }else if(actorType.equals("PBE")) {
                    actorList.add(new PinkBall(lineCount, i, "E"));
                }else if(actorType.equals("PBW")) {
                    actorList.add(new PinkBall(lineCount, i, "W"));
                }else if(actorType.equals("PBS")) {
                    actorList.add(new PinkBall(lineCount, i, "S"));
                }else if(actorType.equals("BGR")) {
                    actorList.add(new Bug(lineCount, i, "R"));
                }else if (actorType.equals("BGL")) {
                    actorList.add(new Bug(lineCount, i, "L"));
                }else if(actorType.equals("F")) {
                    actorList.add(new Frog(lineCount, i));
                }
                else if (actorType.equals("P")) {
                actorList.add(new Player(lineCount, i));
            }
            }
            lineCount++;

        }
        return actorList;
    }

    /**
     *
     * Constructs the array list of actors based on the information in the file
     * and reads the actor data from the file.
     *
     * @param filename The path to the file containing actor data.
     * @return readEachLine The array list contains the actors that is created from the
     * data in the file.
     */
    public ArrayList<Actor> readDataFile (String filename){
        Scanner in = null;
        try {
            in = new Scanner(new File(filename));
        } catch (FileNotFoundException e) {
            System.out.println("Could not find " + filename);
            System.exit(-1);
        }
        return readEachLine(in);

    }

}
