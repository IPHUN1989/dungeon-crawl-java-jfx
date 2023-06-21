package com.codecool.dungeoncrawl.ui.keyeventhandler;

import com.codecool.dungeoncrawl.data.GameMap;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

public class Left extends KeyHandler {
    public static final KeyCode code = KeyCode.LEFT;

    @Override
    public void perform(KeyEvent event, GameMap map) {
        if (code.equals(event.getCode())){
            map.getPlayer().generalMove(-1, 0);
            moveMonsters(map);
        }
    }
}
