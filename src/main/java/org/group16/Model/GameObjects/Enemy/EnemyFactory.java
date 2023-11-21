package org.group16.Model.GameObjects.Enemy;

import org.group16.Model.GameObjects.GameObjectType;

public class EnemyFactory {
    public static Enemy createEnemyAt(GameObjectType type, int x, int y) {
        switch(type) {
            case BASIC_____:
                return new BasicEnemy(x, y,10  ,10);
            case SPIKE_____:
                return new Spike(x, y);
            default:
                throw new IllegalArgumentException("Enemy type is not supported");
        }
    }
}
