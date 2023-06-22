package com.codecool.dungeoncrawl.ui.keyeventhandler;

import com.codecool.dungeoncrawl.data.GameMap;
import com.codecool.dungeoncrawl.data.actors.Player;
import com.codecool.dungeoncrawl.logic.GameLogic;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

public class Right extends KeyHandler {
    public static final KeyCode code = KeyCode.RIGHT;

    @Override
    public void perform(KeyEvent event, GameLogic logic) {
        if (code.equals(event.getCode())) {
            Player player = logic.getMap().getPlayer();
            if (player.isAlive()){
                player.generalMove(1, 0);
                logic.moveMonsters();
                logic.replaceDeadActors();
            }
        }
    }
}
