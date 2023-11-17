package org.group16.Model.GameObjects.Blocks;

import java.util.concurrent.TimeUnit;

import org.group16.Model.GameObjects.GameObject;
import org.group16.Model.GameObjects.GameObjectType;

import org.group16.Model.GameObjects.Movable;

public class MovableBlock extends Block implements Movable {
    // private int blockspeed; // speed of the block
    private int xDirection = 1;
    private int yDirection = 1;
    private final int xstartlocation = getX();
    private final int ystartlocation = getY();
    private GameObject innerGameObject;

    MovableBlock(int x, int y) {
        super(GameObjectType.MOVABLE___, x, y);

    }

    // Method to move the block
    public void move() {
        // Move in the x-direction
        if (xDirection > 0) {
            // Move right
            setX(getX() + 1);
            if (getX() >= xstartlocation + xDirection) {
                xDirection = -1; // Change direction
            }
        } else {
            // Move left
            setX(getX() - 1);
            if (getX() <= xstartlocation - xDirection) {
                xDirection = 1; // Change direction
            }
        }

        // Move in the y-direction
        if (yDirection > 0) {
            // Move down
            setY(getY() + 1);
            if (getY() >= ystartlocation + yDirection) {
                yDirection = -1; // Change direction
            }
        } else {
            // Move up
            setY(getY() - 1);
            if (getY() <= ystartlocation - yDirection) {
                yDirection = 1; // Change direction
            }
        }
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
        return innerGameObject.getX();
    }

    private void setX(int x) {
        innerGameObject.setX(x);
    }

    @Override
    public int getY() {
        return innerGameObject.getY();
    }

    private void setY(int y) {
        innerGameObject.setY(y);
    }
}