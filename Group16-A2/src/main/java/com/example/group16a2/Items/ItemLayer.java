package com.example.group16a2.Items;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;


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

    public ItemLayer(String filename) {
        this.filename = filename;
        items = readDataFile(filename);
    }

    //get tiles
    public CollectableItems[][] getItems() {
        return items;
    }

    //Adds item to inventory array inside ItemLayer, unique to each ItemLayer, might be changed.
    //Also called in CollectableItems so items can be added directly.
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

    public void addItemToLayer(int[] coords, CollectableItems itemToInsert) {
        //insert item into whatever javafx stuff going on at coords, also check it's within bounds
    }

    public int[] findItemInLayer(CollectableItems itemQuery) {
        return new int[]{0, 0};
    }

    public void removeItemFromLayer(int[] coords, CollectableItems itemToRemove) {
        //insert item into whatever javafx stuff going on at coords, also check it's within bounds
    }

    public void saveLayer() {
        //Inventory section
        //Use toString functions from each item to create strings for each corrosponding item
        // use "/" for empty space
    }


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

    public static void main(String[] args) {
        ItemLayer itemlayer = new ItemLayer("Levels/Level1ItemLayer.txt");

        for (int i = 0; i < itemlayer.getItems().length; i++) {
            for (int j = 0; j < itemlayer.getItems()[i].length; j++) {
                System.out.print(itemlayer.getItems()[i][j] + " ");
            }
            System.out.println();
        }

        //get file names of the items
        System.out.println(itemlayer.getItems()[0][0].getFilename());
    }
}