package org.group16.Model.GameObjects.Blocks;

import java.awt.Rectangle;
import org.group16.Model.GameObjects.GameObject;
import org.group16.Model.GameObjects.GameObjectType;

import org.group16.Model.GameObjects.Movable;

public class MovableBlock extends Block implements Movable {
    // private int blockspeed; // speed of the block
    private int xDirection = 5;
    private int yDirection = 5;
    private final int xstartlocation = getX();
    private final int ystartlocation = getY();
    private GameObject innerGameObject;
    private int helpx = 0;
    private int helpy = 0;
    private Boolean hasitgonemaxdistanceposx = false;
    private Boolean hasitgonemaxdistancenegx = false;

    private Boolean hasitgonemaxdistancey = false;

    MovableBlock(int x, int y) {
        super(GameObjectType.MOVABLE___, x, y);

    }

    // Method to move the block
    public void move() {

        // Move in the x-direction
        if (helpx > 0) {
            if (hasitgonemaxdistanceposx == false) {
                // Move right
                setX(getX() + 1);
                helpx++;
                hasitgonemaxdistancenegx = false;
            }

            if (helpx == xDirection || hasitgonemaxdistanceposx == true) {
                hasitgonemaxdistanceposx = true;
                setX(getX() - 1);
                helpx--;

            }
        } else {
            // Move left
            if (hasitgonemaxdistancenegx == false) {
                setX(getX() - 1);
                helpx--;
                hasitgonemaxdistanceposx = false;

            }

            if (helpx == -xDirection || hasitgonemaxdistancenegx == true) {
                hasitgonemaxdistancenegx = true;
                setX(getX() + 1);
                helpx++;
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
}