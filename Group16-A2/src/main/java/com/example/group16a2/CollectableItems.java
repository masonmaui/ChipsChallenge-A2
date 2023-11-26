package com.example.group16a2;

public class CollectableItems {
    public Boolean isConsumable = true;
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
