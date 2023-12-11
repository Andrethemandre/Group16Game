package org.group16.Model.GameObjects.Enemy;

import org.group16.Model.GameObjects.GameObjectType;
import org.group16.Model.GameObjects.HasHealth;
import org.group16.Model.GameObjects.IGameObject;

class Trap implements ITrap {
    private Obstacle innerObstacle;

    public Trap(GameObjectType objectType, int x, int y) {
        innerObstacle = new Obstacle(objectType, x, y);
    }

    @Override
    public void dealDamage(HasHealth otherGameObject) {
        innerObstacle.dealDamage(otherGameObject);
    }

    @Override
    public int getWidth() {
        return innerObstacle.getWidth();
    }

    @Override
    public int getHeight() {
        return innerObstacle.getHeight();
    }

    @Override
    public GameObjectType getType() {
        return innerObstacle.getType();
    }

    @Override
    public void update() {
        innerObstacle.update();
    }

    @Override
    public int getX() {
        return innerObstacle.getX();
    }

    @Override
    public int getY() {
        return innerObstacle.getY();
    }

    @Override
    public boolean collidesWith(IGameObject otherGameObject) {
        return innerObstacle.collidesWith(otherGameObject);
    }

    @Override
    public boolean isDead() {
        return innerObstacle.isDead();
    }

    @Override
    public void freeze() {
        innerObstacle.freeze();
    }

    @Override
    public boolean isFrozen() {
        return innerObstacle.isFrozen();
    }

    @Override
    public void triggerPowerUp(GameObjectType powerUp) {
        throw new UnsupportedOperationException("Unimplemented method 'triggerPowerUp'");
    }
}