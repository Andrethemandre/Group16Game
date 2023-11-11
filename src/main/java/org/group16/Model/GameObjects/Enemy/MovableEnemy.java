package org.group16.Model.GameObjects.Enemy;

import org.group16.Model.GameObjects.Movable;

public abstract class MovableEnemy extends Enemy implements Movable {

    MovableEnemy(EnemyType enemyType) {
        super(enemyType);
    }

    @Override
    public int getHealth() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getHealth'");
    }

    @Override
    public void setHealth(int newHealth) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'setHealth'");
    }
}
