package org.group16.Model.GameObjects.Blocks;

import java.awt.Rectangle;
import org.group16.Model.GameObjects.GameObject;
import org.group16.Model.GameObjects.GameObjectType;

import org.group16.Model.GameObjects.Movable;

public class MovableBlock extends Block implements Movable {
    public int blockspeed = 0; // speed of the block
    public int horizontalMovement = 0;
    public int verticalMovement = 0;
    private int currentHorizontalMovement = 0;
    private int currentVerticalMovement = 0;
    private Boolean hasReachedMaxDistancePosX = false;
    private Boolean hasReachedMaxDistanceNegX = false;
    private Boolean hasReachedMaxDistancePosY = false;
    private Boolean hasReachedMaxDistanceNegY = false;
    public int horizontaldirection = 0;
    public int verticaldirection = 0;

    public void setblockspeed(int blockspeed) {
        this.blockspeed = blockspeed;
    }

    public void sethorisontalMovement(int horizontalMovement) {
        this.horizontalMovement = horizontalMovement;
    }

    public void setverticalMovement(int verticalMovement) {
        this.verticalMovement = verticalMovement;
    }

    public int getHorizontalMovement() {

        return horizontalMovement;
    }

    public int getVerticalMovement() {
        return verticalMovement;
    }

    MovableBlock(int x, int y) {
        super(GameObjectType.MOVABLE___, x, y);

    }

    public void move() {
        moveInXDirection();
        moveInYDirection();

    }

    private void moveInXDirection() {
        if (currentHorizontalMovement > 0) {
            if (!hasReachedMaxDistancePosX) {
                incrementX();
                currentHorizontalMovement++;
                hasReachedMaxDistanceNegX = false;
            }

            if (currentHorizontalMovement == horizontalMovement || hasReachedMaxDistancePosX) {
                hasReachedMaxDistancePosX = true;
                decrementX();
                currentHorizontalMovement--;
            }
        } else {
            if (!hasReachedMaxDistanceNegX && horizontalMovement != 0) {
                decrementX();
                currentHorizontalMovement--;
                hasReachedMaxDistancePosX = false;
            }

            if (currentHorizontalMovement == -horizontalMovement && horizontalMovement != 0
                    || hasReachedMaxDistanceNegX) {
                hasReachedMaxDistanceNegX = true;
                incrementX();
                currentHorizontalMovement++;
            }
        }
    }

    private void moveInYDirection() {
        if (currentVerticalMovement > 0) {
            if (!hasReachedMaxDistancePosY) {
                incrementY();
                currentVerticalMovement++;
                hasReachedMaxDistanceNegY = false;

            }

            if (currentVerticalMovement == verticalMovement || hasReachedMaxDistancePosY) {
                hasReachedMaxDistancePosY = true;
                decrementY();
                currentVerticalMovement--;
            }
        } else {
            if (!hasReachedMaxDistanceNegY && verticalMovement != 0) {
                decrementY();
                currentVerticalMovement--;
                hasReachedMaxDistancePosY = false;
            }

            if (currentVerticalMovement == -verticalMovement && verticalMovement != 0 || hasReachedMaxDistanceNegY) {
                hasReachedMaxDistanceNegY = true;
                incrementY();
                currentVerticalMovement++;
            }
        }
    }

    private void incrementX() {
        setX(getX() + 1);
    }

    private void decrementX() {
        setX(getX() - 1);
    }

    private void incrementY() {
        setY(getY() + 1);
    }

    private void decrementY() {
        setY(getY() - 1);
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
        if (currentHorizontalMovement > 0) {
            if (!hasReachedMaxDistancePosX) {
                horizontaldirection = 1;

            }

            if (currentHorizontalMovement == horizontalMovement || hasReachedMaxDistancePosX) {
                horizontaldirection = -1;

            }
        }
        if (getHorizontalMovement() == 0) {
            horizontaldirection = 0;

        }

        else {
            if (!hasReachedMaxDistanceNegX && horizontalMovement != 0) {
                horizontaldirection = -1;

            }

            if (currentHorizontalMovement == -horizontalMovement && horizontalMovement != 0
                    || hasReachedMaxDistanceNegX) {
                horizontaldirection = 1;

            }
        }
        return horizontaldirection;
    }

    public int isitgoingposornegv() {
        if (currentVerticalMovement > 0) {
            if (!hasReachedMaxDistancePosY) {
                verticaldirection = 1;

            }

            if (currentHorizontalMovement == horizontalMovement || hasReachedMaxDistancePosY) {
                verticaldirection = -1;

            }
        }
        if (getHorizontalMovement() == 0) {
            verticaldirection = 0;

        }

        else {
            if (!hasReachedMaxDistanceNegX && verticalMovement != 0) {
                verticaldirection = -1;

            }

            if (currentVerticalMovement == -verticalMovement && verticalMovement != 0
                    || hasReachedMaxDistanceNegY) {
                verticaldirection = 1;

            }
        }
        return verticaldirection;
    }
}