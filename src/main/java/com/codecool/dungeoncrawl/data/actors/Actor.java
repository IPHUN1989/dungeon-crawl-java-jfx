package com.codecool.dungeoncrawl.data.actors;

import com.codecool.dungeoncrawl.data.Cell;
import com.codecool.dungeoncrawl.data.CellType;
import com.codecool.dungeoncrawl.data.Drawable;

public abstract class Actor implements Drawable {
    private Cell cell;
    private int health;

    private int attack;

    public void setHealth(int health) {
        this.health = health;
    }

    public Actor(Cell cell, int attack, int health) {
        this.cell = cell;
        this.cell.setActor(this);
        this.attack = attack;
        this.health = health;
    }

    public void generalMove(int dx, int dy) {
        Cell nextCell = getCell().getNeighbor(dx, dy);
        if (nextCell.getType().isWalkable() && !nextCell.hasActor()) {
            getCell().setActor(null);
            nextCell.setActor(this);
            setCell(nextCell);
        }
    }

    public int getHealth() {
        return health;
    }

    public boolean celHasActor () {
        return (getCell().hasActor());
    }

    public void damage (int amount) {
        this.health = this.health - amount;
    }
    public boolean healthBarCheck (int health) {
        return (health <= 0);
    }


    public Cell getCell() {
        return cell;
    }

    public int getX() {
        return cell.getX();
    }

    public void attackOtherActor(Cell cell, Cell nextCell) {
        int newHealth = nextCell.getActor().getHealth() - cell.getActor().getAttack();
        nextCell.getActor().setHealth(newHealth);
        System.out.println(nextCell.getActor().getHealth());
        System.out.println(cell.getActor().getHealth());
    }

    public int getAttack() {
        return attack;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }

    public int getY() {
        return cell.getY();
    }

    protected void setCell(Cell cell) {
        this.cell = cell;
    }
}
