package org.group16.Model.GameObjects.Blocks;

import org.group16.Model.GameObjects.GameObjectType;
import org.group16.Model.GameObjects.Direction;

import org.group16.Model.GameObjects.Movable;

public class MovableBlock extends Block implements Movable {
    public int blockspeed = 0; // speed of the block
    public int horizontalMovement = 0; // how far the block can move(+-) in the x direction from its starting position
    public int verticalMovement = 0; // how far the block can move (+-) in the y direction from its starting position
    public Direction horizontalDirection;
    public Direction verticalDirection;
    private int patrolDistance;
    private int traveledDistance;

    public MovableBlock(int x, int y, int patrolDistance, Direction horizontalDirection, Direction verticalDirection) {
        super(GameObjectType.MOVABLE___, x, y);
        this.patrolDistance = patrolDistance;
        this.horizontalDirection = horizontalDirection;
        this.verticalDirection = verticalDirection;

    }

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
        traveledDistance += 1;
        if (traveledDistance >= patrolDistance) {
            System.out.println(traveledDistance);
            System.out.println(patrolDistance);
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

    public void update() {
        move();
    }

    @Override
    public int getWidth() {
        return super.getWidth();

    }

    @Override
    public int getHeight() {
        return super.getHeight();
    }

    @Override
    public int getX() {
        return super.getX();
    }

    public void setX(int x) {
        super.setX(x);
    }

    @Override
    public int getY() {
        return super.getY();
    }

    public void setY(int y) {
        super.setY(y);
    }

    public int isitgoingposornegh() {
        int horisontalMultiplier = getDirectionMultiplier(horizontalDirection);
        return horisontalMultiplier;
    }

    public int isitgoingposornegv() {
        int verticalMultiplier = getDirectionMultiplier(verticalDirection);
        return verticalMultiplier;
    }
}
