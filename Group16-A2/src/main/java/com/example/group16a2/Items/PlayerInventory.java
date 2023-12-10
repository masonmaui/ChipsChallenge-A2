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

    public PlayerInventory() {
        items = new ArrayList<>();
    }

    public int getChipCount() {
        return chipCount;
    }

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

    public boolean containsBlueKey() {
        return blueKeyCount > 0;
    }

    public boolean containsRedKey() {
        return redKeyCount > 0;
    }

    public boolean containsGreenKey() {
        return greenKeyCount > 0;
    }

    public boolean containsYellowKey() {
        return yellowKeyCount > 0;
    }

    public boolean containsChip() {
        return chipCount > 0;
    }

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

    public List<CollectableItems> getItems() {
        return items;
    }

    public List<Image> getImages() {
        List<Image> images = new ArrayList<>();
        for (CollectableItems item : items) {
            images.add(new Image(item.getFilename()));
        }
        return images;
    }

    public void setUpdateListener(InventoryUpdateListener listener) {
        this.updateListener = listener;
    }

    private void notifyUpdateListener() {
        if (updateListener != null) {
            updateListener.onInventoryUpdate();
        }
    }
}