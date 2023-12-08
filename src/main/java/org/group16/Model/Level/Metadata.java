package org.group16.Model.Level;

import org.group16.Model.GameObjects.Direction;

public class Metadata {
    private final int distance;
    private final Direction verticalDirection;
    private final Direction horizontalDirection;

    public Metadata(int distance, Direction horizontalDirection, Direction verticalDirection) {
        this.distance = distance;
        this.verticalDirection = verticalDirection;
        this.horizontalDirection = horizontalDirection;
    }

    public Metadata(Direction horizontalDirection) {
        this.distance = 0;
        this.verticalDirection = Direction.NONE;
        this.horizontalDirection = horizontalDirection;
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
}
