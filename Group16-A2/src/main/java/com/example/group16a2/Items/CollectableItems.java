package com.example.group16a2.Items;

import com.example.group16a2.Items.ItemLayer;

//This class is made to encompass all items, it allows to use functions on different types of items, and store
//them together. This is most useful in the item layer where we search for items or play their actions.
public class CollectableItems {
    private Boolean isConsumable = true;
    public CollectableItems(){
    }

    public void addToPlayerInventory(ItemLayer targetInv){
        targetInv.insertToInventory(this);
    }

    public void Action(){
    }

    public Boolean getConsumable() {
        return isConsumable;
    }
}
