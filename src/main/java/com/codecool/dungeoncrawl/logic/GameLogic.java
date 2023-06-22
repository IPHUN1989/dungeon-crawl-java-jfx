package com.codecool.dungeoncrawl.logic;

import com.codecool.dungeoncrawl.data.Cell;
import com.codecool.dungeoncrawl.data.CellType;
import com.codecool.dungeoncrawl.data.Drawable;
import com.codecool.dungeoncrawl.data.GameMap;
import com.codecool.dungeoncrawl.data.actors.Actor;
import com.codecool.dungeoncrawl.data.actors.Alive;
import com.codecool.dungeoncrawl.data.actors.MonsterMove;

import java.util.stream.Collectors;

public class GameLogic {
    private GameMap map;

    public GameLogic() {
        this.map = MapLoader.loadMap("/map.txt");
    }
    public void setMap(String pathToMap) {
        this.map = MapLoader.loadMap(pathToMap);
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

    public void moveMonsters () {
        map.getMonsters().filter(Alive::isAlive).forEach(MonsterMove::move);

    }

    public void replaceDeadActors () {
        map.getActors().filter(actor -> !actor.isAlive()).forEach(Actor::handleDeath);
    }

    public GameMap getMap() {
        return map;
    }
}
