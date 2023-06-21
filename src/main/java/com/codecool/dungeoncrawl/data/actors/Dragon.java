package com.codecool.dungeoncrawl.data.actors;

import com.codecool.dungeoncrawl.data.Cell;

public class Dragon extends Actor implements MonsterMove{

    public Dragon(Cell cell) {
        super(cell);
    }

    @Override
    public void move() {
    }

    @Override
    public String getTileName() {
        return "dragon";
    }
}
