package com.codecool.dungeoncrawl.logic;

import com.codecool.dungeoncrawl.data.Cell;
import com.codecool.dungeoncrawl.data.CellType;
import com.codecool.dungeoncrawl.data.GameMap;
import com.codecool.dungeoncrawl.data.actors.*;
import com.codecool.dungeoncrawl.data.actors.Player;
import com.codecool.dungeoncrawl.data.actors.Skeleton;
import com.codecool.dungeoncrawl.data.items.Gold;
import com.codecool.dungeoncrawl.data.items.Key;
import com.codecool.dungeoncrawl.data.items.Sword;

import java.io.InputStream;
import java.util.Scanner;

public class MapLoader {
    public static GameMap loadMap() {
        InputStream is = MapLoader.class.getResourceAsStream("/map.txt");
        Scanner scanner = new Scanner(is);
        int width = scanner.nextInt();
        int height = scanner.nextInt();

        scanner.nextLine(); // empty line

        GameMap map = new GameMap(width, height, CellType.EMPTY);
        for (int y = 0; y < height; y++) {
            String line = scanner.nextLine();
            for (int x = 0; x < width; x++) {
                if (x < line.length()) {
                    Cell cell = map.getCell(x, y);
                    switch (line.charAt(x)) {
                        case ' ':
                            cell.setType(CellType.EMPTY);
                            break;
                        case 'f':
                            cell.setType(CellType.FIRE);
                            break;
                        case '#':
                            cell.setType(CellType.WALL);
                            break;
                        case '.':
                            cell.setType(CellType.FLOOR);
                            break;
                        case 's':
                            cell.setType(CellType.FLOOR);
                            Skeleton skeleton = new Skeleton(cell, 20, 30);
                            map.addMonsterToList(skeleton);
                            map.addActorToList(skeleton);
                            break;
                        case 'e':
                            cell.setType(CellType.DOOR);
                            break;
                        case 'd':
                            cell.setType(CellType.FLOOR);
                            Dragon dragon = new Dragon(cell, 50, 100);
                            map.addMonsterToList(dragon);
                            map.addActorToList(dragon);
                            break;
                        case 'g':
                            cell.setType(CellType.FLOOR);
                            Ghost ghost = new Ghost(cell, 10, 20);
                            map.addMonsterToList(ghost);
                            map.addActorToList(ghost);
                            break;
                        case 'p':
                            cell.setType(CellType.DEAD);
                            break;
                        case 'h':
                            cell.setType(CellType.FLOOR);
                            Hulk hulk = new Hulk(cell, 50, 150);
                            map.addMonsterToList(hulk);
                            map.addActorToList(hulk);
                            break;
                        case '@':
                            cell.setType(CellType.FLOOR);
                            Player player = new Player(cell, 10, 100);
                            map.setPlayer(player);
                            map.addActorToList(player);
                            break;
                        case 'k':
                            cell.setType(CellType.FLOOR);
                            new Key(cell);
                            break;
                        case 'I':
                            cell.setType(CellType.FLOOR);
                            new Sword(cell);
                            break;
                        case '$':
                            cell.setType(CellType.FLOOR);
                            new Gold(cell);
                            break;
                        default:
                            throw new RuntimeException("Unrecognized character: '" + line.charAt(x) + "'");
                    }
                }
            }
        }
        return map;
    }

}
