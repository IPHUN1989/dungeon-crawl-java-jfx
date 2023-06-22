package com.codecool.dungeoncrawl.data.actors;

import com.codecool.dungeoncrawl.data.Cell;
import com.codecool.dungeoncrawl.data.CellType;

import java.util.ArrayList;
import java.util.List;

public class Hulk extends Monster implements MonsterMove {

    public Hulk(Cell cell, int attack, int health) {
        super(cell, attack, health);
    }

    @Override
    public void move() {
        if (playerGetsInSightOfMonster()) {
            monsterFollowingPlayer();
        }
    }

    @Override
    public boolean isAlive() {
        return getHealth() > 0;
    }

    @Override
    public String getTileName() {
        return "hulk";
    }
}
