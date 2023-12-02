package org.group16.Model.GameObjects.Enemy;

import org.group16.Model.GameObjects.GameObjectType;
import org.group16.Model.GameObjects.IGameObject;
import org.group16.Model.Observers.HasHealth;

public class Spike implements IEnemy {
    Enemy innerEnemy;

    Spike(int x, int y) {
        innerEnemy = new Enemy(GameObjectType.SPIKE_____, x, y, Integer.MAX_VALUE);
    }

    @Override
    public int getHealth() {
        return innerEnemy.getHealth();
    }

    // right now not very fitting for a spike to take damage.
    // but it's needed for the interface.
    // TODO: change the hierarchy so that spike doesn't have to implement HasHealth
    @Override
    public void updateHealth(int damage) {
        innerEnemy.updateHealth(damage);
    }

    @Override
    public boolean isDead() {
        return false;
    }
    
    @Override
    public void update() {
        // spike currently doesn't have to update. 
    }

    @Override
    public int getWidth() {
        return innerEnemy.getWidth();
    }

    @Override
    public int getHeight() {
        return innerEnemy.getHeight();
    }

    @Override
    public GameObjectType getType() {
        return innerEnemy.getType();
    }

    @Override
    public int getX() {
        return innerEnemy.getX();
    }

    @Override
    public int getY() {
        return innerEnemy.getY();
    }

    @Override
    public boolean collidesWith(IGameObject otherGameObject) {
        return innerEnemy.collidesWith(otherGameObject);
    }

    @Override
    public void freeze() {
        innerEnemy.freeze();
    }

    @Override
    public boolean isFrozen() {
        return innerEnemy.isFrozen();
    }

    @Override
    public void dealDamage(HasHealth otherGameObject) {
        innerEnemy.dealDamage(otherGameObject);
    }
}
