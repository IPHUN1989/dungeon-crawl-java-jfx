package com.codecool.dungeoncrawl.ui.elements;

import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;

public class StatusPane {
    public static final int RIGHT_PANEL_WIDTH = 200;
    public static final int RIGHT_PANEL_PADDING = 10;
    private GridPane ui;
    private Label healthTextLabel;
    private Label healthValueLabel;
    private Label inventoryTextLabel;
    private Label inventoryValueLabel;
    private Label gameStatusLabel;

    public StatusPane() {
        ui = new GridPane();
        healthTextLabel = new Label("Health: ");
        healthValueLabel = new Label();
        inventoryTextLabel = new Label("Inventory: ");
        inventoryValueLabel = new Label();
        gameStatusLabel = new Label();

    }

    public BorderPane build() {

        ui.setPrefWidth(RIGHT_PANEL_WIDTH);
        ui.setPadding(new Insets(RIGHT_PANEL_PADDING));

        ui.add(healthTextLabel, 0, 0);
        ui.add(healthValueLabel, 1, 0);
        ui.add(new Label("-----"), 0, 1);
        ui.add(inventoryTextLabel, 0, 2);
        ui.add(inventoryValueLabel, 1, 2);
        ui.add(new Label("-----"), 0, 4);
        ui.add(gameStatusLabel, 0, 5);

        BorderPane borderPane = new BorderPane();
        borderPane.setRight(ui);
        return borderPane;
    }

    public void setHealthValue(String text) {
        healthValueLabel.setText(text);
    }

    public void setInventoryValue(String text) {
        inventoryValueLabel.setText(text);
    }

    public void setGameStatusLabel(String text) {
        gameStatusLabel.setText(text);
    }
}
