package com.example.group16a2.Actors;

public class Independent extends Actor {
    public Independent(int[] position, String name) {
        super(position, name);
    }

    public Independent(){
    }

    public void moveBy(ActorLayer actorLayer, int x, int y){
        int[] old = actorLayer.getActorPosition(this);
        //check for illegal move
        y+= old[0];
        x+= old[1];
        moveTo(actorLayer, new int[] {y,x});
    }

    public void moveTo(ActorLayer actorLayer, int[] position){
        actorLayer.setLocation(this,position);
    }
}
