package com.example.group16a2.Items;

public class Chip extends CollectableItems {
    private int chipValue;
    private String filename;

    public Chip(){
        super("file:Sprites/Chip.png");
        filename = "file:Sprites/Chip.png";
    }
    public Chip (int chipValue){
        super("file:Sprites/Chip.png");
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