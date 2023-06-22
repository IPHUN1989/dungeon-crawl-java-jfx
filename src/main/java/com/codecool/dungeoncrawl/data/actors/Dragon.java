package com.codecool.dungeoncrawl.data.actors;

import com.codecool.dungeoncrawl.data.Cell;
import com.codecool.dungeoncrawl.data.CellType;

public class Dragon extends Actor implements MonsterMove {
    private int direction = 1;

    public Dragon(Cell cell, int attack, int health) {
        super(cell, attack, health);
    }

    @Override
    public void move() {
        if (celHasActor()) {
            Cell nextUpperCell = getCell().getNeighbor(0, -1);
            Cell nextLowerCell = getCell().getNeighbor(0, 1);
            if (!nextUpperCell.getType().isWalkable() || !nextLowerCell.getType().isWalkable()) {
                changeDirection();
                generalMove(0, direction);
            } else if (nextUpperCell.hasActor() && nextUpperCell.getActor().getTileName().equals("player")) {
                generalMove(0, -1);
                attackOtherActor(getCell(), nextUpperCell);
            } else if (nextLowerCell.hasActor() && nextLowerCell.getActor().getTileName().equals("player")) {
                generalMove(0, 1);
                attackOtherActor(getCell(), nextLowerCell);
            } else {
                generalMove(0, direction);
            }
        }
    }

    @Override
    public boolean isAlive() {
        return getHealth() > 0;
    }

    private void changeDirection() {
        this.direction = this.direction * -1;
    }

    @Override
    public String getTileName() {
        return "dragon";
    }
}
