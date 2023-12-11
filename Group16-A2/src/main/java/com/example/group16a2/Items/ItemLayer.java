package com.example.group16a2.Items;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * ItemLayer.java
 * Represents the layer where items lie
 * @author Marco Silva
 * @author Mason Emery
 * @version 1.6
 */

public class ItemLayer {
    private int[] size = new int[2];
    private ArrayList<CollectableItems> inventory = new ArrayList<>();
    private int chipCount = 0;
    //currentLayer is for testing
    private String[][] currentLayer;

    //item array
    private CollectableItems[][] items;

    private String filename;

    private int x;
    private int y;


    public ItemLayer(int x, int y) {
        size = new int[]{x, y};
        currentLayer = new String[x][y];
    }

    /**
     * Class constructor
     * @param filename filename of image
     */
    public ItemLayer(String filename) {
        this.filename = filename;
        items = readDataFile(filename);
    }

    /**
     * Return an array of all items
     * @return an array of items
     */
    //get tiles
    public CollectableItems[][] getItems() {
        return items;
    }

    /**
     * Adds item to inventory array inside ItemLayer, unique to each ItemLayer, might be changed.
     * Also called in CollectableItems so items can be added directly.
     * @param pickedUpItem Represents item picked up by player
     */

    public void insertToInventory(CollectableItems pickedUpItem) {
        inventory.add(pickedUpItem);
    }

    //Each item will have an Action function, this function can be called when the conditions of
    //the item are reached. <- GameController will most likely make the checks for them like:
    // Actor next to door -> use corresponding key (call this function)
    public void useFromInventory(CollectableItems usedItem) {
        usedItem.Action();
        if (usedItem.getConsumable()) {
            inventory.remove(usedItem);
        }
    }

    public void updateChipCount(int toIncrement) {
        chipCount += toIncrement;
    }
    
    /**
     * Finds item in layer
     * @param itemQuery item to find
     * @return coordinates of item
     */
    public int[] findItemInLayer(CollectableItems itemQuery) {
        return new int[]{0, 0};
    }

    /**
     * Removes item from layer
     * @param coords coordinates of item
     * @param itemToRemove item to remove
     */
    public void removeItemFromLayer(int[] coords, CollectableItems itemToRemove) {
        //insert item into whatever javafx stuff going on at coords, also check it's within bounds
    }

    /**
     * Reads in items from the text file line by line
     * @param in Scanner
     * @return a grid of all the items
     */
    //used to read each line of the file
    public CollectableItems[][] readEachLine(Scanner in) {
        int lineCount = 0;
        String line = in.nextLine();
        Scanner lineScanner = new Scanner(line);
        y = lineScanner.nextInt();
        x = lineScanner.nextInt();
        lineScanner.close();
        CollectableItems[][] grid = new CollectableItems[y][x];
        while (in.hasNextLine()) {
            String line2 = in.nextLine();
            Scanner lineScanner2 = new Scanner(line2);
            for (int i = 0; i < x; i++) {
                String itemType = lineScanner2.next();
                if (itemType.equals("-")) {
                    grid[lineCount][i] = null;
                }else if(itemType.equals("C")) {
                    grid[lineCount][i] = new Chip();
                }else if(itemType.equals("RK")) {
                    grid[lineCount][i] = new RedKey();
                }else if(itemType.equals("BK")) {
                    grid[lineCount][i] = new BlueKey();
                }else if(itemType.equals("YK")) {
                    grid[lineCount][i] = new YellowKey();
                }else if(itemType.equals("GK")) {
                    grid[lineCount][i] = new GreenKey();
                }
            }
            lineCount++;
        }
        return grid;

    }

    /**
     *checks if file can be found
     * @param filename name of image file
     * @return a grid of items(by calling readEachLine)
     */
    //used to check file exists
    public CollectableItems[][] readDataFile(String filename) {
        Scanner in = null;
        try {
            in = new Scanner(new File(filename));
        } catch (FileNotFoundException e) {
            System.out.println("Could not find " + filename);
            System.exit(-1);
        }
        return readEachLine(in);

    }

}