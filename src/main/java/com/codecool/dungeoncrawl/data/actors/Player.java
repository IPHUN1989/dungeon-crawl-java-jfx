package com.codecool.dungeoncrawl.data.actors;

import com.codecool.dungeoncrawl.data.Cell;
import com.codecool.dungeoncrawl.data.items.Item;

import java.util.ArrayList;
import java.util.List;
import com.codecool.dungeoncrawl.data.CellType;
import com.codecool.dungeoncrawl.data.items.Key;


public class Player extends Actor {

    private final List<Item> inventoryList;
    public Player(Cell cell) {
        super(cell);
        this.inventoryList = new ArrayList<>();
    }

    @Override
    public void generalMove(int dx, int dy) {
        Cell nextCell = getCell().getNeighbor(dx, dy);
        if (nextCell.getType().isWalkable() && !nextCell.hasActor()) {
            getCell().setActor(null);
            handlePickingUpItems();
            nextCell.setActor(this);
            setCell(nextCell);
            if (getCell().getType() == CellType.FIRE){
                damage(1);
            }
        }
        enterExit(nextCell);
    }

    public void enterExit(Cell cell) {
        if (cell.getType() == CellType.DOOR && playerHasTheKey(inventoryList))
            cell.setType(CellType.EXIT);
    }

    private boolean playerHasTheKey (List <Item> inventoryList) {
        return inventoryList.stream().anyMatch(item -> item.getTileName().equals("key"));
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

    public String getInventoryList() {return inventoryList.get(inventoryList.size()-1).getTileName();}

    public void setInventoryList(Item item) {
        inventoryList.add(item);
    }

}
