package com.example.group16a2.Actors;

public class PinkBall extends Independent{
    private String pinkBall;
    private String filename;


    public PinkBall(String pinkBall, int[] position, String name) {
        super(position, name);
        this.pinkBall = pinkBall;

        filename = "pinkBall.png";
    }

    /*
    public void bounce() {
        switch (direction) {
            case "Right":
                direction = "Left";
                break;

            case "Left":
                direction = "Right";
                break;

            case "Up":
                direction = "Down";
                break;

            case "Down":
                direction = "Up";
                break;

            default:
                break;

        }

    }
     */
}
