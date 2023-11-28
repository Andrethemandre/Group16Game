package org.group16.Model.GameObjects.Enemy;

import org.group16.Model.GameObjects.AffectedByGravity;
import org.group16.Model.GameObjects.Direction;
import org.group16.Model.GameObjects.GameObjectType;

public class FlyingEnemy extends MovableEnemy implements AffectedByGravity {
    private Direction horizontalDirection;
    private Direction verticalDirection;
    private int patrolDistance;
    private int traveledDistance;

    public FlyingEnemy(int x, int y, Direction horizontalDirection, Direction verticalDirection, int patrolDistance){
        super(GameObjectType.FLYING____, x, y);
        this.patrolDistance = patrolDistance;
        this.horizontalDirection = horizontalDirection;
        this.verticalDirection = verticalDirection;

        this.traveledDistance = 0;
        setMovementSpeed(1);
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
        if (direction == Direction.RIGHT || direction == Direction.DOWN) {
            return 1;
        } else if (direction == Direction.LEFT || direction == Direction.UP) {
            return -1;
        } else {
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
        horizontalDirection = horizontalDirection == Direction.RIGHT ? Direction.LEFT : Direction.RIGHT;
        verticalDirection = verticalDirection == Direction.DOWN ? Direction.UP : Direction.DOWN;
    }

    @Override
    public boolean isDead() {
        return false;
    }

    @Override
    public void update() {
        move();
    }


    @Override
    public void updateHealth(int damage) {

    }
}
