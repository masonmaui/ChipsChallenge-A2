package com.example.group16a2;
import java.util.ArrayList;


public class ItemLayer {
    private int[] size = new int [2];
    private ArrayList<CollectableItems> inventory = new ArrayList<>();
    private int chipCount = 0;
    //currentLayer is for testing
    private String[][] currentLayer;

    public ItemLayer(int x, int y){
        size = new int[]{x, y};
        currentLayer = new String[x][y];
    }

    //Adds item to inventory array inside ItemLayer, unique to each ItemLayer, might be changed.
    //Also called in CollectableItems so items can be added directly.
    public void insertToInventory(CollectableItems pickedUpItem){
        inventory.add(pickedUpItem);
    }

    //Each item will have an Action function, this function can be called when the conditions of
    //the item are reached. <- GameController will most likely make the checks for them like:
    // Actor next to door -> use corresponding key (call this function)
    public void useFromInventory(CollectableItems usedItem){
        usedItem.Action();
        if (usedItem.isConsumable){
            inventory.remove(usedItem);
        }
    }

    public void updateChipCount(int toIncrement){
        chipCount+= toIncrement;
    }

    public void addItemToLayer(int[] coords, CollectableItems[] itemToInsert){
        //insert item into whatever javafx stuff going on at coords, also check it's within bounds
    }
    public void removeItemFromLayer(int[] coords, CollectableItems[] itemToInsert){
        //insert item into whatever javafx stuff going on at coords, also check it's within bounds
    }

    public void saveLayer(){
        //Inventory section
        //Use toString functions from each item to create strings for each corrosponding item
        // use "/" for empty space
    }
    public void loadLayer(){
    }
}
