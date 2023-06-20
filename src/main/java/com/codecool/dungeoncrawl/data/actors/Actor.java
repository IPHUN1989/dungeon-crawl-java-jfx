package com.codecool.dungeoncrawl.data.actors;

import com.codecool.dungeoncrawl.data.Cell;
import com.codecool.dungeoncrawl.data.Drawable;
import com.codecool.dungeoncrawl.data.items.Item;

import java.util.ArrayList;
import java.util.List;

public abstract class Actor implements Drawable {
    private Cell cell;
    private int health = 10;

    private List<Item> inventoryList;

    public Actor(Cell cell) {
        this.cell = cell;
        this.cell.setActor(this);
        this.inventoryList = new ArrayList<>();
    }

    public void move(int dx, int dy) {
        Cell nextCell = cell.getNeighbor(dx, dy);
        cell.setActor(null);
        handlePickingUpItems();
        nextCell.setActor(this);
        cell = nextCell;
    }

    protected void handlePickingUpItems() {
        if (cell.getItem() != null) {
            setInventoryList(cell.getItem());
            System.out.println(getInventoryList());
        }
        cell.setItem(null);
    }

    public int getHealth() {
        return health;
    }

    public String getInventoryList() {return inventoryList.get(0).getTileName();}

    public void setInventoryList(Item item) {
        inventoryList.add(item);
    }

    public Cell getCell() {
        return cell;
    }

    public int getX() {
        return cell.getX();
    }

    public int getY() {
        return cell.getY();
    }
}
