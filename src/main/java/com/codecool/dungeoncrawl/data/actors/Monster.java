package com.codecool.dungeoncrawl.data.actors;

import com.codecool.dungeoncrawl.data.Cell;

import java.util.ArrayList;
import java.util.List;

public abstract class Monster extends Actor {

    protected Monster(Cell cell, int attack, int health) {
        super(cell, attack, health);
    }

    public void monsterFollowingPlayer() {
        Cell nextUpperCell = getCell().getNeighbor(0, -1);
        Cell nextLowerCell = getCell().getNeighbor(0, 1);
        Cell nextLeftCell = getCell().getNeighbor(-1, 0);
        Cell nextRightCell = getCell().getNeighbor(1, 0);
        Cell leftUpperCorner = getCell().getNeighbor(-1, -1);
        Cell leftLowerCorner = getCell().getNeighbor(-1, 1);
        Cell rightUpperCorner = getCell().getNeighbor(1, -1);
        Cell rightLowerCorner = getCell().getNeighbor(1, 1);
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
        } else if (rightLowerCorner.hasActor() && rightLowerCorner.getActor().getTileName().equals("player")) {
            generalMove(0, 1);
        } else if (rightUpperCorner.hasActor() && rightUpperCorner.getActor().getTileName().equals("player")) {
            generalMove(1, 0);
        } else if (leftLowerCorner.hasActor() && leftLowerCorner.getActor().getTileName().equals("player")) {
            generalMove(0, 1);
        } else if (leftUpperCorner.hasActor() && leftUpperCorner.getActor().getTileName().equals("player")) {
            generalMove(-1, 0);
        }
    }

    public boolean playerGetsInSightOfMonster() {
        List<Cell> coordinates = new ArrayList<>();
        for (int x = -1; x < 2; x++) {
            for (int y = -1; y < 2; y++) {
                coordinates.add(getCell().getNeighbor(x, y));
            }
        }
        return coordinates.stream().anyMatch(cell -> cell.hasActor() && cell.getActor() instanceof Player);
    }
}
