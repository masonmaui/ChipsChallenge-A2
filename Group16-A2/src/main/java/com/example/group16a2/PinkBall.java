package com.example.group16a2;

public class PinkBall extends Independent{
    private String pinkBall;
    private String filename;


    public PinkBall(String pinkBall, int[] position, String name) {
        super(position, name);
        this.pinkBall = pinkBall;

        filename = "pinkBall.png";
    }

    public void bounce(){

    }
}
