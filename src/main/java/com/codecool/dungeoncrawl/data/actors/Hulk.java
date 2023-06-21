package com.codecool.dungeoncrawl.data.actors;

import com.codecool.dungeoncrawl.data.Cell;

public class Hulk extends Actor implements MonsterMove{

    public Hulk(Cell cell) {
        super(cell);
    }

    @Override
    public void move() {

    }

    @Override
    public String getTileName() {
        return "hulk";
    }
}
