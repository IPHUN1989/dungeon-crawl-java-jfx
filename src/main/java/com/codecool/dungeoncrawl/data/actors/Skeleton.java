package com.codecool.dungeoncrawl.data.actors;

import com.codecool.dungeoncrawl.data.Cell;

public class Skeleton extends Actor implements MonsterMove{


    public Skeleton(Cell cell) {
        super(cell);
    }

    @Override
    public void move() {

    }

    @Override
    public String getTileName() {
        return "skeleton";
    }
}
