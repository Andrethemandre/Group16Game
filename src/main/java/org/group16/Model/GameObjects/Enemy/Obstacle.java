package org.group16.Model.GameObjects.Enemy;

import org.group16.Model.GameObjects.GameObject;
import org.group16.Model.GameObjects.GameObjectType;
import org.group16.Model.GameObjects.IGameObject;
import org.group16.Model.Observers.HasHealth;

public class Obstacle implements IObstacle {
    private GameObject innerGameObject;

    private int damage = 1;
    private boolean isFrozen = false;

    public Obstacle(GameObjectType objectType, int x, int y) {
        innerGameObject = new GameObject(objectType, x, y, 16, 16);
    }

    public Obstacle(GameObjectType objectType, int x, int y, int width, int height) {
        innerGameObject = new GameObject(objectType, x, y, width, height);
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
    
}
