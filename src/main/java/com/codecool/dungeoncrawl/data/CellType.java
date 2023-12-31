package com.codecool.dungeoncrawl.data;

public enum CellType {
    EMPTY("empty", false),
    FLOOR("floor", true),
    WALL("wall", false),
    DOOR("door", false),
    EXIT("exit", true),
    FIRE ("fire", true),
    DEAD ("dead", false),
    STAIRS ("stairs", true);

    private final String tileName;
    private final boolean isWalkable;

    CellType(String tileName, boolean isWalkable) {
        this.tileName = tileName;
        this.isWalkable = isWalkable;
    }

    public String getTileName() {
        return tileName;
    }

    public boolean isWalkable() {
        return isWalkable;
    }
}
