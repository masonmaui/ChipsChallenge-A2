package com.example.group16a2;

public class Key extends CollectableItems {
    //type of door it accesses denoted by colour
    private Character type;

    public Key (Character type){
        this.type = type;
    }

    public Character getType() {
        return type;
    }

    public void Action(ItemLayer targetItemLayer){
        //Add function for door to open.
        //Need to complete functions to remove the chip from item layer once transaction is complete.
        targetItemLayer.removeItemFromLayer(targetItemLayer.findItemInLayer(this),this);
    }
}
