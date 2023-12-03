package com.example.group16a2;

import java.util.Arrays;

class ActorLayer {
    private Actor[] monsters;
    private Actor[] blocks;
    private int[] layerSize;
    private Actor playerActor;

    public ActorLayer() {
    }

    // Parameterised constructor
    public ActorLayer(Actor[] monsters, Actor[] blocks, int[] layerSize, Actor playerActor) {
        this.monsters = monsters;
        this.blocks = blocks;
        this.layerSize = layerSize;
        this.playerActor = playerActor;
    }

    public void loadLayer() {

    }

    public void saveLayer() {

    }

    // Getter method for position
    public int[] getActorPosition() {
        return null;
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
    
    public void getPlayer() {
    }


}
