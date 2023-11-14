package org.group16.Model.Level;

import org.group16.Model.GameObjects.GameObjectType;

public abstract class Level {
    public final int WIDTH = 45;
    public final int HEIGHT = 30;

    private GameObjectType[][] level;

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
}
