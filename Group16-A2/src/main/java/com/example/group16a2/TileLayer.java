package com.example.group16a2;

public class TileLayer {

    private Path[] paths;
    private Water[] waters;
    private Wall[] walls;
    private Exit[] exits;
    private Button[] buttons;
    private Trap [] traps;
    private ChipSocket[] chipSockets;
    private LockedDoor[] lockedDoors;
    private Ice[] ices;
    private Dirt[] dirts;

    public TileLayer(Path[] paths, Water[] waters, Wall[] walls, Exit[] exits, Button[] buttons, Trap [] traps, ChipSocket[] chipSockets, LockedDoor[] lockedDoors, Ice[] ices, Dirt[] dirts) {
        this.paths = paths;
        this.waters = waters;
        this.walls = walls;
        this.exits = exits;
        this.buttons = buttons;
        this.traps = traps;
        this.chipSockets = chipSockets;
        this.lockedDoors = lockedDoors;
        this.ices = ices;
        this.dirts = dirts;
    }


}
