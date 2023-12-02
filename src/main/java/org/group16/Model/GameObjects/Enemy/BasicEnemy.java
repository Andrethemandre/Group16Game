package org.group16.Model.GameObjects.Enemy;

import org.group16.Model.GameObjects.AffectedByGravity;
import org.group16.Model.GameObjects.Direction;
import org.group16.Model.GameObjects.GameObjectType;

public class BasicEnemy extends MovableEnemy implements AffectedByGravity {
    private Direction horizontalDirection;
    private int patrolDistance;
    private int currentDistance;

    BasicEnemy(int x, int y, int patrolDistance, Direction horizontalDirection) {
        super(GameObjectType.BASIC_____, x, y);
        this.patrolDistance = patrolDistance;
        this.currentDistance = 0;
        this.horizontalDirection = horizontalDirection;
        setMovementSpeed(1);
    }
    
    @Override
    public void move() {
        setX(getX() + getDirectionMultiplier(horizontalDirection)*getMovementSpeed());
        currentDistance += getMovementSpeed();

        checkIfReachedDistance();
    }

    private int getDirectionMultiplier(Direction direction) {
        if (direction == Direction.RIGHT) {
            return 1;
        } else if (direction == Direction.LEFT) {
            return -1;
        } else {
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

    public int getX() {
        return super.getX();
    }


    public void setX(int x) {
        super.setX(x);
    }

    @Override
    public void updateHealth(int damage) {

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
}
