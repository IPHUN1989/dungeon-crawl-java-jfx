package com.codecool.dungeoncrawl.data.actors;

import com.codecool.dungeoncrawl.App;
import com.codecool.dungeoncrawl.data.Cell;
import com.codecool.dungeoncrawl.data.CellType;

import java.util.Random;

public class Ghost extends Actor implements MonsterMove {

    public Ghost(Cell cell, int attack, int health) {
        super(cell, attack, health);
    }


    @Override
    public void move() {
        Random random = new Random();
        int[] coordinates = {-1, 0, 1};
        int coordinate = random.nextInt(2);
        Cell nextUpperCell = getCell().getNeighbor(0, -1);
        Cell nextLowerCell = getCell().getNeighbor(0, 1);
        Cell nextLeftCell = getCell().getNeighbor(-1, 0);
        Cell nextRightCell = getCell().getNeighbor(1, 0);
        if (nextUpperCell.hasActor() && nextUpperCell.getActor().getTileName().equals("player")) {
            generalMove(0, -1);
            attackOtherActor(getCell(), nextUpperCell);
        } else if (nextLowerCell.hasActor() && nextLowerCell.getActor().getTileName().equals("player")) {
            generalMove(0, 1);
            attackOtherActor(getCell(), nextLowerCell);
        } else if (nextLeftCell.hasActor() && nextLeftCell.getActor().getTileName().equals("player")) {
            generalMove(-1, 0);
            attackOtherActor(getCell(), nextLeftCell);
        } else if (nextRightCell.hasActor() && nextRightCell.getActor().getTileName().equals("player")) {
            generalMove(1, 0);
            attackOtherActor(getCell(), nextRightCell);
        } else if (coordinate == 0) {
            super.generalMove(coordinates[random.nextInt(3)], 0);
        } else {
            super.generalMove(0, coordinates[random.nextInt(3)]);
        }
    }

    @Override
    public boolean isAlive() {
        return getHealth() > 0;
    }

    @Override
    public String getTileName() {
        return "ghost";
    }
}
