package com.example.group16a2.Actors;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class ActorLayer {
    private Actor[] monsters;
    private Actor[] blocks;
    private int[] layerSize;
    private Player playerActor;

    private Actor[][] actors;
    private ArrayList<Actor> actorList;
    private int x;
    private int y;

    private String filename;


    // Parameterised constructor
    public ActorLayer(Actor[] monsters, Actor[] blocks, int[] layerSize, Player playerActor) {
        this.monsters = monsters;
        this.blocks = blocks;
        this.layerSize = layerSize;
        int x = layerSize[0];
        int y = layerSize[1];
        this.playerActor = playerActor;
        actors = new Actor[x][y];
    }

    public ActorLayer(String filename) {
        actorList = readDataFile(filename);
    }

    //get array list
    public ArrayList<Actor> getActorList() {
        return actorList;
    }

    /*
    public void setLocation(Actor actor, int[] newlocation) {
        int[] oldlocation = actor.getPosition();
        int oldy = oldlocation[0];
        int oldx = oldlocation[1];
        int newy = newlocation[0];
        int newx = newlocation[1];
        actors[oldy][oldx] = actor;
        actors[newy][newx] = actor;
        System.out.println(Arrays.deepToString(actors)); //for testing
    }
     */

    public void loadLayer() {

    }

    public void saveLayer() {
    }

    // Getter method for position
    public int[] getActorPosition(Actor actor) {
        int[] position = new int[]{-1, -1}; // Default position if actor is not found

        for (int i = 0; i < actors.length; i++) {
            for (int j = 0; j < actors[i].length; j++) {
                if (actors[i][j].equals(actor)) {
                    position[0] = i; // Set the row index where actor is found
                    position[1] = j; // Set the column index where actor is found
                    break;
                }
            }
            if (position[0] != -1) {
                break; // Break the outer loop if actor is found
            }
        }
        return position;
    }


    public void getActor(Actor actor) {
    }

    public void removeActor(Actor actor) {
    }

    public String allActors() {
        for (Actor value : monsters) {
            System.out.println(value);
        }

        for (Actor value : blocks) {
            System.out.println(value);
        }

        System.out.println(playerActor);

        return null;
    }
    
    public Player getPlayer() {
        //from arraylist
        for (Actor actor : actorList) {
            if (actor instanceof Player) {
                return (Player) actor;
            }
        }
        return null;
    }

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
                } else if (actorType.equals("P")) {
                    actorList.add(new Player(lineCount, i));
                }else if(actorType.equals("B")) {
                    actorList.add(new Block(lineCount, i));
                }else if(actorType.equals("PBN")) {
                    actorList.add(new PinkBall(lineCount, i, "N"));
                }else if(actorType.equals("PBE")) {
                    actorList.add(new PinkBall(lineCount, i, "E"));
                }else if(actorType.equals("PBW")) {
                    actorList.add(new PinkBall(lineCount, i, "W"));
                }else if(actorType.equals("PBS")) {
                    actorList.add(new PinkBall(lineCount, i, "S"));
                }else if(actorType.equals("BG")) {
                    actorList.add(new Bug(lineCount, i));
                }else if(actorType.equals("F")) {
                    actorList.add(new Frog(lineCount, i));
                }
            }
            lineCount++;

        }
        return actorList;
    }


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

    public static void main(String[] args) {
        ActorLayer actorlayer = new ActorLayer("Levels/Level1ActorLayer.txt");

        //show file paths of all actord in list
        for (Actor actor : actorlayer.getActorList()) {
            if (actor != null) {
                System.out.println(actor.getFileName());
            }else{
                System.out.println("null");
            }
        }
    }

}