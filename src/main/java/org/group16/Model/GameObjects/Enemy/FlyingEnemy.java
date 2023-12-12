package org.group16.Model.GameObjects.Enemy;

import org.group16.Model.GameObjects.AffectedByGravity;
import org.group16.Model.GameObjects.Direction;
import org.group16.Model.GameObjects.GameObjectType;
import org.group16.Model.GameObjects.HasHealth;
import org.group16.Model.GameObjects.IGameObject;

class FlyingEnemy implements IMovableEnemy, AffectedByGravity {
    private Direction horizontalDirection;
    private Direction verticalDirection;
    private final int patrolDistance;
    private int traveledDistance;
    private MovableEnemy innerMovableEnemy;

    public FlyingEnemy(int x, int y,int patrolDistance, Direction horizontalDirection, Direction verticalDirection) {
        innerMovableEnemy = new MovableEnemy(GameObjectType.FLYING____, x, y, 1, 1);
        this.patrolDistance = patrolDistance;
        this.horizontalDirection = horizontalDirection;
        this.verticalDirection = verticalDirection;

        this.traveledDistance = 0;
        innerMovableEnemy.setMovementSpeed(1);
    }

    @Override
    public void move() {
        moveVertically();
        moveHorizontally();
        updateTraveledDistanceAndDirection();
    }

    private void moveHorizontally() {
        int directionMultiplier = getDirectionMultiplier(horizontalDirection);
        setX(getX() + directionMultiplier * getMovementSpeed());
    }

    private void moveVertically() {
        int directionMultiplier = getDirectionMultiplier(verticalDirection);
        setY(getY() + directionMultiplier * getMovementSpeed());
    }

    private int getDirectionMultiplier(Direction direction) {
        switch (direction) {
            case RIGHT:
            case DOWN:
                return 1;
            case LEFT:
            case UP:
                return -1;
            default:
                return 0;
        }
    }

    private void updateTraveledDistanceAndDirection() {
        traveledDistance += getMovementSpeed();
        if (traveledDistance >= patrolDistance) {
            toggleDirection();
            traveledDistance = 0;
        }
    }

    public void toggleDirection() {
        if (horizontalDirection == Direction.RIGHT || horizontalDirection == Direction.LEFT) {
            horizontalDirection = horizontalDirection == Direction.RIGHT ? Direction.LEFT : Direction.RIGHT;
        }
        if (verticalDirection == Direction.UP || verticalDirection == Direction.DOWN) {
            verticalDirection = verticalDirection == Direction.DOWN ? Direction.UP : Direction.DOWN;
        }
    }

    @Override
    public boolean isDead() {
        return innerMovableEnemy.isDead();
    }

    @Override
    public void update() {
        move();
    }

    @Override
    public void updateHealth(int damage) {
        innerMovableEnemy.updateHealth(damage);
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
