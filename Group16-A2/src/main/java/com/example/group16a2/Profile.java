package com.example.group16a2;

public class Profile extends Menu {
    private String name;
    private int maxLevel;

    public void Profile(String name, int maxLevel) {
        this.name=name;
        this.maxLevel = maxLevel;
    }

    // Getter for name
    public String getName() {
        return name;
    }

    // Setter for name
    public void setName(String name) {
        this.name = name;
    }

    // Getter for maxLevel
    public int getmaxLevel() {
        return maxLevel;
    }

    // Setter for maxLevel
    public void setMaxLevel(int maxLevel) {
        this.maxLevel = maxLevel;
    }


    // Example method to display profile details
    public void displayProfileDetails() {
        System.out.println("Profile Details:");
        System.out.println("Max Level: " + maxLevel);
    }

    @Override
    public String toString() {
        return "Profile{" +
                "name='" + name + '\'' +
                ", maxLevel=" + maxLevel +
                '}';
    }

}




