package com.example.group16a2.Items;

import com.example.group16a2.Actors.Player;

//This class is made to encompass all items, it allows to use functions on different types of items, and store
//them together. This is most useful in the item layer where we search for items or play their actions.

/**
 * CollectableItems.java
 * This class represents that the items that can be
 * able to be collected.
 * @author Mason Emery, James Buckley, Marco Silva
 * @version 1.6
 */
public class CollectableItems {
    private Boolean isConsumable = true;
    public String fileName;
    private boolean isCollected;


    /**
     * Constructs the object with the specified filename.
     * @param filename The filename associated with the item.
     */
    public CollectableItems(String filename) {
        this.fileName = filename;
    }

    /**
     * Adds the item to the player's inventory and set
     * it as being collected.
     * @param player The player to whose inventory the item
     *               is added.
     */

    public void addToPlayerInventory(Player player) {
        player.getInventory().addItem(this);
        setCollected(true);
    }

    /**
     * Gets the action being performed when the item is used.
     */
    public void Action() {
        // Define any actions to be performed when the item is used or collected
    }

    /**
     * Gets the filename.
     * @return filename of the item.
     */
    // Get file name
    public String getFilename() {
        return fileName;
    }

    /**
     * Checks if the item is consumable.
     * @return true if the item is consumable, otherwise
     * false.
     */
    public Boolean getConsumable() {
        return isConsumable;
    }

    /**
     * Checks if the item is collected.
     * @return true if item is collected, false
     * otherwise.
     */
    public boolean isCollected() {
        return isCollected;
    }

    /**
     * Set the collected status of the item.
     * @param collected true, if the item is collected,
     *                  otherwise false.
     */
    public void setCollected(boolean collected) {
        isCollected = collected;
    }
}