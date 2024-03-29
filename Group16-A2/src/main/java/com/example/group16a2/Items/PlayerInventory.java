package com.example.group16a2.Items;

import javafx.scene.image.Image;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * PlayerInventory.java
 * This class represents the inventory of a player
 * in the game.
 * @author James Buckley
 * @version 1.6
 */
public class PlayerInventory {
    private List<CollectableItems> items;

    private int blueKeyCount = 0;
    private int redKeyCount = 0;
    private int greenKeyCount = 0;
    private int yellowKeyCount = 0;
    private int chipCount = 0;

    private InventoryUpdateListener updateListener;

    /**
     * Constructs the player's inventory.
     */
    public PlayerInventory() {
        items = new ArrayList<>();
    }

    /**
     * Gets the number of blue keys in the player's inventory.
     * @return blueKeyCount the number of blue keys.
     */
    public int getChipCount() {
        return chipCount;
    }

    /**
     * Adds collectable item into the player's inventory.
     * @param item The collectable item to be added into the inventory.
     */
    public void addItem(CollectableItems item) {
        items.add(item);
        if (item instanceof BlueKey) {
            blueKeyCount++;
        }
        else if (item instanceof RedKey) {
            redKeyCount++;
        }
        else if (item instanceof GreenKey) {
            greenKeyCount++;
        }
        else if (item instanceof YellowKey) {
            yellowKeyCount++;
        }
        else if (item instanceof Chip) {
            chipCount++;
        }
    }

    /**
     * Checks whether the player's inventory contains
     * at least one blue key.
     * @return true if the player's inventory contains at
     * least one blue key, false otherwise.
     */
    public boolean containsBlueKey() {
        return blueKeyCount > 0;
    }

    /**
     * Checks whether the player's inventory contains
     * at least one red key.
     * @return true if the player's inventory contains at
     * least one red key, false otherwise.
     */
    public boolean containsRedKey() {
        return redKeyCount > 0;
    }

    /**
     * Checks whether the player's inventory contains
     * at least one green key.
     * @return true if the player's inventory contains at
     * least one green key, false otherwise.
     */
    public boolean containsGreenKey() {
        return greenKeyCount > 0;
    }

    /**
     * Checks whether the player's inventory contains
     * at least one yellow key.
     * @return true if the player's inventory contains at
     * least one yellow key, false otherwise.
     */
    public boolean containsYellowKey() {
        return yellowKeyCount > 0;
    }

    /**
     * Checks whether the player's inventory contains
     * at least one chip.
     * @return true if the player's inventory contains at
     * least one chip, false otherwise.
     */
    public boolean containsChip() {
        return chipCount > 0;
    }

    /**
     * Searches for blue key in the player's inventory and
     * removes it.
     * @return null if blue key is not found.
     */
    public BlueKey findAndRemoveBlueKey() {
        Iterator<CollectableItems> iterator = items.iterator();
        while (iterator.hasNext()) {
            CollectableItems item = iterator.next();
            if (item instanceof BlueKey) {
                iterator.remove();
                blueKeyCount--;
                notifyUpdateListener();
                return (BlueKey) item;  // Return the removed BlueKey instance
            }
        }
        return null;
    }

    /**
     * Searches for red key in the player's inventory and
     * removes it.
     * @return null if red key is not found.
     */
    public RedKey findAndRemoveRedKey() {
        Iterator<CollectableItems> iterator = items.iterator();
        while (iterator.hasNext()) {
            CollectableItems item = iterator.next();
            if (item instanceof RedKey) {
                iterator.remove();
                redKeyCount--;
                notifyUpdateListener();
                return (RedKey) item;
            }
        }
        return null;
    }

    /**
     * Searches for green key in the player's inventory and
     * removes it.
     * @return null if green key is not found.
     */
    public GreenKey findAndRemoveGreenKey() {
        Iterator<CollectableItems> iterator = items.iterator();
        while (iterator.hasNext()) {
            CollectableItems item = iterator.next();
            if (item instanceof GreenKey) {
                iterator.remove();
                greenKeyCount--;
                notifyUpdateListener();
                return (GreenKey) item;
            }
        }
        return null;
    }

    /**
     * Searches for yellow key in the player's inventory and
     * removes it.
     * @return null if yellow key is not found.
     */
    public YellowKey findAndRemoveYellowKey() {
        Iterator<CollectableItems> iterator = items.iterator();
        while (iterator.hasNext()) {
            CollectableItems item = iterator.next();
            if (item instanceof YellowKey) {
                iterator.remove();
                yellowKeyCount--;
                notifyUpdateListener();
                return (YellowKey) item;
            }
        }
        return null;
    }

    /**
     * Searches for chip in the player's inventory and
     * removes it.
     * @return null if chip key is not found.
     */
    public Chip findAndRemoveChip() {
        Iterator<CollectableItems> iterator = items.iterator();
        while (iterator.hasNext()) {
            CollectableItems item = iterator.next();
            if (item instanceof Chip) {
                iterator.remove();
                chipCount--;
                notifyUpdateListener();
                return (Chip) item;
            }
        }
        return null;
    }

    /**
     * Gets a list of all collectable items present in the
     * player's inventory.
     * @return items a list containing all the collectable items.
     */
    public List<CollectableItems> getItems() {
        return items;
    }

    /**
     * Gets a list of images associated with the collectable
     * items currently present in the player's inventory.
     * @return images a list containing image instances
     * associated with the collectable items in player's inventory.
     */
    public List<Image> getImages() {
        List<Image> images = new ArrayList<>();
        for (CollectableItems item : items) {
            images.add(new Image(item.getFilename()));
        }
        return images;
    }


    /**
     * Sets the listener for inventory update events.
     * @param listener to be set as the update listener.
     */
    public void setUpdateListener(InventoryUpdateListener listener) {
        this.updateListener = listener;
    }

    /**
     * Notifies the notifyUpdateListener of a change in
     * the player's inventory.
     */
    private void notifyUpdateListener() {
        if (updateListener != null) {
            updateListener.onInventoryUpdate();
        }
    }
}