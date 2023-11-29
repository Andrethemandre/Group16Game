package org.group16.Model.GameObjects.Enemy;

import org.group16.Model.GameObjects.Direction;
import org.group16.Model.GameObjects.GameObjectType;
import org.group16.Model.Level.Metadata;

public class EnemyFactory {
    public static Enemy createEnemyAt(GameObjectType type, int x, int y, Metadata metadata) {
        switch(type) {
            case BASIC_____:
                return new BasicEnemy(x, y, metadata.getDistance());
            case SPIKE_____:
                return new Spike(x, y);
            case FLYING____:
                return new FlyingEnemy(x, y, metadata.getDistance(), metadata.getHorizontalDirection(), metadata.getVerticalDirection());
            case TELEPORT__:
                return new TeleportRushEnemy(x, y,100,100);  
            default:
                throw new IllegalArgumentException("Enemy type is not supported");
        }
    }
}
