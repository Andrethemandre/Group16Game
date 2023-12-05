package org.group16.Model.Level;

import org.group16.Model.GameObjects.Direction;
import org.group16.Model.GameObjects.Player.Player;

public class Metadata {
    private int distance;
    private Direction verticalDirection;
    private Direction horizontalDirection;
    private Player player;

    public Metadata(int distance, Direction horizontalDirection, Direction verticalDirection) {
        this.distance = distance;
        this.verticalDirection = verticalDirection;
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

    public Player getPlayer() {
        return player;
    }
}
