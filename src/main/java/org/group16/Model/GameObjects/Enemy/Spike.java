package org.group16.Model.GameObjects.Enemy;

import org.group16.Model.GameObjects.GameObjectType;
import org.group16.Model.GameObjects.HasHealth;
import org.group16.Model.GameObjects.IGameObject;

class Spike implements ITrap {
    private Trap innerTrap;

    Spike(int x, int y) {
        innerTrap = new Trap(GameObjectType.SPIKE_____, x, y);
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
        return innerTrap.getWidth();
    }

    @Override
    public int getHeight() {
        return innerTrap.getHeight();
    }

    @Override
    public GameObjectType getType() {
        return innerTrap.getType();
    }

    @Override
    public int getX() {
        return innerTrap.getX();
    }

    @Override
    public int getY() {
        return innerTrap.getY();
    }

    @Override
    public boolean collidesWith(IGameObject otherGameObject) {
        return innerTrap.collidesWith(otherGameObject);
    }

    @Override
    public void freeze() {
        innerTrap.freeze();
    }

    @Override
    public boolean isFrozen() {
        return innerTrap.isFrozen();
    }

    @Override
    public void dealDamage(HasHealth otherGameObject) {
        innerTrap.dealDamage(otherGameObject);
    }

    @Override
    public void triggerPowerUp(GameObjectType powerUp) {
        switch (powerUp) {
            case FREEZE____:
                innerTrap.freeze();
                break;
            default:
                break;
        }
    }
}
