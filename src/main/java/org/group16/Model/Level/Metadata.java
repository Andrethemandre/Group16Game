package org.group16.Model.Level;

import org.group16.Model.GameObjects.Direction;

public class Metadata {
    private final int distance;
    private final Direction verticalDirection;
    private final Direction horizontalDirection;
    private final int destinationX;
    private final int destinationY;

    private Metadata(int distance, Direction horizontalDirection, Direction verticalDirection, int destinationX, int destinationY) {
        this.distance = distance;
        this.verticalDirection = verticalDirection;
        this.horizontalDirection = horizontalDirection;
        this.destinationX = destinationX;
        this.destinationY = destinationY;
    }

    public Metadata(int distance, Direction horizontalDirection, Direction verticalDirection) {
        this(distance, horizontalDirection, verticalDirection, 0, 0);
    }

    public Metadata(int distance, Direction horizontalDirection) {
        this(distance, horizontalDirection, Direction.NONE);
    }

    public Metadata(int destinationX, int destinationY) {
        this(0, Direction.NONE, Direction.NONE, destinationX, destinationY);
    }

    public int getDistance() {
        return distance;
    }

    public Direction getVerticalDirection() {
        return verticalDirection;
    }

    public Direction getHorizontalDirection() {
        return horizontalDirection;
    }

    public int getDestinationX() {
        return destinationX;
    }

    public int getDestinationY() {
        return destinationY;
    }
}
