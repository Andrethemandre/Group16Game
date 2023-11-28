package org.group16.Model.GameObjects.Enemy;

import org.group16.Model.GameObjects.Direction;
import org.group16.Model.GameObjects.GameObjectType;

public class EnemyFactory {
    public static Enemy createEnemyAt(GameObjectType type, int x, int y) {
        switch(type) {
            case BASIC_____:
                return new BasicEnemy(x, y,64);
            case SPIKE_____:
                return new Spike(x, y);
            case FLYING____:
                return new FlyingEnemy(x, y, Direction.LEFT,128,true);
            case TELEPORT__:
                return new TeleportRushEnemy(x, y,100,100);
            default:
                throw new IllegalArgumentException("Enemy type is not supported");
        }
    }
}
