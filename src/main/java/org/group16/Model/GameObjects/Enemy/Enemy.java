package org.group16.Model.GameObjects.Enemy;

import org.group16.Model.GameObjects.CollisionBox;
import org.group16.Model.GameObjects.Positionable;
import org.group16.Model.GameObjects.Player.Player;
import org.group16.Model.Observers.Health;

public abstract class Enemy extends Positionable implements IEnemy, Health /* implements Health */ {
    private CollisionBox collisionBox;
    private final EnemyType enemyType;
    private int damage;

    Enemy(EnemyType enemyType) {
        this.enemyType = enemyType;
    }

    @Override
    public EnemyType getEnemyType() {
        return enemyType;
    }

    public void dealDamage(Player player) {

    }

    @Override
    public int getX() {
        return super.getX();
    }

    @Override
    public int getY() {
        return super.getY();
    }

    @Override
    public int getWidth() {
        return collisionBox.getWidth();
    }

    @Override
    public int getHeight() {
        return collisionBox.getHeight();
    }
}
