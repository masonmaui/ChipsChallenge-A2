package com.example.group16a2.Actors;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class ActorLayer {
    private Actor[] monsters;
    private Actor[] blocks;
    private int[] layerSize;
    private Player playerActor;

    private Actor[][] actors;
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
        actors = readDataFile(filename);
    }

    public Actor[][] getActors() {
        return actors;
    }

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
        return playerActor;
    }

    public Actor[][] readEachLine(Scanner in) {
        int lineCount = 0;
        String line = in.nextLine();
        Scanner lineScanner = new Scanner(line);
        y = lineScanner.nextInt();
        x = lineScanner.nextInt();
        lineScanner.close();
        Actor[][] grid = new Actor[y][x];
        while (in.hasNextLine()) {
            String line2 = in.nextLine();
            Scanner lineScanner2 = new Scanner(line2);
            for (int i = 0; i < x; i++) {
                String actorType = lineScanner2.next();
                if (actorType.equals("-")) {
                    grid[lineCount][i] = null;
                } else if (actorType.equals("P")) {
                    grid[lineCount][i] = new Player();
                    playerActor = new Player();
                }else if(actorType.equals("B")) {
                    grid[lineCount][i] = new Block();
                }else if(actorType.equals("PBN")) {
                    grid[lineCount][i] = new PinkBall("N");
                }else if(actorType.equals("PBE")) {
                    grid[lineCount][i] = new PinkBall("E");
                }else if(actorType.equals("PBW")) {
                    grid[lineCount][i] = new PinkBall("W");
                }else if(actorType.equals("PBS")) {
                    grid[lineCount][i] = new PinkBall("S");
                }else if(actorType.equals("BG")) {
                    grid[lineCount][i] = new Bug();
                }else if(actorType.equals("F")) {
                    grid[lineCount][i] = new Frog();
                }

            }
            lineCount++;

        }
        return grid;
    }


    public Actor[][] readDataFile (String filename){
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

        for (int i = 0; i < actorlayer.getActors().length; i++) {
            for (int j = 0; j < actorlayer.getActors()[i].length; j++) {
                System.out.print(actorlayer.getActors()[i][j] + " ");
            }
            System.out.println();
        }
    }

}
