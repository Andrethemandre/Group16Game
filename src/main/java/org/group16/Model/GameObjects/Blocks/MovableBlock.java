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

        // move the block left

        if (xstartlocation - getX() <= 0 && getX() - 1 >= -xDirection) {
            int newlocation = getX() - xDirection;
            setX(newlocation);
        }
        // move the block right
        else if (xstartlocation - getX() >= 0 && getX() + 1 <= xDirection) {
            int newlocation = getX() + xDirection;
            setX(newlocation);
        }
        // move the block down
        else if (ystartlocation - getY() <= 0 && getY() - 1 >= -yDirection) {
            int newlocation = getY() - yDirection;
            setY(newlocation);
        }
        // move the block up
        else if (ystartlocation - getY() >= 0 && getY() + 1 <= yDirection) {
            int newlocation = getY() + yDirection;
            setY(newlocation);
        } else {
            int newlocation = xstartlocation;
            int newlocation2 = ystartlocation;
            setX(newlocation);
            setY(newlocation2);

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