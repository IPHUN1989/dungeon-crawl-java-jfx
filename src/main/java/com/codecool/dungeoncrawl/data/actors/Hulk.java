package com.codecool.dungeoncrawl.data.actors;

import com.codecool.dungeoncrawl.data.Cell;
import com.codecool.dungeoncrawl.data.CellType;

public class Hulk extends Actor implements MonsterMove {

    public Hulk(Cell cell, int attack, int health) {
        super(cell, attack, health);
    }

    @Override
    public void move() {
        if (celHasActor()) {
            Cell nextUpperCell = getCell().getNeighbor(0, -1);
            Cell nextLowerCell = getCell().getNeighbor(0, 1);
            Cell nextLeftCell = getCell().getNeighbor(-1, 0);
            Cell nextRightCell = getCell().getNeighbor(1, 0);
            if (isDead(this.getHealth())) {
                System.out.println("Died");
                getCell().setActor(null);
                getCell().setType(CellType.DEAD);
            } else {
                if (nextUpperCell.hasActor() && nextUpperCell.getActor().getTileName().equals("player")) {
                    generalMove(0, -1);
                    attackOtherActor(getCell(), nextUpperCell);
                } else if (nextLowerCell.hasActor() && nextLowerCell.getActor().getTileName().equals("player")) {
                    generalMove(0, 1);
                    attackOtherActor(getCell(), nextLowerCell);
                }
                else if (nextLeftCell.hasActor() && nextLeftCell.getActor().getTileName().equals("player")) {
                    generalMove(-1, 0);
                    attackOtherActor(getCell(), nextLeftCell);
                } else if (nextRightCell.hasActor() && nextRightCell.getActor().getTileName().equals("player")) {
                    generalMove(1, 0);
                    attackOtherActor(getCell(), nextRightCell);
                }
            }
        }
    }

    @Override
    public String getTileName() {
        return "hulk";
    }
}
