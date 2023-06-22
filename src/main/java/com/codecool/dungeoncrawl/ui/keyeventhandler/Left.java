package com.codecool.dungeoncrawl.ui.keyeventhandler;

import com.codecool.dungeoncrawl.data.CellType;
import com.codecool.dungeoncrawl.data.GameMap;
import com.codecool.dungeoncrawl.data.actors.Player;
import com.codecool.dungeoncrawl.logic.GameLogic;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

public class Left extends KeyHandler {
    public static final KeyCode code = KeyCode.LEFT;

    @Override
    public void perform(KeyEvent event, GameLogic logic) {
        if (code.equals(event.getCode())) {
            Player player = logic.getMap().getPlayer();
            if (player.isAlive()){
                player.generalMove(-1, 0);
                if (logic.getMap().getPlayer().getCell().getType().equals(CellType.STAIRS)){
                    logic.setMap("/map2.txt");
                }
                logic.moveMonsters();
                logic.replaceDeadActors();
            }
        }
    }
}
