package com.codecool.dungeoncrawl.data.actors;

import com.codecool.dungeoncrawl.data.Cell;
import com.codecool.dungeoncrawl.data.CellType;

public class Skeleton extends Actor implements MonsterMove {
    private int direction = -1;

    public Skeleton(Cell cell, int attack, int health) {
        super(cell, attack, health);
    }

    @Override
    public void move() {
        Cell nextLeftCell = getCell().getNeighbor(-1, 0);
        Cell nextRightCell = getCell().getNeighbor(1, 0);
        if (!nextLeftCell.getType().isWalkable() || !nextRightCell.getType().isWalkable()) {
            changeDirection();
            generalMove(direction, 0);
        } else if (nextLeftCell.hasActor() && nextLeftCell.getActor().getTileName().equals("player")) {
            generalMove(-1, 0);
            attackOtherActor(getCell(), nextLeftCell);
        } else if (nextRightCell.hasActor() && nextRightCell.getActor().getTileName().equals("player")) {
            generalMove(1, 0);
            attackOtherActor(getCell(), nextRightCell);
        } else {
            generalMove(direction, 0);
        }
    }

    private void changeDirection() {
        this.direction = this.direction * -1;
    }


    @Override
    public String getTileName() {
        return "skeleton";
    }

    @Override
    public boolean isAlive() {
        return getHealth() > 0;
    }
}
