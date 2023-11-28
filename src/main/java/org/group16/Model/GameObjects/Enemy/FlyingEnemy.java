package org.group16.Model.GameObjects.Enemy;

import org.group16.Model.GameObjects.AffectedByGravity;
import org.group16.Model.GameObjects.Direction;
import org.group16.Model.GameObjects.GameObjectType;

public class FlyingEnemy extends MovableEnemy implements AffectedByGravity {
    private Direction patrolDirection;
    private int patrolDistance;
    private int traveledDistance;
    private double timeCounter = 0;

    private boolean diagonalPattern;
    private boolean diagonalUp;

    private int maxHeight;



    public FlyingEnemy(int x, int y,Direction patrolDirection, int patrolDistance,boolean diagonalPattern){
        super(GameObjectType.FLYING____, x, y);
        this.patrolDistance = patrolDistance;
        this.patrolDirection = patrolDirection;
        this.traveledDistance = 0;
        setMovementSpeed(1);
        this.diagonalPattern = diagonalPattern;


    }



    //        timeCounter++;
//        if(timeCounter < 1.2){
//           return;
//        }
//        timeCounter = 0; // reset moveCounter

    @Override
    public void move() {
        if (diagonalPattern) {
            moveDiagonally();
        } else {
            moveHorizontally();
        }
    }

    private void moveDiagonally() {
        int directionMultiplier = getDirectionMultiplier();
        setX(getX() + directionMultiplier * getMovementSpeed());
        if (diagonalUp) {
            setY(getY() - getMovementSpeed());
        } else {
            setY(getY() + getMovementSpeed());
        }
        updateTraveledDistanceAndDirection();
    }

    private void moveHorizontally() {
        int directionMultiplier = getDirectionMultiplier();
        setX(getX() + directionMultiplier * getMovementSpeed());
        updateTraveledDistanceAndDirection();
    }

    private int getDirectionMultiplier() {
        return patrolDirection == Direction.RIGHT ? 1 : -1;
    }

    private void updateTraveledDistanceAndDirection() {
        traveledDistance += getMovementSpeed();
        if (traveledDistance >= patrolDistance) {
            toggleDirection();
            traveledDistance = 0;
            if (diagonalPattern) {
                diagonalUp = !diagonalUp;
            }
        }
    }

    public void toggleDirection() {
        patrolDirection = patrolDirection == Direction.RIGHT ? Direction.LEFT : Direction.RIGHT;
    }

    public void toggleDiagonalPattern() {
        diagonalPattern = !diagonalPattern;
    }


    @Override
    public boolean isDead() {
        return false;
    }

    @Override
    public void update() {
        move();
    }


    @Override
    public void updateHealth(int damage) {

    }
}
