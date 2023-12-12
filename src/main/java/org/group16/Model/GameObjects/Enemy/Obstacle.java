package org.group16.Model.GameObjects.Enemy;

import static org.group16.Model.Utility.Settings.TILE_SIZE;

import org.group16.Model.GameObjects.GameObject;
import org.group16.Model.GameObjects.GameObjectType;
import org.group16.Model.GameObjects.HasHealth;
import org.group16.Model.GameObjects.IGameObject;

public class Obstacle implements IObstacle {
    private GameObject innerGameObject;

    private int damage;
    private boolean isFrozen = false;

    public Obstacle(GameObjectType objectType, int x, int y, int damage) {
        this(objectType, x, y, TILE_SIZE, TILE_SIZE, damage);
    }

    public Obstacle(GameObjectType objectType, int x, int y, int width, int height, int damage) {
        innerGameObject = new GameObject(objectType, x, y, width, height);
        this.damage = damage;
    }

    @Override
    public int getWidth() {
        return innerGameObject.getWidth();
    }

    @Override
    public int getHeight() {
        return innerGameObject.getHeight();
    }

    @Override
    public GameObjectType getType() {
        return innerGameObject.getType();
    }

    @Override
    public void update() {
        innerGameObject.update();
    }

    @Override
    public int getX() {
        return innerGameObject.getX();
    }

    void setX(int x) {
        innerGameObject.setX(x);
    }

    @Override
    public int getY() {
        return innerGameObject.getY();
    }

    void setY(int y) {
        innerGameObject.setY(y);
    }

    @Override
    public boolean collidesWith(IGameObject otherGameObject) {
        return innerGameObject.collidesWith(otherGameObject);
    }

    @Override
    public boolean isDead() {
        throw new UnsupportedOperationException("Unimplemented method 'isDead'");
    }

    @Override
    public void freeze() {
        isFrozen = true;
    }

    @Override
    public boolean isFrozen() {
        return isFrozen;
    }

    @Override
    public void dealDamage(HasHealth otherGameObject) {
        otherGameObject.updateHealth(damage);
    }

    @Override
    public void triggerPowerUp(GameObjectType powerUp) {
        throw new UnsupportedOperationException("Unimplemented method 'triggerPowerUp'");
    }
    
}
