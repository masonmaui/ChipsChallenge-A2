package com.example.group16a2.Actors;

public class Player extends Independent{
    private String player;
    private int[] inv;

    private String filename;

    public Player(){
    }

    public Player(String player, int[] inv, int[] position, String name) {
        super(position, name);

        this.player = player;
        this.inv = inv;

        filename = "player.png";
    }

    public void addItems(int item){
        inv[item]++; 
    }

    //to string
    public String toString(){
        return "Player";
    }
}
