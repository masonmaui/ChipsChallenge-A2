package com.example.group16a2.Items;

//This class is made to encompass all items, it allows to use functions on different types of items, and store
//them together. This is most useful in the item layer where we search for items or play their actions.
public class CollectableItems {
    private Boolean isConsumable = true;
    public String filename;
    private boolean isCollected;

    public CollectableItems(String filename) {
        this.filename = filename;
    }

    public void addToPlayerInventory(ItemLayer targetInv) {
        targetInv.insertToInventory(this);
        setCollected(true); // Mark the item as collected when added to the inventory
    }

    public void Action() {
        // Define any actions to be performed when the item is used or collected
    }

    // Get file name
    public String getFilename() {
        return filename;
    }

    public Boolean getConsumable() {
        return isConsumable;
    }

    public boolean isCollected() {
        return isCollected;
    }

    public void setCollected(boolean collected) {
        isCollected = collected;
    }
}