package com.example.group16a2.Items;

/**
 * Chip.java
 * This class represents a chip that can be collected in the game.
 * @author Mason Emery and Marco Silva
 * @version 1.6
 */
public class Chip extends CollectableItems {
    private int chipValue;
    private String filename;


    /**
     * Constructs the default chip and the filename.
     */
    public Chip(){
        super("file:Sprites/Chip.png");
        filename = "file:Sprites/Chip.png";
    }

    /**
     * Constructs the specified chip and the filename.
     * @param chipValue the chip value associated with
     *                  the chip.
     */
    public Chip (int chipValue){
        super("file:Sprites/Chip.png");
        this.chipValue = chipValue;
    }

    /**
     * Adds the chip to the player's inventory.
     * @param targetInv The target item layer representing the player's
     *                  inventory.
     */
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