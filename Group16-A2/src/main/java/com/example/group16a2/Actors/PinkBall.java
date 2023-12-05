package com.example.group16a2.Actors;

public class PinkBall extends Independent{
    private String pinkBall;
    private String filename;

    private String Direction;


    public PinkBall(String pinkBall, int[] position, String name) {
        super(position, name);
        this.pinkBall = pinkBall;

        filename = "pinkBall.png";
    }

    //consteructor with just direction
    public PinkBall(String direction){
        super();
        if(direction.equals(("N")))
            this.Direction = "N";
        else if(direction.equals(("S")))
            this.Direction = "S";
        else if(direction.equals(("E")))
            this.Direction = "E";
        else if(direction.equals(("W")))
            this.Direction = "W";
        else
            this.Direction = "N";
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

    //to string
    public String toString(){
        if(Direction.equals("N"))
            return "PinkBall N";
        else if(Direction.equals("S"))
            return "PinkBall S";
        else if(Direction.equals("E"))
            return "PinkBall E";
        else if(Direction.equals("W"))
            return "PinkBall W";
        else
            return "PinkBall N";
    }
}
