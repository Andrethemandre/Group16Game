package org.group16.Model.GameObjects.Enemy;

import org.group16.Model.GameObjects.CollisionBox;
import org.group16.Model.GameObjects.GameObject;
import org.group16.Model.GameObjects.GameObjectType;
import org.group16.Model.GameObjects.Positionable;
import org.group16.Model.GameObjects.Player.Player;
import org.group16.Model.Observers.Health;

public abstract class Enemy extends Positionable implements GameObject, Health /* implements Health */ {
    private CollisionBox collisionBox;
    private final GameObjectType enemyType;
    private int damage;

    Enemy(GameObjectType enemyType) {
        this.enemyType = enemyType;
    }

    @Override
    public GameObjectType getType() {
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
