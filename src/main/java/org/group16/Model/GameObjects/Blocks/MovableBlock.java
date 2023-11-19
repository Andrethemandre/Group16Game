package org.group16.Model.GameObjects.Blocks;

import java.awt.Rectangle;
import org.group16.Model.GameObjects.GameObject;
import org.group16.Model.GameObjects.GameObjectType;

import org.group16.Model.GameObjects.Movable;
import java.io.*;
import java.lang.Thread;

public class MovableBlock extends Block implements Movable {
    public int blockspeed = 0; // speed of the block
    public int horisontalMovement = 0;
    public int verticalMovement = 0;
    private final int xstartlocation = getX();
    private final int ystartlocation = getY();
    private GameObject innerGameObject;
    private int helpx = 0;
    private int helpy = 0;
    private Boolean hasitgonemaxdistanceposx = false;
    private Boolean hasitgonemaxdistancenegx = false;
    private Boolean hasitgonemaxdistanceposy = false;
    private Boolean hasitgonemaxdistancenegy = false;

    public void setblockspeed(int blockspeed) {
        this.blockspeed = blockspeed;
    }

    public void sethorisontalMovement(int horisontalMovement) {
        this.horisontalMovement = horisontalMovement;
    }

    public void setverticalMovement(int verticalMovement) {
        this.verticalMovement = verticalMovement;
    }

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
                super.updateHitBox();
            }

            if (helpx == horisontalMovement || hasitgonemaxdistanceposx == true) {
                hasitgonemaxdistanceposx = true;
                setX(getX() - 1);
                helpx--;
                super.updateHitBox();

            }
        } else {
            // Move left
            if (hasitgonemaxdistancenegx == false && horisontalMovement != 0) {
                setX(getX() - 1);
                helpx--;
                hasitgonemaxdistanceposx = false;
                super.updateHitBox();

            }

            if (helpx == -horisontalMovement && horisontalMovement != 0 || hasitgonemaxdistancenegx == true) {
                hasitgonemaxdistancenegx = true;
                setX(getX() + 1);
                helpx++;
                super.updateHitBox();
            }
        }

        // Move in the y-direction
        if (helpy > 0) {
            // Move up starting from 1
            if (hasitgonemaxdistanceposy == false) {
                setY(getY() + 1);
                helpy++;
                hasitgonemaxdistancenegy = false;
                super.updateHitBox();
            }
            // Move down starting from yDirection
            if (helpy == verticalMovement || hasitgonemaxdistanceposy == true) {
                hasitgonemaxdistanceposy = true;
                setY(getY() - 1);
                helpy--;
                super.updateHitBox();
            }
        } else {

            // Move down starting from 0
            if (hasitgonemaxdistancenegy == false && verticalMovement != 0) {
                setY(getY() - 1);
                helpy--;
                hasitgonemaxdistanceposy = false;
                super.updateHitBox();
            }
            // Move up starting from -yDirection
            if (helpy == -verticalMovement && verticalMovement != 0 || hasitgonemaxdistancenegy == true) {
                hasitgonemaxdistancenegy = true;
                setY(getY() + 1);
                helpy++;
                super.updateHitBox();
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