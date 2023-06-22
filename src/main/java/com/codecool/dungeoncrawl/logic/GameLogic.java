package com.codecool.dungeoncrawl.logic;

import com.codecool.dungeoncrawl.data.Cell;
import com.codecool.dungeoncrawl.data.Drawable;
import com.codecool.dungeoncrawl.data.GameMap;

import java.util.stream.Collectors;

public class GameLogic {
    private GameMap map;

    public GameLogic() {
        this.map = MapLoader.loadMap();
    }

    public double getMapWidth() {
        return map.getWidth();
    }

    public double getMapHeight() {
        return map.getHeight();
    }

    public void setup() {
    }

    public Cell getCell(int x, int y) {
        return map.getCell(x, y);
    }

    public String getPlayerHealth() {
        return Integer.toString(map.getPlayer().getHealth());
    }

    public int getPlayersXCoordinate() {
        return map.getPlayer().getCell().getX();
    }

    public int getPlayersYCoordinate() {
        return map.getPlayer().getCell().getY();
    }

    public String getInventory() {
        return map.getPlayer().getInventoryList().map(Drawable::getTileName).collect(Collectors.joining("\n"));
    }


    public GameMap getMap() {
        return map;
    }
}
