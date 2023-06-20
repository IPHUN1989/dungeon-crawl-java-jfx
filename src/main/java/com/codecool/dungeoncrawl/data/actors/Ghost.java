package com.codecool.dungeoncrawl.data.actors;

import com.codecool.dungeoncrawl.App;
import com.codecool.dungeoncrawl.data.Cell;
import com.codecool.dungeoncrawl.data.CellType;

import java.util.Random;

public class Ghost extends Actor{

    public Ghost(Cell cell) {
        super(cell);
    }


    @Override
    public void move() {
        int[] coordinates = {-1, 0, 1};
        int coordinate = App.random.nextInt(2);
        if (coordinate == 0){
            super.move(coordinates[App.random.nextInt(3)],0);
        } else {
            super.move(0, coordinates[App.random.nextInt(3)]);
        }
    }

    @Override
    public String getTileName() {
        return "ghost";
    }
}
