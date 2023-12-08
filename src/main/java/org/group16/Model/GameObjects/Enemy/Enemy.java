package org.group16.Model.GameObjects.Enemy;

import org.group16.Model.GameObjects.IGameObject;
import org.group16.Model.GameObjects.Direction;
import org.group16.Model.GameObjects.GameObjectType;
import org.group16.Model.Observers.HasHealth;

class Enemy implements IEnemy {
    private Obstacle innerObstacle;

    private int health;

    Enemy(GameObjectType enemyType, int x, int y, int health) {
        this(enemyType, x, y, 16, 16, health);
    }

    Enemy(GameObjectType enemyType, int x, int y, int width, int height, int health) {
        innerObstacle = new Obstacle(enemyType, x, y, width, height);
        this.health = health;
    }

    // Enemy methods
    @Override
    public void dealDamage(HasHealth otherGameObject) {
        innerObstacle.dealDamage(otherGameObject);
    }

    // Game Object methods
    public void update() {
        innerObstacle.update();
    }

    @Override
    public void updateHealth(int damage) {
        health -= damage;
    }

    public EnemyBehavior<? extends MovableEnemy> getBehavior() {
        return null;
    }

    @Override
    public GameObjectType getType() {
        return innerObstacle.getType();
    }

    @Override
    public boolean collidesWith(IGameObject otherGameObject) {
        return innerObstacle.collidesWith(otherGameObject);
    }

    @Override
    public int getX() {
        return innerObstacle.getX();
    }
    
    void setX(int x) {
        innerObstacle.setX(x);
    }

    @Override
    public int getY() {
        return innerObstacle.getY();
    }

    void setY(int y) {
        innerObstacle.setY(y);
    }

    @Override
    public int getWidth() {
        return innerObstacle.getWidth();
    }

    @Override
    public int getHeight() {
        return innerObstacle.getHeight();
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

    @Override
    public Direction getDirection() {
        throw new UnsupportedOperationException("Unimplemented method 'getDirection'");
    }
}
