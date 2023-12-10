package org.group16.Model.Level;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
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
import static org.group16.Model.GameObjects.GameObjectType.TELEPORTER;

public abstract class Level {
    private final int WIDTH = 45;
    private final int HEIGHT = 30;
    private final int levelNumber;

    private final GameObjectType[][] levelLayout;
    private Map<Tuple, Metadata> metadataMap;

    public Level(GameObjectType[][] level, int levelNumber) {
        this.levelLayout = level;
        this.levelNumber = levelNumber;
        initializeMetadata();
    }

    public GameObjectType[][] getLevelLayout() {
        return levelLayout;
    }

    public GameObjectType getLevelTile(int x, int y) {
        return levelLayout[x][y];
    }

    public int getWidth() {
        return WIDTH;
    }

    public int getHeight() {
        return HEIGHT;
    }

    private boolean isGameObjectTypeWithMetadata(int j, int i) {
        return levelLayout[j][i] == BASIC_____ ||
                levelLayout[j][i] == MOVABLE___ ||
                levelLayout[j][i] == FLYING____ ||
                levelLayout[j][i] == TELEPORTER;
    }

    protected abstract Queue<Metadata> createMetadata();

    void initializeMetadata() {
        metadataMap = new HashMap<>();
        Queue<Metadata> metadataQueue = createMetadata();

        for (int i = 0; i < levelLayout.length; i++) {
            for (int j = 0; j < levelLayout[i].length; j++) {
                if (isGameObjectTypeWithMetadata(i, j)) {
                    metadataMap.put(new Tuple(j, i), metadataQueue.poll());
                }
            }
        }
    }

    public Metadata getMetadata(Tuple tuple) {
        return metadataMap.get(tuple);
    }

    public int getLevelNumber() {
        return levelNumber;
    }
}
