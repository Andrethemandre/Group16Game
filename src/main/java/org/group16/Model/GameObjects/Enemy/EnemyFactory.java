package org.group16.Model.GameObjects.Enemy;

import org.group16.Model.GameObjects.GameObjectType;

public class EnemyFactory {
    public static Enemy createEnemy(GameObjectType type){
        switch(type) {
            case BASIC:
                return new BasicEnemy();
            case SPIKE:
                return new Spike();
            default:
                throw new IllegalArgumentException("Enemy type is not supported");
        }
    }
}
