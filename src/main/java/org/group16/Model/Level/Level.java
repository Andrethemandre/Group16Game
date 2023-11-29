package org.group16.Model.Level;

import java.util.HashMap;
import java.util.Map;
import java.util.Queue;

import org.group16.Model.GameObjects.Direction;
import org.group16.Model.GameObjects.GameObjectType;

import static org.group16.Model.GameObjects.GameObjectType.MOVABLE___;
import static org.group16.Model.GameObjects.GameObjectType.STATIONARY;
import static org.group16.Model.GameObjects.GameObjectType.TELEPORT__;
import static org.group16.Model.GameObjects.GameObjectType.AIR_______;
import static org.group16.Model.GameObjects.GameObjectType.BASIC_____;
import static org.group16.Model.GameObjects.GameObjectType.FREEZE____;
import static org.group16.Model.GameObjects.GameObjectType.GOAL______;
import static org.group16.Model.GameObjects.GameObjectType.PLAYER____;
import static org.group16.Model.GameObjects.GameObjectType.POWERUP___;
import static org.group16.Model.GameObjects.GameObjectType.SPEAR_____;
import static org.group16.Model.GameObjects.GameObjectType.SPIKE_____;
import static org.group16.Model.GameObjects.GameObjectType.FLYING____;

public abstract class Level {
    public final int WIDTH = 45;
    public final int HEIGHT = 30;

    private GameObjectType[][] level;
    private Map<Tuple, Metadata> metadataMap;

    public Level(GameObjectType[][] level) {
        this.level = level;
    }

    public GameObjectType[][] getLevel() {
        return level;
    }

    public GameObjectType getLevelTile(int x, int y) {
        return level[x][y];
    }

    public int getWidth() {
        return WIDTH;
    }

    public int getHeight() {
        return HEIGHT;
    }

    private boolean isValidGameObjectType(int j, int i) {
        return level[j][i] == BASIC_____ ||
                level[j][i] == MOVABLE___ ||
                level[j][i] == FLYING____;
    }

    protected abstract Queue<Metadata> createMetadata();

    void initializeMetadata() {
        metadataMap = new HashMap<>();
        Queue<Metadata> metadataQueue = createMetadata();

        for (int i = 0; i < level.length; i++) {
            for (int j = 0; j < level[i].length; j++) {
                if (isValidGameObjectType(i, j)) {
                    System.out.println("i: " + i + " j: " + j);
                    metadataMap.put(new Tuple(j, i), metadataQueue.poll());
                }
            }
        }
    }

    public Metadata getMetadata(Tuple tuple) {
        return metadataMap.get(tuple);
    }
}
