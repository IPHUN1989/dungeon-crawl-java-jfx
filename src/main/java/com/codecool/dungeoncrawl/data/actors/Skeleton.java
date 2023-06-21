package com.codecool.dungeoncrawl.data.actors;

import com.codecool.dungeoncrawl.data.Cell;

public class Skeleton extends Actor implements MonsterMove {
    private int direction = -1;

    public Skeleton(Cell cell) {
        super(cell);
    }

    @Override
    public void move() {
        Cell nextLeftCell = getCell().getNeighbor(-1, 0);
        Cell nextRightCell = getCell().getNeighbor(1,0);
        if(!nextLeftCell.getType().isWalkable() || !nextRightCell.getType().isWalkable()){
            changeDirection();
            generalMove(direction,0);
        } else {
            generalMove(direction,0);
        }
    }

    private void changeDirection () {
        this.direction = this.direction * -1;
    }


    @Override
    public String getTileName() {
        return "skeleton";
    }
}
