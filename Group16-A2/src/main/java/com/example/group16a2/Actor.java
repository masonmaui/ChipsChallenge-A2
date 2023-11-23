package com.example.group16a2;

import java.util.Arrays;

class Actor {
    private int[] position;
    private String name;

    // Constructor
    public Actor() {
        // Default constructor
    }

    // Parameterized constructor
    public Actor(int[] position, String name) {
        this.position = position;
        this.name = name;
    }

    // Method to create save data for the actor
    public String createSaveData() {
        // Assuming a simple format for save data
        return "Position: " + position[0] + ", " + position[1] + "\nName: " + name;
    }

    // Getter method for position
    public int[] getPosition() {
        return position;
    }

    // Overridden toString() method for better representation
    @Override
    public String toString() {
        return "Actor{" +
                "position=" + Arrays.toString(position) +
                ", name='" + name + '\'' +
                '}';
    }
}