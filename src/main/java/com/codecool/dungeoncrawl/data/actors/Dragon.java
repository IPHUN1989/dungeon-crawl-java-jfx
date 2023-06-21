package com.codecool.dungeoncrawl.data.actors;

import com.codecool.dungeoncrawl.data.Cell;

public class Dragon extends Actor implements MonsterMove{
    private int direction = 1;

    public Dragon(Cell cell) {
        super(cell);
    }

    @Override
    public void move() {
        Cell nextUpperCell = getCell().getNeighbor(0, -1);
        Cell nextLowerCell = getCell().getNeighbor(0,1);
        if(!nextUpperCell.getType().isWalkable() || !nextLowerCell.getType().isWalkable()){
            changeDirection();
            generalMove(0, direction);
        } else {
            generalMove(0, direction);
        }
    }

    private void changeDirection () {
        this.direction = this.direction * -1;
    }

    @Override
    public String getTileName() {
        return "dragon";
    }
}
