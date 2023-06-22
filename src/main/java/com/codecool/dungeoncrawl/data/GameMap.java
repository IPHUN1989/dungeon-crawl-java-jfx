package com.codecool.dungeoncrawl.data;

import com.codecool.dungeoncrawl.data.actors.Actor;
import com.codecool.dungeoncrawl.data.actors.MonsterMove;
import com.codecool.dungeoncrawl.data.actors.Player;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class GameMap {
    private int width;
    private int height;
    private Cell[][] cells;
    private List<MonsterMove> monsters;
    private List<Actor> actors;

    private Player player;

    public GameMap(int width, int height, CellType defaultCellType) {
        this.width = width;
        this.height = height;
        monsters = new ArrayList<>();
        actors = new ArrayList<>();
        cells = new Cell[width][height];
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                cells[x][y] = new Cell(this, x, y, defaultCellType);
            }
        }
    }

    public Cell getCell(int x, int y) {
        return cells[x][y];
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public Player getPlayer() {
        return player;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public void addMonsterToList (MonsterMove monster) {
        monsters.add(monster);
    }

    public void addActorToList (Actor actor) {
        actors.add(actor);
    }

    public Stream<MonsterMove> getMonsters () {
        return monsters.stream();
    }

    public Stream<Actor> getActors() {
        return actors.stream();
    }
}
