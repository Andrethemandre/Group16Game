package org.group16.Model.GameObjects.Blocks;

import org.group16.Model.GameObjects.GameObjectType;
import org.group16.Model.GameObjects.IGameObject;
import org.group16.Model.GameObjects.Direction;

public class MovableBlock implements IMovableBlock {
    private int movementSpeed = 1;
    private Direction horizontalDirection;
    private Direction verticalDirection;
    private int patrolDistance;
    private int traveledDistance;
    private Block innerBlock;

    public MovableBlock(int x, int y, int patrolDistance, Direction horizontalDirection, Direction verticalDirection) {
        innerBlock = new Block(GameObjectType.MOVABLE___, x, y);
        this.patrolDistance = patrolDistance;
        this.horizontalDirection = horizontalDirection;
        this.verticalDirection = verticalDirection;
    }

    @Override
    public void move() {
        moveVertically();
        moveHorizontally();
        updateTraveledDistanceAndDirection();

    }

    private void moveHorizontally() {
        int directionMultiplier = getDirectionMultiplier(horizontalDirection);
        setX(getX() + directionMultiplier);
    }

    private void moveVertically() {
        int directionMultiplier = getDirectionMultiplier(verticalDirection);
        setY(getY() + directionMultiplier);
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
        traveledDistance += movementSpeed;
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
    public void update() {
        move();
    }

    @Override
    public int getWidth() {
        return innerBlock.getWidth();

    }

    @Override
    public int getHeight() {
        return innerBlock.getHeight();
    }

    @Override
    public int getX() {
        return innerBlock.getX();
    }

    void setX(int x) {
        innerBlock.setX(x);
    }

    @Override
    public int getY() {
        return innerBlock.getY();
    }

    void setY(int y) {
        innerBlock.setY(y);
    }

    public int getHorisontalDirectionValue() {
        int horisontalMultiplier = getDirectionMultiplier(horizontalDirection);
        return horisontalMultiplier;
    }

    public int getVerticalDirectionValue() {
        int verticalMultiplier = getDirectionMultiplier(verticalDirection);
        return verticalMultiplier;
    }

    @Override
    public GameObjectType getType() {
        return innerBlock.getType();
    }

    @Override
    public boolean collidesWith(IGameObject otherGameObject) {
        return innerBlock.collidesWith(otherGameObject);
    }

    @Override
    public Direction getDirection() {
        return horizontalDirection;
    }
}
