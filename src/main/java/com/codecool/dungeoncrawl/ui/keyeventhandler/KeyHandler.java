package com.codecool.dungeoncrawl.ui.keyeventhandler;

import com.codecool.dungeoncrawl.data.GameMap;
import com.codecool.dungeoncrawl.data.actors.Actor;
import com.codecool.dungeoncrawl.data.actors.MonsterMove;
import com.codecool.dungeoncrawl.logic.GameLogic;
import javafx.scene.input.KeyEvent;

public abstract class KeyHandler {

    public abstract void perform(KeyEvent event, GameLogic logic);

}
