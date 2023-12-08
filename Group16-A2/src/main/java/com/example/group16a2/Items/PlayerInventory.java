package com.example.group16a2.Items;

import javafx.scene.image.Image;

import java.util.ArrayList;
import java.util.List;

public class PlayerInventory {
    private ArrayList<CollectableItems> items;

    public PlayerInventory() {
        this.items = new ArrayList<>();
    }

    public void addItem(CollectableItems item) {
        items.add(item);
    }

    public void removeItem(CollectableItems item) {
        items.remove(item);
    }

    public ArrayList<CollectableItems> getItems() {
        return items;
    }

    public List<Image> getImages() {
        List<Image> images = new ArrayList<>();
        for (CollectableItems item : items) {
            if (item.isCollected()) {
                // Assuming getFilename() returns the file path or URL of the item's image
                Image image = new Image(item.getFilename());
                images.add(image);
            }
        }
        return images;
    }
}