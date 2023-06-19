package com.codecool.dungeoncrawl.data.actors;

import com.codecool.dungeoncrawl.data.Cell;

public class Dragon extends Actor{

    public Dragon(Cell cell) {
        super(cell);
    }

    @Override
    public String getTileName() {
        return "dragon";
    }
}
