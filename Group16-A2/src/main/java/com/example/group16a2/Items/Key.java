package com.example.group16a2.Items;

public class Key extends CollectableItems {
    //type of door it accesses denoted by colour
    private String type;

    public Key (String type){
        if(type.equals("R")) {
            this.type = "r";
        }else if (type.equals("B")) {
            this.type = "b";
        }else if (type.equals("Y")) {
            this.type = "y";
        }else if (type.equals("G")) {
            this.type = "g";
        }
    }

    public String getType() {
        return type;
    }

    public void Action(ItemLayer targetItemLayer){
        //Add function for door to open.
        //Need to complete functions to remove the chip from item layer once transaction is complete.
        targetItemLayer.removeItemFromLayer(targetItemLayer.findItemInLayer(this),this);
    }

    //to string with if statements
    public String toString() {
        if(type.equals("r")) {
            return "RK";
        }else if (type.equals("b")) {
            return "BK";
        }else if (type.equals("y")) {
            return "YK";
        }else if (type.equals("g")) {
            return "GK";
        }
        return "Key";
    }
}
