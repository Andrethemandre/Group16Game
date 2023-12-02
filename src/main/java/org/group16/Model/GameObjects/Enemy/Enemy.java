package org.group16.Model.GameObjects.Enemy;

import org.group16.Model.GameObjects.IGameObject;

import org.group16.Model.GameObjects.GameObject;
import org.group16.Model.GameObjects.GameObjectType;
import org.group16.Model.Observers.HasHealth;

public abstract class Enemy implements IEnemy {
    GameObject innerGameObject;

    private int damage = 1;
    private boolean isDead;
    private boolean isFrozen = false;

    Enemy(GameObjectType enemyType, int x, int y) {
        innerGameObject = new GameObject(enemyType, x, y, 16, 16);
    }

    Enemy(GameObjectType enemyType, int x,  int y, int width, int height){
        innerGameObject = new GameObject(enemyType, x, y, width, height);
    }

    // Enemy methods
    @Override
    public void dealDamage(HasHealth otherGameObject) {
        otherGameObject.updateHealth(damage);
    }

    // Game Object methods
    public abstract void update();

    @Override
    public GameObjectType getType() {
        return innerGameObject.getType();
    }

    @Override
    public boolean collidesWith(IGameObject otherGameObject) {
        return innerGameObject.collidesWith(otherGameObject);
    }

    @Override
    public int getX() {
        return innerGameObject.getX();
    }

    @Override
    public int getY() {
        return innerGameObject.getY();
    }

    void setX(int x) {
        innerGameObject.setX(x);
    }

    void setY(int y) {
        innerGameObject.setY(y);
    }

    @Override
    public int getWidth() {
        return innerGameObject.getWidth();
    }

    @Override
    public int getHeight() {
        return innerGameObject.getHeight();
    }

    // HasHealth methods
    public abstract void setHealth(int newHealth);

    public void setIsDead(boolean isDead){
        this.isDead = isDead;
    }

    public boolean isDead(){
        return isDead;
    }

    public void setFrozen(boolean frozen){
        this.isFrozen = frozen;
    }

    public boolean isFrozen(){
        return isFrozen;
    }
}
