package org.group16.Model.GameObjects.Enemy;

import org.group16.Model.GameObjects.GameObjectType;
import org.group16.Model.GameObjects.IGameObject;
import org.group16.Model.GameObjects.PowerUp.PowerUp;
import org.group16.Model.Observers.HasHealth;

class Spike implements ITrap {
    Enemy innerEnemy;

    Spike(int x, int y) {
        innerEnemy = new Enemy(GameObjectType.SPIKE_____, x, y, Integer.MAX_VALUE);
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

    @Override
    public void triggerPowerUp(GameObjectType powerUp) {
        switch (powerUp) {
            case FREEZE____:
                innerEnemy.freeze();
                break;
            default:
                break;
        }
    }
}
