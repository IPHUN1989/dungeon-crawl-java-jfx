package com.codecool.dungeoncrawl.data.items;

import com.codecool.dungeoncrawl.data.Cell;

public class Gold extends Item{
    public Gold(Cell cell) {
        super(cell);
    }

    public String getTileName() {
        return "gold";
    }
}
