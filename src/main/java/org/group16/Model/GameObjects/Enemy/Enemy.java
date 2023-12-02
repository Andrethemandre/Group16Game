package org.group16.Model.GameObjects.Enemy;

import org.group16.Model.GameObjects.IGameObject;

import org.group16.Model.GameObjects.GameObject;
import org.group16.Model.GameObjects.GameObjectType;
import org.group16.Model.Observers.HasHealth;

class Enemy implements IEnemy {
    private GameObject innerGameObject;

    private int health;
    private int damage = 1;
    private boolean isFrozen = false;

    Enemy(GameObjectType enemyType, int x, int y, int health) {
        this(enemyType, x, y, 16, 16, health);
    }

    Enemy(GameObjectType enemyType, int x, int y, int width, int height, int health) {
        innerGameObject = new GameObject(enemyType, x, y, width, height);
        this.health = health;
    }

    // Enemy methods
    @Override
    public void dealDamage(HasHealth otherGameObject) {
        otherGameObject.updateHealth(damage);
    }

    // Game Object methods
    public void update() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    @Override
    public void updateHealth(int damage) {
        health -= damage;
    }

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
    public int getWidth() {
        return innerGameObject.getWidth();
    }

    @Override
    public int getHeight() {
        return innerGameObject.getHeight();
    }

    // HasHealth methods
    @Override
    public int getHealth() {
        return health;
    }

    @Override
    public boolean isDead() {
        return health == 0;
    }

    @Override
    public void freeze(){
        isFrozen = true;
    }

    @Override
    public boolean isFrozen(){
        return isFrozen;
    }
}
