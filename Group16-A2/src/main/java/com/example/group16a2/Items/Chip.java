package com.example.group16a2.Items;

public class Chip extends CollectableItems {
    private int chipValue;


    public Chip(){
    }
    public Chip (int chipValue){
        this.chipValue = chipValue;
    }

    public void addToPlayerInventory(ItemLayer targetInv){
        Action(targetInv);
    }

    public void Action(ItemLayer targetItemLayer){
        targetItemLayer.updateChipCount(chipValue);
        //Need to complete functions to remove the chip from item layer once transaction is complete.
        targetItemLayer.removeItemFromLayer(targetItemLayer.findItemInLayer(this),this);
    }

    //to string
    public String toString() {
        return "Chip";
    }
}