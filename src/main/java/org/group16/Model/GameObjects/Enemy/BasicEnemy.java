package org.group16.Model.GameObjects.Enemy;

import org.group16.Model.GameObjects.AffectedByGravity;
import org.group16.Model.GameObjects.Direction;
import org.group16.Model.GameObjects.GameObjectType;
import org.group16.Model.GameObjects.HasHealth;
import org.group16.Model.GameObjects.IGameObject;

class BasicEnemy implements IMovableEnemy, AffectedByGravity {
    private Direction horizontalDirection;
    private final int patrolDistance;
    private int currentDistance;
    private MovableEnemy innerMovableEnemy;

    BasicEnemy(int x, int y, int patrolDistance, Direction horizontalDirection) {
        innerMovableEnemy = new MovableEnemy(GameObjectType.BASIC_____, x, y, 1, 1);
        this.patrolDistance = patrolDistance;
        this.currentDistance = 0;
        this.horizontalDirection = horizontalDirection;
        innerMovableEnemy.setMovementSpeed(1);
    }
    
    @Override
    public void move() {
        setX(getX() + getDirectionMultiplier(horizontalDirection)*getMovementSpeed());
        currentDistance += getMovementSpeed();

        checkIfReachedDistance();
    }

    private int getDirectionMultiplier(Direction direction) {
        switch (direction) {
            case RIGHT:
                return 1;
            case LEFT:
                return -1;
            default:
                return 0;
        }
    }

    private void checkIfReachedDistance() {
        if (currentDistance >= patrolDistance) {
            toggleDirection();
            currentDistance = 0;
        }
    }

    public void update() {
        move();
    }

    @Override
    public void updateHealth(int damage) {
        innerMovableEnemy.updateHealth(damage);
    }

    @Override
    public void toggleDirection() {
        switch (horizontalDirection) {
            case RIGHT:
                horizontalDirection = Direction.LEFT;
                break;

            case LEFT:
                horizontalDirection = Direction.RIGHT;
                break;

            default:
                break;
        }
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

    void setY(int y) {
        innerMovableEnemy.setY(y);
    }

    @Override
    public Direction getDirection(){
        return horizontalDirection;
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
    public boolean isDead() {
        return innerMovableEnemy.isDead();
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
        switch (powerUp) {
            case SPEAR_____:
                updateHealth(1);
                break;

            case FREEZE____:
                freeze();
                break;

            default:
                break;
        }
    }
}
