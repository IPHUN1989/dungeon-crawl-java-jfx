package com.codecool.dungeoncrawl.data.actors;

import com.codecool.dungeoncrawl.data.Cell;
import com.codecool.dungeoncrawl.data.CellType;
import com.codecool.dungeoncrawl.data.items.Item;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;


public class Player extends Actor {

    private final List<Item> inventoryList;

    public Player(Cell cell, int attack, int health) {
        super(cell, attack, health);
        this.inventoryList = new ArrayList<>();
    }

    @Override
    public void generalMove(int dx, int dy) {
        if (celHasActor()) {
            increasingAttack();
            Cell nextCell = getCell().getNeighbor(dx, dy);
            if (isDead(this.getHealth())) {
                System.out.println("Died");
                nextCell.setActor(null);
                getCell().setActor(null);
                getCell().setType(CellType.DEAD);
            } else {
                if (nextCell.getType().isWalkable() && !nextCell.hasActor()) {
                    getCell().setActor(null);
                    handlePickingUpItems();
                    nextCell.setActor(this);
                    setCell(nextCell);
                    if (getCell().getType() == CellType.FIRE) {
                        damage(1);
                    }
                } else if (nextCell.hasActor()) {
                    attackOtherActor(getCell(), nextCell);
                }
                enterExit(nextCell);
            }
        }
    }

    public void enterExit(Cell cell) {
        if (cell.getType() == CellType.DOOR && playerHasTheKey(inventoryList))
            cell.setType(CellType.EXIT);
    }

    public void increasingAttack() {
        if (playerHasTheSword(inventoryList))
            setAttack(50);
    }

    private boolean playerHasTheKey(List<Item> inventoryList) {
        return inventoryList.stream().anyMatch(item -> item.getTileName().equals("key"));
    }

    private boolean playerHasTheSword(List<Item> inventoryList) {
        return inventoryList.stream().anyMatch(item -> item.getTileName().equals("sword"));
    }

    protected void handlePickingUpItems() {
        if (getCell().getItem() != null) {
            setInventoryList(getCell().getItem());
            System.out.println(getInventoryList());
        }
        getCell().setItem(null);
    }

    public String getTileName() {
        return "player";
    }

    public Stream<Item> getInventoryList() {
        return inventoryList.stream();
    }

    public void setInventoryList(Item item) {
        inventoryList.add(item);
    }

}
