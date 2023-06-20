package com.codecool.dungeoncrawl.data.actors;

import com.codecool.dungeoncrawl.data.Cell;
import com.codecool.dungeoncrawl.data.items.Item;

import java.util.ArrayList;
import java.util.List;
import com.codecool.dungeoncrawl.data.CellType;


public class Player extends Actor {

    private final List<Item> inventoryList;
    public Player(Cell cell) {
        super(cell);
        this.inventoryList = new ArrayList<>();
    }

    @Override
    public void move(int dx, int dy) {
        Cell nextCell = getCell().getNeighbor(dx, dy);
        if (nextCell.isCellType(CellType.FLOOR) && !nextCell.hasActor()) {
            getCell().setActor(null);
            handlePickingUpItems();
            nextCell.setActor(this);
            setCell(nextCell);
        }
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

    public String getInventoryList() {return inventoryList.get(0).getTileName();}

    public void setInventoryList(Item item) {
        inventoryList.add(item);
    }

}
