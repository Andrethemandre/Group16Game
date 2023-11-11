package org.group16.Model.GameObjects.Enemy;

public class EnemyFactory {
    public static Enemy createEnemy(EnemyType type){
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
