package org.group16.Model.GameObjects.Enemy;

import org.group16.Model.GameObjects.Direction;
import org.group16.Model.GameObjects.GameObjectType;
import org.group16.Model.GameObjects.HasHealth;
import org.group16.Model.GameObjects.IGameObject;

class MovableEnemy implements IMovableEnemy {
    private int movementSpeed;
    private final Enemy innerEnemy;

    MovableEnemy(GameObjectType enemyType, int x, int y, int health, int damage) {
        this(enemyType, x, y, 16, 16, health, damage);
    }

    MovableEnemy(GameObjectType enemyType, int x, int y, int width, int height, int health, int damage) {
        innerEnemy = new Enemy(enemyType, x, y, width, height, health, damage);
    }

    @Override
    public int getMovementSpeed(){
        return movementSpeed;
    }

    void setMovementSpeed(int movementSpeed) {
        this.movementSpeed = movementSpeed;
    }

    @Override
    public int getHealth() {
        return innerEnemy.getHealth();
    }

    @Override
    public void dealDamage(HasHealth otherGameObject) {
        innerEnemy.dealDamage(otherGameObject);
    }

    @Override
    public void update() {
        throw new UnsupportedOperationException("Unimplemented method 'update'");
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

    void setX(int x) {
        innerEnemy.setX(x);
    }

    @Override
    public int getY() {
        return innerEnemy.getY();
    }

    void setY(int y) {
        innerEnemy.setY(y);
    }

    @Override
    public boolean collidesWith(IGameObject otherGameObject) {
        return innerEnemy.collidesWith(otherGameObject);
    }

    @Override
    public void updateHealth(int damage) {
        innerEnemy.updateHealth(damage);
    }

    @Override
    public boolean isDead() {
        return innerEnemy.isDead();
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
    public void move() {
        throw new UnsupportedOperationException("Unimplemented method 'move'");
    }

    @Override
    public void toggleDirection() {
        throw new UnsupportedOperationException("Unimplemented method 'toggleDirection'");
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
