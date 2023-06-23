package com.codecool.dungeoncrawl.ui;

import com.codecool.dungeoncrawl.data.Cell;
import com.codecool.dungeoncrawl.logic.GameLogic;
import com.codecool.dungeoncrawl.ui.elements.MainStage;
import com.codecool.dungeoncrawl.ui.keyeventhandler.KeyHandler;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.util.Set;

public class UI {
    private static final double MAX_MAP_WIDTH = 25;
    private static final double MAX_MAP_HEIGHT = 20;
    private Canvas canvas;
    private GraphicsContext context;

    private MainStage mainStage;
    private GameLogic logic;
    private Set<KeyHandler> keyHandlers;


    public UI(GameLogic logic, Set<KeyHandler> keyHandlers) {
        this.canvas = new Canvas(
                MAX_MAP_WIDTH * Tiles.TILE_WIDTH,
                MAX_MAP_HEIGHT * Tiles.TILE_WIDTH);
        this.logic = logic;
        this.context = canvas.getGraphicsContext2D();
        this.mainStage = new MainStage(canvas);
        this.keyHandlers = keyHandlers;
    }

    public void setUpPain(Stage primaryStage) {
        Scene scene = mainStage.getScene();
        primaryStage.setScene(scene);
        logic.setup();
        refresh();
        scene.setOnKeyPressed(this::onKeyPressed);
    }

    private void onKeyPressed(KeyEvent keyEvent) {
        for (KeyHandler keyHandler : keyHandlers) {
            keyHandler.perform(keyEvent, logic);
        }
        refresh();
    }

    public void refresh() {
        context.setFill(Color.BLACK);
        context.fillRect(0, 0, canvas.getWidth(), canvas.getHeight());

        for (int i = 0; i < MAX_MAP_WIDTH; i++) {
            double x = xCoordinateOfFirstCell() + i;
            for (int j =0; j < MAX_MAP_HEIGHT; j++) {
                double y = yCoordinateOfFirstCell() + j;
                Cell cell = logic.getCell((int) x, (int) y);
                if (cell.getActor() != null) {
                    Tiles.drawTile(context, cell.getActor(), i, j);
                } else if (cell.getItem() != null) {
                    Tiles.drawTile(context, cell.getItem(), i, j);
                } else {
                    Tiles.drawTile(context, cell, i, j);
                }
            }
        }
        if (!logic.getMap().getPlayer().isAlive()) {
            mainStage.setGameStatusLabelText("YOU LOST!");
        }
        mainStage.setHealthLabelText(logic.getPlayerHealth());
        mainStage.setInventoryLabelText(logic.getInventory());
    }

    private double xCoordinateOfFirstCell() {
        int playersXCoordinate = logic.getPlayersXCoordinate();
        double mapWidth = logic.getMapWidth();

        if (playersXCoordinate < MAX_MAP_WIDTH / 2) return 0;
        if (playersXCoordinate + MAX_MAP_WIDTH / 2 > mapWidth) return mapWidth - MAX_MAP_WIDTH;
        return playersXCoordinate - MAX_MAP_WIDTH / 2;
    }

    private double yCoordinateOfFirstCell() {
        int playersYCoordinate = logic.getPlayersYCoordinate();
        double mapHeight = logic.getMapHeight();

        if (playersYCoordinate < MAX_MAP_HEIGHT / 2) return 0;
        if (playersYCoordinate + MAX_MAP_HEIGHT / 2 > mapHeight) return mapHeight - MAX_MAP_HEIGHT;
        return playersYCoordinate - MAX_MAP_HEIGHT / 2;
    }
}
