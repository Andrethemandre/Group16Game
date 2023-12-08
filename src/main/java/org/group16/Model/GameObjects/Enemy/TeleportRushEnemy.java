package org.group16.Model.GameObjects.Enemy;

import org.group16.Model.GameObjects.AffectedByGravity;
import org.group16.Model.GameObjects.Direction;
import org.group16.Model.GameObjects.GameObjectType;
import org.group16.Model.GameObjects.IGameObject;
import org.group16.Model.Observers.HasHealth;

class TeleportRushEnemy extends MovableEnemy implements IMovableEnemy, AffectedByGravity, EnemyWithTarget {
    private MovableEnemy innerMovableEnemy;
    private  EnemyBehavior<TeleportRushEnemy> behavior;

    public TeleportRushEnemy(int x, int y,int width, int height) {
        super(GameObjectType.TELEPORT__, x, y, width, height, 1);
        innerMovableEnemy = new MovableEnemy(GameObjectType.TELEPORT__, x, y, width, height, 1);
        behavior = new EnemyBehavior<>(this);
    }

    @Override
    public boolean isDead() {
        return innerMovableEnemy.isDead();
    }

    @Override
    public void update() {
        behavior.update();
    }

    @Override
    public void move() {}
    

    @Override
    public void updateHealth(int damage) {
        innerMovableEnemy.updateHealth(damage);
    }

    @Override
    public void toggleDirection() {
        throw new UnsupportedOperationException("Unimplemented method 'toggleDirection'");
    }

    @Override
    public void dealDamage(HasHealth otherGameObject) {
        innerMovableEnemy.dealDamage(otherGameObject);
    }

    @Override
    public int getWidth() {
        return innerMovableEnemy.getWidth();
    }

    @Override
    public int getHeight() {
        return innerMovableEnemy.getHeight();
    }

    @Override
    public GameObjectType getType() {
        return innerMovableEnemy.getType();
    }

    @Override
    public int getX() {
        return innerMovableEnemy.getX();
    }

    void setX(int x) {
        innerMovableEnemy.setX(x);
    }

    @Override
    public int getY() {
        return innerMovableEnemy.getY();
    }

    @Override
    public boolean collidesWith(IGameObject otherGameObject) {
        return innerMovableEnemy.collidesWith(otherGameObject);
    }

    @Override
    public int getHealth() {
        return innerMovableEnemy.getHealth();
    }

    @Override
    public void freeze() {
        innerMovableEnemy.freeze();
    }

    @Override
    public boolean isFrozen() {
        return innerMovableEnemy.isFrozen();
    }

    @Override
    public int getMovementSpeed() {
        return innerMovableEnemy.getMovementSpeed();
    }

    @Override
    public void triggerPowerUp(GameObjectType powerUp) {
        // shouldn't be affected by power-ups
    }

    @Override
    public void setTargetCoordinates(int x, int y) {
        behavior.setTargetCoordinates(x, y);
    }

    @Override
    public EnemyState getCurrentState() {
        return behavior.getCurrentState();
    }

    @Override
    public Direction getDirection() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getDirection'");
    }
}




