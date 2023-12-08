package org.group16.Model.GameObjects.Enemy;

import org.group16.Model.GameObjects.GameObjectType;
import org.group16.Model.Level.Metadata;

public class EnemyFactory {
    public static IEnemy createEnemyAt(GameObjectType type, int x, int y, Metadata metadata) {
        switch(type) {
            default:
                throw new IllegalArgumentException("Enemy type is not supported");
        }
    }

    public static IMovableEnemy createMovableEnemyAt(GameObjectType type, int x, int y, Metadata metadata) {
        switch(type) {
            case BASIC_____:
                return new BasicEnemy(x, y, metadata.getDistance(), metadata.getHorizontalDirection());
            case FLYING____:
                return new FlyingEnemy(x, y, metadata.getDistance(), metadata.getHorizontalDirection(), metadata.getVerticalDirection());

            default:
                throw new IllegalArgumentException("Enemy type is not supported");
        }
    }

    public static EnemyWithTarget createEnemyWithTargetAt(GameObjectType type, int x, int y, Metadata metadata) {
        switch(type) {
            case TELEPORT__:
                return new TeleportRushEnemy(x, y, 20, 20);
            default:
                throw new IllegalArgumentException("Enemy type is not supported");
        }
    }
}
