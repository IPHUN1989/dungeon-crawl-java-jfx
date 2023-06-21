package com.codecool.dungeoncrawl.ui.keyeventhandler;

import com.codecool.dungeoncrawl.data.GameMap;
import com.codecool.dungeoncrawl.data.actors.Actor;
import com.codecool.dungeoncrawl.data.actors.MonsterMove;
import javafx.scene.input.KeyEvent;

public abstract class KeyHandler {

    public abstract void perform(KeyEvent event, GameMap map);

    protected void moveMonsters (GameMap map) {
        for (MonsterMove monster : map.getMonsters()){
            monster.move();
        }
    }
}
